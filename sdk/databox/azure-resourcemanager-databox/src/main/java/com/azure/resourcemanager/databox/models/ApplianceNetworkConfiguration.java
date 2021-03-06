// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.databox.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The Network Adapter configuration of a DataBox. */
@Immutable
public final class ApplianceNetworkConfiguration {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ApplianceNetworkConfiguration.class);

    /*
     * Name of the network.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /*
     * Mac Address.
     */
    @JsonProperty(value = "macAddress", access = JsonProperty.Access.WRITE_ONLY)
    private String macAddress;

    /**
     * Get the name property: Name of the network.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the macAddress property: Mac Address.
     *
     * @return the macAddress value.
     */
    public String macAddress() {
        return this.macAddress;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
