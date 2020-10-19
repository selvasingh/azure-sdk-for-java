// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.security.keyvault.jca;

/**
 * The RestClientFactory.
 *
 * @author Manfred Riem (manfred.riem@microsoft.com)
 */
class RestClientFactory {

    /**
     * Constructor.
     */
    private RestClientFactory() {
    }

    /**
     * Static helper method to create a RestClient.
     *
     * @return the RestClient.
     */
    static RestClient createClient() {
        return new LegacyRestClient();
    }
}
