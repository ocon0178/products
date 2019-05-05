package com.myretail.org.products.api.swagger.api;

import com.myretail.org.products.api.IProductResourceService;
import com.myretail.org.products.domain.CurrencyCode;
import com.myretail.org.products.domain.EntityNotFoundException;
import com.myretail.org.products.domain.Price;
import com.myretail.org.products.domain.ProductEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductsApiController.class)
public class ProductsApiEndpointIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private IProductResourceService productResourceService;
  private static final String NOT_FOUND = "Unable to find the product.";
  private static final String NOT_FOUND_JSON = "{\"message\":\"" + NOT_FOUND + "\"}";

  @Test
  public void contextLoads() {
    assertThat(productResourceService).isNotNull();
    assertThat(mvc).isNotNull();
  }

  @Test
  public void productByIdEndpointFetchesProductJSON() throws Exception {
    //given
    String expected = "{\"id\":15117729,\"name\":\"blah\",\"current_price\":{\"value\":99.66,\"currency_code\":\"USD\"}}";
    int id = 15117729;
    when(productResourceService.getProduct(id)).thenReturn(new ProductEntity(id, "blah",
        new Price(BigDecimal.valueOf(99.66), CurrencyCode.USD)));
    //then
    this.mvc.perform(get("/products/{id}", id)).andExpect(status().isOk()).andExpect(content().json(expected,true));
  }

  @Test
  public void productByIdNotFound() throws Exception {
    //given
    int id = 15117729;
    when(productResourceService.getProduct(id)).thenThrow(new EntityNotFoundException(NOT_FOUND));
    //then
    this.mvc.perform(get("/products/{id}", id)).andExpect(status().isNotFound()).andExpect(content().string(NOT_FOUND_JSON));
  }

  @Test
  public void updateProductById() throws Exception {
    //given
    String body = "{\"id\":15117729,\"name\":\"blah\",\"current_price\":{\"value\":99.66,\"currency_code\":\"USD\"}}";
    //then
    this.mvc.perform(put("/products/{id}", 12345).contentType(MediaType.APPLICATION_JSON_UTF8).content(body)).andExpect(status().isOk());
  }

  @Test
  public void updateProductByIdNotFound() throws Exception {
    //given
    String body = "{\"id\":15117729,\"name\":\"blah\",\"current_price\":{\"value\":99.66,\"currency_code\":\"USD\"}}";
    doThrow(new EntityNotFoundException(NOT_FOUND)).when(productResourceService).updateProduct(any(ProductEntity.class));
    //then
    this.mvc.perform(put("/products/{id}", 99).content(body).contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isNotFound()).andExpect(content().string(NOT_FOUND_JSON));
  }



}
