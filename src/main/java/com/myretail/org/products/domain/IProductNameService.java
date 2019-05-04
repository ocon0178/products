package com.myretail.org.products.domain;

/**
 * Provides product names
 */
public interface IProductNameService {

  String getProductName(int productID) throws EntityNotFoundException;
}
