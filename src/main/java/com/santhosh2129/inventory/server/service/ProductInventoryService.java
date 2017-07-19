package com.santhosh2129.inventory.server.service;

import com.santhosh2129.inventory.common.persistence.entity.ProductEntity;
import com.santhosh2129.inventory.server.rest.entity.StoreProductRequest;

/**
 * Created by santhosh on 7/2/17.
 */
public interface ProductInventoryService {
    public void storeProduct(StoreProductRequest storeProductRequest);

    public ProductEntity getProduct(String productId);
}
