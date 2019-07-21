/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_06_01;

import com.microsoft.azure.management.network.v2019_06_01.implementation.SubnetInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.SubResource;

/**
 * IP configuration profile child resource.
 */
@JsonFlatten
public class IPConfigurationProfile extends SubResource {
    /**
     * The reference of the subnet resource to create a container network
     * interface ip configuration.
     */
    @JsonProperty(value = "properties.subnet")
    private SubnetInner subnet;

    /**
     * The provisioning state of the resource.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private String provisioningState;

    /**
     * The name of the resource. This name can be used to access the resource.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * Sub Resource type.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag")
    private String etag;

    /**
     * Get the reference of the subnet resource to create a container network interface ip configuration.
     *
     * @return the subnet value
     */
    public SubnetInner subnet() {
        return this.subnet;
    }

    /**
     * Set the reference of the subnet resource to create a container network interface ip configuration.
     *
     * @param subnet the subnet value to set
     * @return the IPConfigurationProfile object itself.
     */
    public IPConfigurationProfile withSubnet(SubnetInner subnet) {
        this.subnet = subnet;
        return this;
    }

    /**
     * Get the provisioning state of the resource.
     *
     * @return the provisioningState value
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the name of the resource. This name can be used to access the resource.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name of the resource. This name can be used to access the resource.
     *
     * @param name the name value to set
     * @return the IPConfigurationProfile object itself.
     */
    public IPConfigurationProfile withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get sub Resource type.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

    /**
     * Get a unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Set a unique read-only string that changes whenever the resource is updated.
     *
     * @param etag the etag value to set
     * @return the IPConfigurationProfile object itself.
     */
    public IPConfigurationProfile withEtag(String etag) {
        this.etag = etag;
        return this;
    }

}
