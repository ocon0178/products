package com.myretail.org.products.api.v1.swagger.api;

import com.myretail.org.products.api.v1.IProductResourceService;
import com.myretail.org.products.api.v1.swagger.model.Product;
import com.myretail.org.products.api.v1.swagger.model.ProductCurrentPrice;
import com.myretail.org.products.domain.CurrencyCode;
import com.myretail.org.products.domain.EntityNotFoundException;
import com.myretail.org.products.domain.Price;
import com.myretail.org.products.domain.ProductEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsApiControllerIntegrationTest {

    @Autowired
    private ProductsApi api;
    @MockBean
    private IProductResourceService productResourceService;

    @Test
    public void getProductsById() throws EntityNotFoundException, NotFoundException {
        //given
        Integer id = 1;
        String name = "blah";
        BigDecimal value = BigDecimal.TEN;
        CurrencyCode currencyCode = CurrencyCode.CAD;
        ProductEntity productEntity = new ProductEntity(id, name, new Price(value, currencyCode));
        when(productResourceService.getProduct(id)).thenReturn(productEntity);
        //when
        ResponseEntity<Product> responseEntity = api.productsIdGet(id);
        //then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Product response = responseEntity.getBody();
        assertNotNull(response);
        assertEquals(response.getName(), name);
        assertEquals(CurrencyCode.valueOf(response.getCurrentPrice().getCurrencyCode()), currencyCode);
        assertEquals(response.getCurrentPrice().getValue(), value);
        assertEquals(response.getId(),id);
    }

    @Test
    public void putProductsById() throws NotFoundException {
        Integer id = 2;
        Product body = new Product();
        body.setId(id);
        body.setName("blah");
        ProductCurrentPrice currentPrice = new ProductCurrentPrice();
        currentPrice.setValue(BigDecimal.ONE);
        currentPrice.setCurrencyCode(CurrencyCode.USD.name());
        body.setCurrentPrice(currentPrice);
        ResponseEntity<Void> responseEntity = api.productsIdPut(id, body);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
