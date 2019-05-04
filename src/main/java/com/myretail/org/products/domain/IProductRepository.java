package com.myretail.org.products.domain;

/**
 * Maintains product information in persisted storage
 */
public interface IProductRepository {

  /**
   * Fetches a persisted product by ID
   *
   * @param id uniqueIdentifier for the product
   */
  ProductEntity getById(int id) throws EntityNotFoundException;

  /**
   * Saves a product to the repository.  Does an upsert so will either insert a new object or replace an existing.
   * @param productEntity product to create or update
   */
  ProductEntity save(ProductEntity productEntity);

  /**
   * Updates an existing product.  Will replace the entire product.
   * @param productEntity product
   * @return the updated product
   */
  ProductEntity update(ProductEntity productEntity) throws EntityNotFoundException;


}
