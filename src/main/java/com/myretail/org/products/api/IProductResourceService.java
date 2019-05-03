package com.myretail.org.products.api;

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
  ProductEntity getProduct(int id);

  /**
   * Updates the product by ID
   * @param id unique identifier of the product
   * @param product updated product information
   */
  void updateProduct(int id, ProductEntity product);

}
