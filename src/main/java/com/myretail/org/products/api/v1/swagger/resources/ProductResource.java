package com.myretail.org.products.api.v1.swagger.resources;

import com.myretail.org.products.api.v1.swagger.model.Product;
import com.myretail.org.products.api.v1.swagger.model.ProductCurrentPrice;
import com.myretail.org.products.domain.CurrencyCode;
import com.myretail.org.products.domain.Price;
import com.myretail.org.products.domain.ProductEntity;

/**
 * Converts products to and from internal domain
 */
public class ProductResource {

  public static ProductEntity toDomain(Product product) {
    return new ProductEntity(product.getId(), product.getName(), ProductCurrentPriceResource.toDomainObject(product.getCurrentPrice()));
  }

  public static Product toResource(ProductEntity productEntity) {
    Product product = new Product();
    product.setCurrentPrice(ProductCurrentPriceResource.toResource(productEntity.getPrice()));
    product.setName(productEntity.getName());
    product.setId(productEntity.getId());
    return product;
  }

  private static class ProductCurrentPriceResource {
    static Price toDomainObject(ProductCurrentPrice productCurrentPrice) {
      return new Price(productCurrentPrice.getValue(), CurrencyCode.valueOf(productCurrentPrice.getCurrencyCode()));
    }

    static ProductCurrentPrice toResource(Price price) {
      ProductCurrentPrice currentPrice = new ProductCurrentPrice();
      currentPrice.setCurrencyCode(price.getCurrencyCode().name());
      currentPrice.setValue(price.getValue());
      return currentPrice;
    }
  }
}
