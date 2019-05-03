package com.myretail.org.products.domain;

/**
 * Value object to store product information
 */
public class ProductEntity {

  /**
   * Unique identifier of the product
   */
  private final int id;

  /**
   * The name of the product
   */
  private final String name;

  /**
   * Contains product price information
   */
  private final Price price;

  public ProductEntity(int id, String name, Price price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Price getPrice() {
    return price;
  }

  public int getId() {
    return id;
  }
}
