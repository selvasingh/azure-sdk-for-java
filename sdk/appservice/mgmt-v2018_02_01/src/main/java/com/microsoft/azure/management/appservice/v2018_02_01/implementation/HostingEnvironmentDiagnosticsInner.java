/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.v2018_02_01.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Diagnostics for an App Service Environment.
 */
public class HostingEnvironmentDiagnosticsInner {
    /**
     * Name/identifier of the diagnostics.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * Diagnostics output.
     */
    @JsonProperty(value = "diagnosicsOutput")
    private String diagnosicsOutput;

    /**
     * Get name/identifier of the diagnostics.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set name/identifier of the diagnostics.
     *
     * @param name the name value to set
     * @return the HostingEnvironmentDiagnosticsInner object itself.
     */
    public HostingEnvironmentDiagnosticsInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get diagnostics output.
     *
     * @return the diagnosicsOutput value
     */
    public String diagnosicsOutput() {
        return this.diagnosicsOutput;
    }

    /**
     * Set diagnostics output.
     *
     * @param diagnosicsOutput the diagnosicsOutput value to set
     * @return the HostingEnvironmentDiagnosticsInner object itself.
     */
    public HostingEnvironmentDiagnosticsInner withDiagnosicsOutput(String diagnosicsOutput) {
        this.diagnosicsOutput = diagnosicsOutput;
        return this;
    }

}