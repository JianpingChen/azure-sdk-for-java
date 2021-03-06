/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * def
 */

package com.microsoft.azure.management.compute.v2020_12_01.implementation;

import com.microsoft.azure.arm.resources.collection.implementation.GroupableResourcesCoreImpl;
import com.microsoft.azure.management.compute.v2020_12_01.SshPublicKeys;
import com.microsoft.azure.management.compute.v2020_12_01.SshPublicKeyResource;
import rx.Observable;
import rx.Completable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import com.microsoft.azure.arm.resources.ResourceUtilsCore;
import com.microsoft.azure.arm.utils.RXMapper;
import rx.functions.Func1;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.compute.v2020_12_01.SshPublicKeyGenerateKeyPairResult;

class SshPublicKeysImpl extends GroupableResourcesCoreImpl<SshPublicKeyResource, SshPublicKeyResourceImpl, SshPublicKeyResourceInner, SshPublicKeysInner, ComputeManager>  implements SshPublicKeys {
    protected SshPublicKeysImpl(ComputeManager manager) {
        super(manager.inner().sshPublicKeys(), manager);
    }

    @Override
    protected Observable<SshPublicKeyResourceInner> getInnerAsync(String resourceGroupName, String name) {
        SshPublicKeysInner client = this.inner();
        return client.getByResourceGroupAsync(resourceGroupName, name);
    }

    @Override
    protected Completable deleteInnerAsync(String resourceGroupName, String name) {
        SshPublicKeysInner client = this.inner();
        return client.deleteAsync(resourceGroupName, name).toCompletable();
    }

    @Override
    public Observable<String> deleteByIdsAsync(Collection<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Observable.empty();
        }
        Collection<Observable<String>> observables = new ArrayList<>();
        for (String id : ids) {
            final String resourceGroupName = ResourceUtilsCore.groupFromResourceId(id);
            final String name = ResourceUtilsCore.nameFromResourceId(id);
            Observable<String> o = RXMapper.map(this.inner().deleteAsync(resourceGroupName, name), id);
            observables.add(o);
        }
        return Observable.mergeDelayError(observables);
    }

    @Override
    public Observable<String> deleteByIdsAsync(String...ids) {
        return this.deleteByIdsAsync(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public void deleteByIds(Collection<String> ids) {
        if (ids != null && !ids.isEmpty()) {
            this.deleteByIdsAsync(ids).toBlocking().last();
        }
    }

    @Override
    public void deleteByIds(String...ids) {
        this.deleteByIds(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public PagedList<SshPublicKeyResource> listByResourceGroup(String resourceGroupName) {
        SshPublicKeysInner client = this.inner();
        return this.wrapList(client.listByResourceGroup(resourceGroupName));
    }

    @Override
    public Observable<SshPublicKeyResource> listByResourceGroupAsync(String resourceGroupName) {
        SshPublicKeysInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMapIterable(new Func1<Page<SshPublicKeyResourceInner>, Iterable<SshPublicKeyResourceInner>>() {
            @Override
            public Iterable<SshPublicKeyResourceInner> call(Page<SshPublicKeyResourceInner> page) {
                return page.items();
            }
        })
        .map(new Func1<SshPublicKeyResourceInner, SshPublicKeyResource>() {
            @Override
            public SshPublicKeyResource call(SshPublicKeyResourceInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PagedList<SshPublicKeyResource> list() {
        SshPublicKeysInner client = this.inner();
        return this.wrapList(client.list());
    }

    @Override
    public Observable<SshPublicKeyResource> listAsync() {
        SshPublicKeysInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<SshPublicKeyResourceInner>, Iterable<SshPublicKeyResourceInner>>() {
            @Override
            public Iterable<SshPublicKeyResourceInner> call(Page<SshPublicKeyResourceInner> page) {
                return page.items();
            }
        })
        .map(new Func1<SshPublicKeyResourceInner, SshPublicKeyResource>() {
            @Override
            public SshPublicKeyResource call(SshPublicKeyResourceInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public SshPublicKeyResourceImpl define(String name) {
        return wrapModel(name);
    }

    @Override
    public Observable<SshPublicKeyGenerateKeyPairResult> generateKeyPairAsync(String resourceGroupName, String sshPublicKeyName) {
        SshPublicKeysInner client = this.inner();
        return client.generateKeyPairAsync(resourceGroupName, sshPublicKeyName)
        .map(new Func1<SshPublicKeyGenerateKeyPairResultInner, SshPublicKeyGenerateKeyPairResult>() {
            @Override
            public SshPublicKeyGenerateKeyPairResult call(SshPublicKeyGenerateKeyPairResultInner inner) {
                return new SshPublicKeyGenerateKeyPairResultImpl(inner, manager());
            }
        });
    }

    @Override
    protected SshPublicKeyResourceImpl wrapModel(SshPublicKeyResourceInner inner) {
        return  new SshPublicKeyResourceImpl(inner.name(), inner, manager());
    }

    @Override
    protected SshPublicKeyResourceImpl wrapModel(String name) {
        return new SshPublicKeyResourceImpl(name, new SshPublicKeyResourceInner(), this.manager());
    }

}
