// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmos.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.cosmos.models.ArmResourceProperties;
import com.azure.resourcemanager.cosmos.models.SqlDatabaseGetPropertiesResource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** An Azure Cosmos DB SQL database. */
@JsonFlatten
@Fluent
public class SqlDatabaseGetResultsInner extends ArmResourceProperties {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(SqlDatabaseGetResultsInner.class);

    /*
     * The resource property.
     */
    @JsonProperty(value = "properties.resource")
    private SqlDatabaseGetPropertiesResource resource;

    /**
     * Get the resource property: The resource property.
     *
     * @return the resource value.
     */
    public SqlDatabaseGetPropertiesResource resource() {
        return this.resource;
    }

    /**
     * Set the resource property: The resource property.
     *
     * @param resource the resource value to set.
     * @return the SqlDatabaseGetResultsInner object itself.
     */
    public SqlDatabaseGetResultsInner withResource(SqlDatabaseGetPropertiesResource resource) {
        this.resource = resource;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (resource() != null) {
            resource().validate();
        }
    }
}