package com.myretail.org.products.spi.mongodb;

import com.myretail.org.products.domain.CurrencyCode;
import com.myretail.org.products.domain.EntityNotFoundException;
import com.myretail.org.products.domain.Price;
import com.myretail.org.products.domain.ProductEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoProductRepoIntegrationTest {

  @Autowired MongoProductRepo repo;
  @Autowired MongoTemplate mongoTemplate;

  /**
   * Clear all products from the database before each test case so we have a predictable state at the
   * start of each test
   */
  @Before
  public void clearProducts() {
    mongoTemplate.getDb().getCollection("productEntity").drop();
  }

  @Test
  public void getProduct() throws EntityNotFoundException {
    //given
    int id = 13860428;
    ProductEntity expected = new ProductEntity(id, "The Big Lebowski(Blu-ray)(WideScreen", new Price(BigDecimal.valueOf(13.49), CurrencyCode.USD));
    repo.save(expected);
    //when
    ProductEntity result = repo.getById(id);
    //then
    assertEquals(expected, result);
  }

  @Test(expected = EntityNotFoundException.class)
  public void getProductNotFoundThrowsNotFoundException() throws EntityNotFoundException {
    //given
    int id = 13860428;
    //when
    repo.getById(id);
  }

  @Test
  public void updateProduct() throws EntityNotFoundException {
    //given
    int id = 13860428;
    ProductEntity original = new ProductEntity(id, "The Big Lebowski(Blu-ray)(WideScreen)", new Price(BigDecimal.valueOf(13.49), CurrencyCode.USD));
    ProductEntity expected = new ProductEntity(id, "The Big Lebowski(DVD)(WideScreen)", new Price(BigDecimal.valueOf(9.99), CurrencyCode.CAD));
    repo.save(original);
    //when
    ProductEntity result = repo.update(expected);
    //then
    assertEquals(expected, result);
  }

  @Test(expected = EntityNotFoundException.class)
  public void updateProductNotFoundThrowsNotFoundException() throws EntityNotFoundException {
    //given
    int id = 13860428;
    //when
    repo.update(new ProductEntity(id, null, null));
  }
}