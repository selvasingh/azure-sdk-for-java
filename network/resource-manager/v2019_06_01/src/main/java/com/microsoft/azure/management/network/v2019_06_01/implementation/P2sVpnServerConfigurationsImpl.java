/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.network.v2019_06_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.network.v2019_06_01.P2sVpnServerConfigurations;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.network.v2019_06_01.P2SVpnServerConfiguration;

class P2sVpnServerConfigurationsImpl extends WrapperImpl<P2sVpnServerConfigurationsInner> implements P2sVpnServerConfigurations {
    private final NetworkManager manager;

    P2sVpnServerConfigurationsImpl(NetworkManager manager) {
        super(manager.inner().p2sVpnServerConfigurations());
        this.manager = manager;
    }

    public NetworkManager manager() {
        return this.manager;
    }

    @Override
    public P2SVpnServerConfigurationImpl define(String name) {
        return wrapModel(name);
    }

    private P2SVpnServerConfigurationImpl wrapModel(P2SVpnServerConfigurationInner inner) {
        return  new P2SVpnServerConfigurationImpl(inner, manager());
    }

    private P2SVpnServerConfigurationImpl wrapModel(String name) {
        return new P2SVpnServerConfigurationImpl(name, this.manager());
    }

    @Override
    public Observable<P2SVpnServerConfiguration> listByVirtualWanAsync(final String resourceGroupName, final String virtualWanName) {
        P2sVpnServerConfigurationsInner client = this.inner();
        return client.listByVirtualWanAsync(resourceGroupName, virtualWanName)
        .flatMapIterable(new Func1<Page<P2SVpnServerConfigurationInner>, Iterable<P2SVpnServerConfigurationInner>>() {
            @Override
            public Iterable<P2SVpnServerConfigurationInner> call(Page<P2SVpnServerConfigurationInner> page) {
                return page.items();
            }
        })
        .map(new Func1<P2SVpnServerConfigurationInner, P2SVpnServerConfiguration>() {
            @Override
            public P2SVpnServerConfiguration call(P2SVpnServerConfigurationInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<P2SVpnServerConfiguration> getAsync(String resourceGroupName, String virtualWanName, String p2SVpnServerConfigurationName) {
        P2sVpnServerConfigurationsInner client = this.inner();
        return client.getAsync(resourceGroupName, virtualWanName, p2SVpnServerConfigurationName)
        .flatMap(new Func1<P2SVpnServerConfigurationInner, Observable<P2SVpnServerConfiguration>>() {
            @Override
            public Observable<P2SVpnServerConfiguration> call(P2SVpnServerConfigurationInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((P2SVpnServerConfiguration)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String virtualWanName, String p2SVpnServerConfigurationName) {
        P2sVpnServerConfigurationsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, virtualWanName, p2SVpnServerConfigurationName).toCompletable();
    }

}
