// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.security.keyvault.jca;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactorySpi;

/**
 * The KeyVault variant of the TrustManagerFactory.
 *
 * @author Manfred Riem (manfred.riem@microsoft.com)
 */
public class KeyVaultTrustManagerFactory extends TrustManagerFactorySpi {

    /**
     * Stores the logger.
     */
    private static final Logger LOGGER = Logger.getLogger(KeyVaultTrustManagerFactory.class.getName());

    /**
     * Stores the key managers.
     */
    private List<TrustManager> trustManagers = new ArrayList<>();

    @Override
    protected void engineInit(KeyStore keystore) throws KeyStoreException {
        LOGGER.entering("KeyVaultKeyManagerFactory", "engineInit", keystore);
        trustManagers.add(new KeyVaultTrustManager(keystore));
    }

    @Override
    protected void engineInit(ManagerFactoryParameters spec) throws InvalidAlgorithmParameterException {
        LOGGER.entering("KeyVaultKeyManagerFactory", "engineInit", spec);
    }

    @Override
    protected TrustManager[] engineGetTrustManagers() {
        return trustManagers.toArray(new TrustManager[0]);
    }
}
