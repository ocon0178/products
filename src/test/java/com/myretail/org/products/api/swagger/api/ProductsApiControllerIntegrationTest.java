package com.myretail.org.products.api.swagger.api;

import com.myretail.org.products.api.swagger.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsApiControllerIntegrationTest {

    @Autowired
    private ProductsApi api;

    @Test
    public void productsIdGetTest() {
        Integer id = 1;
        ResponseEntity<Product> responseEntity = api.productsIdGet(id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void productsIdPutTest() {
        Integer id = 2;
        Product body = new Product();
        ResponseEntity<Void> responseEntity = api.productsIdPut(id, body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
