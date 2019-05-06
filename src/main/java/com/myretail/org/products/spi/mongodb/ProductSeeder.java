package com.myretail.org.products.spi.mongodb;

import com.myretail.org.products.domain.CurrencyCode;
import com.myretail.org.products.domain.Price;
import com.myretail.org.products.domain.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Seeds some sample products to user during testing
 */
@Component
public class ProductSeeder {

  private final MongoProductRepo mongoProductRepo;

  @Autowired
  public ProductSeeder(MongoProductRepo mongoProductRepo) {
    this.mongoProductRepo = mongoProductRepo;
  }

  @SuppressWarnings("unused")
  @EventListener
  public void seed(ContextRefreshedEvent ignored) {
    mongoProductRepo.save(new ProductEntity(13860428, "The Big Lebowski (Blue-ray) (Widescreen)",
        new Price(BigDecimal.valueOf(13.49), CurrencyCode.USD)));
    mongoProductRepo.save(new ProductEntity(1, "Titleist ProV1 Golf Balls",
        new Price(BigDecimal.valueOf(50.99), CurrencyCode.USD)));
  }
}
