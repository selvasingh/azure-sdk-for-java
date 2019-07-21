/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_06_01;

import com.microsoft.azure.arm.collection.SupportsCreating;
import com.microsoft.azure.arm.resources.collection.SupportsDeletingByResourceGroup;
import com.microsoft.azure.arm.resources.collection.SupportsBatchDeletion;
import com.microsoft.azure.arm.resources.collection.SupportsGettingByResourceGroup;
import rx.Observable;
import com.microsoft.azure.arm.resources.collection.SupportsListingByResourceGroup;
import com.microsoft.azure.management.network.v2019_06_01.implementation.ConnectionSharedKeyInner;
import com.microsoft.azure.management.network.v2019_06_01.implementation.VirtualNetworkGatewayConnectionsInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing VirtualNetworkGatewayConnections.
 */
public interface VirtualNetworkGatewayConnections extends SupportsCreating<VirtualNetworkGatewayConnection.DefinitionStages.Blank>, SupportsDeletingByResourceGroup, SupportsBatchDeletion, SupportsGettingByResourceGroup<VirtualNetworkGatewayConnection>, SupportsListingByResourceGroup<VirtualNetworkGatewayConnection>, HasInner<VirtualNetworkGatewayConnectionsInner> {
    /**
     * The Put VirtualNetworkGatewayConnectionSharedKey operation sets the virtual network gateway connection shared key for passed virtual network gateway connection in the specified resource group through Network resource provider.
     *
     * @param resourceGroupName The name of the resource group.
     * @param virtualNetworkGatewayConnectionName The virtual network gateway connection name.
     * @param parameters Parameters supplied to the Begin Set Virtual Network Gateway connection Shared key operation throughNetwork resource provider.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ConnectionSharedKey> setSharedKeyAsync(String resourceGroupName, String virtualNetworkGatewayConnectionName, ConnectionSharedKeyInner parameters);

    /**
     * The Get VirtualNetworkGatewayConnectionSharedKey operation retrieves information about the specified virtual network gateway connection shared key through Network resource provider.
     *
     * @param resourceGroupName The name of the resource group.
     * @param virtualNetworkGatewayConnectionName The virtual network gateway connection shared key name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ConnectionSharedKey> getSharedKeyAsync(String resourceGroupName, String virtualNetworkGatewayConnectionName);

    /**
     * The VirtualNetworkGatewayConnectionResetSharedKey operation resets the virtual network gateway connection shared key for passed virtual network gateway connection in the specified resource group through Network resource provider.
     *
     * @param resourceGroupName The name of the resource group.
     * @param virtualNetworkGatewayConnectionName The virtual network gateway connection reset shared key Name.
     * @param keyLength The virtual network connection reset shared key length, should between 1 and 128.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ConnectionResetSharedKey> resetSharedKeyAsync(String resourceGroupName, String virtualNetworkGatewayConnectionName, int keyLength);

}
