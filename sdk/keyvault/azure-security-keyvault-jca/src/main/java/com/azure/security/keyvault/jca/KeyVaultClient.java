// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.security.keyvault.jca;

import com.azure.security.keyvault.jca.rest.CertificateListResult;
import com.azure.security.keyvault.jca.rest.CertificateItem;
import com.azure.security.keyvault.jca.rest.CertificateBundle;
import com.azure.security.keyvault.jca.rest.SecretBundle;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

/**
 * The REST client specific to Azure KeyVault.
 *
 * @author Manfred Riem (manfred.riem@microsoft.com)
 */
class KeyVaultClient extends DelegateRestClient {

    /**
     * Stores the API version postfix.
     */
    private static final String API_VERSION_POSTFIX = "?api-version=7.1";

    /**
     * Stores the KeyVault URI.
     */
    private String keyVaultUri;

    /**
     * Stores the tenant ID.
     */
    private String tenantId;

    /**
     * Stores the client ID.
     */
    private String clientId;

    /**
     * Stores the client secret.
     */
    private String clientSecret;

    /**
     * Constructor.
     *
     * @param keyVaultUri the KeyVault URI.
     */
    public KeyVaultClient(String keyVaultUri) {
        super(RestClientFactory.createClient());
        if (!keyVaultUri.endsWith("/")) {
            keyVaultUri = keyVaultUri + "/";
        }
        this.keyVaultUri = keyVaultUri;
    }

    /**
     * Constructor.
     *
     * @param keyVaultUri the KeyVault URI.
     * @param tenantId the tenant ID.
     * @param clientId the client ID.
     * @param clientSecret the client secret.
     */
    public KeyVaultClient(String keyVaultUri, String tenantId, String clientId, String clientSecret) {
        this(keyVaultUri);
        this.tenantId = tenantId;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    /**
     * Get the access token.
     *
     * @return the access token.
     */
    private String getAccessToken() {
        String accessToken = null;
        try {
            AuthClient authClient = new AuthClient();
            String resource = URLEncoder.encode("https://vault.azure.net", "UTF-8");
            accessToken = authClient.getAuthorizationToken(resource, tenantId, clientId, clientSecret);
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        }
        return accessToken;
    }

    /**
     * Get the list of aliases.
     *
     * @return the list of aliases.
     */
    public List<String> getAliases() {
        ArrayList<String> result = new ArrayList<>();
        
        StringBuilder url = new StringBuilder();
        url.append(keyVaultUri)
                .append("certificates")
                .append(API_VERSION_POSTFIX);
        
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + getAccessToken());
        
        String body = get(url.toString(), headers);
        
        CertificateListResult certificateListResult = null;
        if (body != null) {
            JsonConverter converter = JsonConverterFactory.createJsonConverter();
            certificateListResult = (CertificateListResult) converter.fromJson(body, CertificateListResult.class);
        }
        if (certificateListResult != null && certificateListResult.getValue().size() > 0) {
            for (CertificateItem certificateItem : certificateListResult.getValue()) {
                String alias = certificateItem.getId();
                alias = alias.substring(alias.indexOf("certificates") + "certificates".length() + 1);
                result.add(alias);
            }
        }
        
        return result;
    }

    /**
     * Get the certificate bundle.
     *
     * @param alias the alias.
     * @return the certificate bundle.
     */
    private CertificateBundle getCertificateBundle(String alias) {
        CertificateBundle result = null;
        
        StringBuilder url = new StringBuilder();
        url.append(keyVaultUri)
                .append("certificates/")
                .append(alias)
                .append(API_VERSION_POSTFIX);
        
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + getAccessToken());
        
        String body = get(url.toString(), headers);
        
        if (body != null) {
            JsonConverter converter = JsonConverterFactory.createJsonConverter();
            result = (CertificateBundle) converter.fromJson(body, CertificateBundle.class);
        }
        
        return result;
    }

    /**
     * Get the certificate.
     *
     * @param alias the alias.
     * @return the certificate, or null if not found.
     */
    public Certificate getCertificate(String alias) {
        X509Certificate certificate = null;
        CertificateBundle certificateBundle = getCertificateBundle(alias);
        if (certificateBundle != null) {
            String certificateString = certificateBundle.getCer();
            if (certificateString != null) {
                try {
                    CertificateFactory cf = CertificateFactory.getInstance("X.509");
                    certificate = (X509Certificate) cf.generateCertificate(
                            new ByteArrayInputStream(Base64.getDecoder()
                                    .decode(certificateBundle.getCer())));
                } catch (CertificateException ce) {
                    ce.printStackTrace();
                }
            }
        }
        return certificate;
    }

    /**
     * Get the key.
     *
     * @param alias the alias.
     * @param password the password.
     * @return the key.
     */
    public Key getKey(String alias, char[] password) {
        Key key = null;
        CertificateBundle certificateBundle = getCertificateBundle(alias);
        if (certificateBundle != null
                && certificateBundle.getPolicy() != null
                && certificateBundle.getPolicy().getKey_props() != null
                && certificateBundle.getPolicy().getKey_props().isExportable()) {

            //
            // Because the certificate is exportable the private key is 
            // available. So we'll use the KeyVault Secrets API to get the 
            // private key.
            //
            String certificateSecretUri = certificateBundle.getSid();
            HashMap<String, String> headers = new HashMap<>();
            headers.put("Authorization", "Bearer " + getAccessToken());
            String body = get(certificateSecretUri + API_VERSION_POSTFIX, headers);
            if (body != null) {
                JsonConverter converter = JsonConverterFactory.createJsonConverter();
                SecretBundle secretBundle = (SecretBundle) converter.fromJson(body, SecretBundle.class);

                try {
                    KeyStore keyStore = KeyStore.getInstance("PKCS12");
                    keyStore.load(new ByteArrayInputStream(
                            Base64.getDecoder().decode(secretBundle.getValue())), "".toCharArray());
                    alias = keyStore.aliases().nextElement();
                    key = keyStore.getKey(alias, "".toCharArray());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            //
            // The private key is not available so the certificate cannot be
            // used for server side certificates or mTLS. Since we do not know
            // the intent of the usage at this stage we skip this key.
            //
        }
        return key;
    }
}
