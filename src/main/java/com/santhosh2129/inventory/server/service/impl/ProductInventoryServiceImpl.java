package com.santhosh2129.inventory.server.service.impl;

import com.santhosh2129.inventory.common.persistence.entity.ProductEntity;
import com.santhosh2129.inventory.common.persistence.repository.ProductRepository;
import com.santhosh2129.inventory.server.rest.entity.StoreProductRequest;
import com.santhosh2129.inventory.server.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by santhosh on 7/2/17.
 */
@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void storeProduct(StoreProductRequest storeProductRequest) {
        ProductEntity productEntity = new ProductEntity();
        List<ProductEntity.Price> productPriceList = new ArrayList<>();
        productEntity.setUpdateTimestamp(new Date());
        productEntity.setCreateTimestamp(new Date());
        productEntity.setProductName(storeProductRequest.getName());
        productEntity.setCategory(storeProductRequest.getCategory());
        for(Map<String,String> priceData: storeProductRequest.getPrice()){
            ProductEntity.Price price =productEntity.new Price();
            price.setQuantity(priceData.get("quantity"));
            price.setRate(Integer.parseInt(priceData.get("rate")));
            productPriceList.add(price);
        }
        productEntity.setPrice(productPriceList);
        productRepository.insert(productEntity);
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity productData = productRepository.findOne(productId);
        return productData;
    }
}
