package com.myretail.org.products.domain;


import com.myretail.org.products.api.IProductResourceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Provides service methods for interacting with products
 */
@Service
public class ProductEntityService implements IProductResourceService {

  @Override
  public ProductEntity getProduct(int id) {
    return new ProductEntity("test", new Price(BigDecimal.TEN, CurrencyCode.CAD));
  }

  @Override
  public void updateProduct(int id, ProductEntity product) {

  }
}
