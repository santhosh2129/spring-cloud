package com.santhosh2129.inventory.server.rest.controller;


import com.santhosh2129.inventory.common.persistence.entity.ProductEntity;
import com.santhosh2129.inventory.server.rest.entity.StoreProductRequest;
import com.santhosh2129.inventory.server.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/*
 * Created by santhosh on 7/1/17.
 */

@RestController
@CrossOrigin
@RequestMapping("/santhosh2129/inventory")
public class InventoryController {

    @Autowired
    private ProductInventoryService productInventoryService;

    @RequestMapping(value = "/getproduct/{productId}", method = RequestMethod.GET)
    public ProductEntity registerModule(@PathVariable("productId") String productId) {
        return productInventoryService.getProduct(productId);
    }

    @RequestMapping(value = "/storeproduct", method = RequestMethod.POST)
    public void storeProduct(@RequestBody StoreProductRequest storeProductRequest) {
        productInventoryService.storeProduct(storeProductRequest);
    }


}
