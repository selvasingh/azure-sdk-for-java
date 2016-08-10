/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.keyvault;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

public class VaultTests extends KeyVaultManagementTestBase {
    private static final String RG_NAME = "javacsmrg901";
    private static final String VAULT_NAME = "java-keyvault-901";

    @BeforeClass
    public static void setup() throws Exception {
        createClients();
    }

    @AfterClass
    public static void cleanup() throws Exception {
        resourceManager.resourceGroups().delete(RG_NAME);
    }

    @Test
    public void canCRUDVault() throws Exception {
        /*
        // CREATE
        Vault vault = keyVaultManager.vaults().define(VAULT_NAME)
                .withRegion(Region.US_WEST)
                .withNewResourceGroup(RG_NAME)
                .defineAccessPolicy()
                    .forServicePrincipal("http://nativeapp")
                    .allowKeyPermissions(KeyPermissions.LIST)
                    .allowSecretAllPermissions()
                    .attach()
                .create();
        Assert.assertNotNull(vault);
        // GET
        vault = keyVaultManager.vaults().getByGroup(RG_NAME, VAULT_NAME);
        Assert.assertNotNull(vault);
        // LIST
        List<Vault> vaults = keyVaultManager.vaults().listByGroup(RG_NAME);
        for (Vault v : vaults) {
            if (VAULT_NAME.equals(v.name())) {
                vault = v;
                break;
            }
        }
        Assert.assertNotNull(vault);
        // UPDATE
        vault.update()
                .updateAccessPolicy(vault.accessPolicies().get(0).objectId().toString())
                    .allowKeyAllPermissions()
                    .disallowSecretAllPermissions()
                    .parent()
                .apply();
        vault.update()
                .defineAccessPolicy()
                    .forServicePrincipal("http://nativeapp")
                    .allowKeyAllPermissions()
                    .attach()
                .apply();
        */
        keyVaultManager.vaults().getByGroup("RG-AzureSDK-WUS", "KV-AzureSDK")
                .update()
                .defineAccessPolicy()
                .forObjectId(UUID.fromString("794b8347-c398-4fd8-b557-37b60946e830"))
                .allowKeyPermissions(KeyPermissions.ALL)
                .allowSecretPermissions(SecretPermissions.ALL)
                .attach()
                .apply();
    }
}
