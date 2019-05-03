package com.myretail.org.products.domain;

/**
 * Value object to store product information
 */
public class ProductEntity {

  /**
   * The name of the product
   */
  private final String name;

  /**
   * Contains product price information
   */
  private final Price price;

  public ProductEntity(String name, Price price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Price getPrice() {
    return price;
  }
}
