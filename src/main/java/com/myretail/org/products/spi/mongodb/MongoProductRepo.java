package com.myretail.org.products.spi.mongodb;

import com.myretail.org.products.domain.EntityNotFoundException;
import com.myretail.org.products.domain.IProductRepository;
import com.myretail.org.products.domain.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Maintains product information in MongoDb
 */
@Repository
public class MongoProductRepo implements IProductRepository {

  private final ProductRepository repo;

  @Autowired
  public MongoProductRepo(ProductRepository repo) {
    this.repo = repo;
  }

  @Override
  public ProductEntity getById(int id) throws EntityNotFoundException {
    return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("blah"));
  }

  @Override
  public ProductEntity save(ProductEntity productEntity) {
    return repo.save(productEntity);
  }

  @Override
  public ProductEntity update(ProductEntity productEntity) throws EntityNotFoundException {
    getById(productEntity.getId());
    return save(productEntity);
  }


}
