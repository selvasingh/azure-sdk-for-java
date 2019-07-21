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
import com.microsoft.azure.management.network.v2019_06_01.LoadBalancerNetworkInterfaces;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.network.v2019_06_01.LoadBalancerNetworkInterface;

class LoadBalancerNetworkInterfacesImpl extends WrapperImpl<LoadBalancerNetworkInterfacesInner> implements LoadBalancerNetworkInterfaces {
    private final NetworkManager manager;

    LoadBalancerNetworkInterfacesImpl(NetworkManager manager) {
        super(manager.inner().loadBalancerNetworkInterfaces());
        this.manager = manager;
    }

    public NetworkManager manager() {
        return this.manager;
    }

    private LoadBalancerNetworkInterfaceImpl wrapModel(NetworkInterfaceInner inner) {
        return  new LoadBalancerNetworkInterfaceImpl(inner, manager());
    }

    @Override
    public Observable<LoadBalancerNetworkInterface> listAsync(final String resourceGroupName, final String loadBalancerName) {
        LoadBalancerNetworkInterfacesInner client = this.inner();
        return client.listAsync(resourceGroupName, loadBalancerName)
        .flatMapIterable(new Func1<Page<NetworkInterfaceInner>, Iterable<NetworkInterfaceInner>>() {
            @Override
            public Iterable<NetworkInterfaceInner> call(Page<NetworkInterfaceInner> page) {
                return page.items();
            }
        })
        .map(new Func1<NetworkInterfaceInner, LoadBalancerNetworkInterface>() {
            @Override
            public LoadBalancerNetworkInterface call(NetworkInterfaceInner inner) {
                return wrapModel(inner);
            }
        });
    }

}
