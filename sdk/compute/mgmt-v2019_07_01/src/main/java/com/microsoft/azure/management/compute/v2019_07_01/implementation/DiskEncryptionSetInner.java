/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute.v2019_07_01.implementation;

import com.microsoft.azure.management.compute.v2019_07_01.EncryptionSetIdentity;
import com.microsoft.azure.management.compute.v2019_07_01.KeyVaultAndKeyReference;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * disk encryption set resource.
 */
@JsonFlatten
public class DiskEncryptionSetInner extends Resource {
    /**
     * The identity property.
     */
    @JsonProperty(value = "identity")
    private EncryptionSetIdentity identity;

    /**
     * The key vault key which is currently used by this disk encryption set.
     */
    @JsonProperty(value = "properties.activeKey")
    private KeyVaultAndKeyReference activeKey;

    /**
     * A readonly collection of key vault keys previously used by this disk
     * encryption set while a key rotation is in progress. It will be empty if
     * there is no ongoing key rotation.
     */
    @JsonProperty(value = "properties.previousKeys", access = JsonProperty.Access.WRITE_ONLY)
    private List<KeyVaultAndKeyReference> previousKeys;

    /**
     * The disk encryption set provisioning state.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private String provisioningState;

    /**
     * Get the identity value.
     *
     * @return the identity value
     */
    public EncryptionSetIdentity identity() {
        return this.identity;
    }

    /**
     * Set the identity value.
     *
     * @param identity the identity value to set
     * @return the DiskEncryptionSetInner object itself.
     */
    public DiskEncryptionSetInner withIdentity(EncryptionSetIdentity identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get the key vault key which is currently used by this disk encryption set.
     *
     * @return the activeKey value
     */
    public KeyVaultAndKeyReference activeKey() {
        return this.activeKey;
    }

    /**
     * Set the key vault key which is currently used by this disk encryption set.
     *
     * @param activeKey the activeKey value to set
     * @return the DiskEncryptionSetInner object itself.
     */
    public DiskEncryptionSetInner withActiveKey(KeyVaultAndKeyReference activeKey) {
        this.activeKey = activeKey;
        return this;
    }

    /**
     * Get a readonly collection of key vault keys previously used by this disk encryption set while a key rotation is in progress. It will be empty if there is no ongoing key rotation.
     *
     * @return the previousKeys value
     */
    public List<KeyVaultAndKeyReference> previousKeys() {
        return this.previousKeys;
    }

    /**
     * Get the disk encryption set provisioning state.
     *
     * @return the provisioningState value
     */
    public String provisioningState() {
        return this.provisioningState;
    }

}