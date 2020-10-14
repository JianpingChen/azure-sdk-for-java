/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2020_05_01.implementation;

import com.microsoft.azure.management.mediaservices.v2020_05_01.Operation;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.mediaservices.v2020_05_01.OperationDisplay;
import com.microsoft.azure.management.mediaservices.v2020_05_01.Properties;

class OperationImpl extends WrapperImpl<OperationInner> implements Operation {
    private final MediaManager manager;
    OperationImpl(OperationInner inner, MediaManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public MediaManager manager() {
        return this.manager;
    }

    @Override
    public OperationDisplay display() {
        return this.inner().display();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String origin() {
        return this.inner().origin();
    }

    @Override
    public Properties properties() {
        return this.inner().properties();
    }

}