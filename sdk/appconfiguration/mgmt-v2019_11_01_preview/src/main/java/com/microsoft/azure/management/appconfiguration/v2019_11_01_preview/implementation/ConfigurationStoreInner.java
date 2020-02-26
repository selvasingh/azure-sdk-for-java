/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appconfiguration.v2019_11_01_preview.implementation;

import com.microsoft.azure.management.appconfiguration.v2019_11_01_preview.ResourceIdentity;
import com.microsoft.azure.management.appconfiguration.v2019_11_01_preview.ProvisioningState;
import org.joda.time.DateTime;
import com.microsoft.azure.management.appconfiguration.v2019_11_01_preview.EncryptionProperties;
import com.microsoft.azure.management.appconfiguration.v2019_11_01_preview.Sku;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * The configuration store along with all resource properties. The
 * Configuration Store will have all information to begin utilizing it.
 */
@JsonFlatten
public class ConfigurationStoreInner extends Resource {
    /**
     * The managed identity information, if configured.
     */
    @JsonProperty(value = "identity")
    private ResourceIdentity identity;

    /**
     * The provisioning state of the configuration store. Possible values
     * include: 'Creating', 'Updating', 'Deleting', 'Succeeded', 'Failed',
     * 'Canceled'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * The creation date of configuration store.
     */
    @JsonProperty(value = "properties.creationDate", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime creationDate;

    /**
     * The DNS endpoint where the configuration store API will be available.
     */
    @JsonProperty(value = "properties.endpoint", access = JsonProperty.Access.WRITE_ONLY)
    private String endpoint;

    /**
     * The encryption settings of the configuration store.
     */
    @JsonProperty(value = "properties.encryption")
    private EncryptionProperties encryption;

    /**
     * The sku of the configuration store.
     */
    @JsonProperty(value = "sku", required = true)
    private Sku sku;

    /**
     * Get the managed identity information, if configured.
     *
     * @return the identity value
     */
    public ResourceIdentity identity() {
        return this.identity;
    }

    /**
     * Set the managed identity information, if configured.
     *
     * @param identity the identity value to set
     * @return the ConfigurationStoreInner object itself.
     */
    public ConfigurationStoreInner withIdentity(ResourceIdentity identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get the provisioning state of the configuration store. Possible values include: 'Creating', 'Updating', 'Deleting', 'Succeeded', 'Failed', 'Canceled'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the creation date of configuration store.
     *
     * @return the creationDate value
     */
    public DateTime creationDate() {
        return this.creationDate;
    }

    /**
     * Get the DNS endpoint where the configuration store API will be available.
     *
     * @return the endpoint value
     */
    public String endpoint() {
        return this.endpoint;
    }

    /**
     * Get the encryption settings of the configuration store.
     *
     * @return the encryption value
     */
    public EncryptionProperties encryption() {
        return this.encryption;
    }

    /**
     * Set the encryption settings of the configuration store.
     *
     * @param encryption the encryption value to set
     * @return the ConfigurationStoreInner object itself.
     */
    public ConfigurationStoreInner withEncryption(EncryptionProperties encryption) {
        this.encryption = encryption;
        return this;
    }

    /**
     * Get the sku of the configuration store.
     *
     * @return the sku value
     */
    public Sku sku() {
        return this.sku;
    }

    /**
     * Set the sku of the configuration store.
     *
     * @param sku the sku value to set
     * @return the ConfigurationStoreInner object itself.
     */
    public ConfigurationStoreInner withSku(Sku sku) {
        this.sku = sku;
        return this;
    }

}