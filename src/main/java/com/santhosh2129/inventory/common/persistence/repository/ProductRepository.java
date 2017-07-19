package com.santhosh2129.inventory.common.persistence.repository;

import com.santhosh2129.inventory.common.persistence.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by santhosh on 7/1/17.
 */
public interface ProductRepository extends MongoRepository<ProductEntity, String>{
}
