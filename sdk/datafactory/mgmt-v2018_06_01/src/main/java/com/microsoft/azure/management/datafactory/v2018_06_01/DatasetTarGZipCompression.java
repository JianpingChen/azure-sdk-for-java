/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactory.v2018_06_01;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * The TarGZip compression method used on a dataset.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", defaultImpl = DatasetTarGZipCompression.class)
@JsonTypeName("TarGZip")
public class DatasetTarGZipCompression extends DatasetCompression {
    /**
     * The TarGZip compression level.
     */
    @JsonProperty(value = "level")
    private Object level;

    /**
     * Get the TarGZip compression level.
     *
     * @return the level value
     */
    public Object level() {
        return this.level;
    }

    /**
     * Set the TarGZip compression level.
     *
     * @param level the level value to set
     * @return the DatasetTarGZipCompression object itself.
     */
    public DatasetTarGZipCompression withLevel(Object level) {
        this.level = level;
        return this;
    }

}