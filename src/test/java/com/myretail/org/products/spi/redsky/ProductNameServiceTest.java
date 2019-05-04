package com.myretail.org.products.spi.redsky;

import com.myretail.org.products.domain.EntityNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductNameServiceTest {

  @Autowired
  ProductNameService productNameService;

  @Test
  public void getProductName() throws EntityNotFoundException {
    //given
    int id = 13860428;
    String expected = "The Big Lebowski (Blu-ray)";
    //when
    String result = productNameService.getProductName(id);
    //then
    assertEquals(expected, result);
  }

  @Test(expected = EntityNotFoundException.class)
  public void productNotFoundInRedskyThrowsNotFoundException() throws EntityNotFoundException {
    //given
    int id = 1;
    //when
    productNameService.getProductName(id);
  }

}