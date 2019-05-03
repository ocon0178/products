package com.myretail.org.products.domain;


import com.myretail.org.products.api.IProductResourceService;
import org.springframework.stereotype.Service;

/**
 * Provides service methods for interacting with products
 */
@Service
public class ProductEntityService implements IProductResourceService {

  @Override
  public ProductEntity getProduct(int id) {
    return null;
  }

  @Override
  public void updateProduct(int id, ProductEntity product) {

  }
}
