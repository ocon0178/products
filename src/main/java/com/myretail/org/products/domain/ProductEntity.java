package com.myretail.org.products.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;

/**
 * Value object to store product information
 */
public class ProductEntity {

  /**
   * Unique identifier of the product.  Will be null when creating  new product.
   */
  @Id
  private final Integer id;

  /**
   * The name of the product
   */
  private String name;

  /**
   * Contains product price information
   */
  private final Price price;

  public ProductEntity(Integer id, String name, Price price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductEntity that = (ProductEntity) o;
    return id.equals(that.id) &&
        name.equals(that.name) &&
        price.equals(that.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price);
  }

  public String getName() {
    return name;
  }

  void setName(String name) {
    this.name = name;
  }

  public Price getPrice() {
    return price;
  }

  public int getId() {
    return id;
  }
}
