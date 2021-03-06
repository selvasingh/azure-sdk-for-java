/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.support.v2020_04_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The API error details.
 */
public class ServiceError {
    /**
     * The error code.
     */
    @JsonProperty(value = "code")
    private String code;

    /**
     * The error message.
     */
    @JsonProperty(value = "message")
    private String message;

    /**
     * The target of the error.
     */
    @JsonProperty(value = "target")
    private String target;

    /**
     * The list of error details.
     */
    @JsonProperty(value = "details", access = JsonProperty.Access.WRITE_ONLY)
    private List<ServiceErrorDetail> details;

    /**
     * Get the error code.
     *
     * @return the code value
     */
    public String code() {
        return this.code;
    }

    /**
     * Set the error code.
     *
     * @param code the code value to set
     * @return the ServiceError object itself.
     */
    public ServiceError withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get the error message.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

    /**
     * Set the error message.
     *
     * @param message the message value to set
     * @return the ServiceError object itself.
     */
    public ServiceError withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the target of the error.
     *
     * @return the target value
     */
    public String target() {
        return this.target;
    }

    /**
     * Set the target of the error.
     *
     * @param target the target value to set
     * @return the ServiceError object itself.
     */
    public ServiceError withTarget(String target) {
        this.target = target;
        return this;
    }

    /**
     * Get the list of error details.
     *
     * @return the details value
     */
    public List<ServiceErrorDetail> details() {
        return this.details;
    }

}
