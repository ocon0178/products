package com.myretail.org.products.api.swagger.api;

import com.myretail.org.products.api.IProductResourceService;
import com.myretail.org.products.domain.CurrencyCode;
import com.myretail.org.products.domain.Price;
import com.myretail.org.products.domain.ProductEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductsApiEndpointIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private IProductResourceService productResourceService;

  @Test
  public void contextLoads() {
    assertThat(productResourceService).isNotNull();
    assertThat(mvc).isNotNull();
  }

  @Test
  public void exampleTest() throws Exception {
    //given
    String expected = "{\"name\":\"blah\",\"currentPrice\":{\"value\":99.66,\"currency_code\":\"USD\"}}";
    int id = 15117729;
    when(productResourceService.getProduct(id)).thenReturn(new ProductEntity("blah",
        new Price(BigDecimal.valueOf(99.66), CurrencyCode.USD)));
    //then
    this.mvc.perform(get("/products/{id}", id)).andExpect(status().isOk()).andExpect(content().json(expected,true));
  }


}
