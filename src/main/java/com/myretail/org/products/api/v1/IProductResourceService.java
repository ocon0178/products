package com.myretail.org.products.api.v1;

import com.myretail.org.products.domain.EntityNotFoundException;
import com.myretail.org.products.domain.ProductEntity;

/**
 * Provider of service methods for interacting with Products resource
 */
public interface IProductResourceService {

  /**
   * Fetches a product by ID
   * @param id unique identifier of the product
   * @return product entity
   */
  ProductEntity getProduct(int id) throws EntityNotFoundException;

  /**
   * Updates the product
   * @param product updated product information
   */
  void updateProduct(ProductEntity product) throws EntityNotFoundException;

}
