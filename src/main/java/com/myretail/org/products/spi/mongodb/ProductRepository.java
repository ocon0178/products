package com.myretail.org.products.spi.mongodb;

import com.myretail.org.products.domain.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductEntity, Integer> {

}
