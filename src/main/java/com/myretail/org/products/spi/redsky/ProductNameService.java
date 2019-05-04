package com.myretail.org.products.spi.redsky;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.org.products.domain.EntityNotFoundException;
import com.myretail.org.products.domain.IProductNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Fetches product names from the external redsky api
 */
@Service
public class ProductNameService implements IProductNameService {

  private final RestTemplate restTemplate;
  private final Environment environment;
  private static final String QUERY_PARAM_EXCLUDES = "taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

  @Autowired
  public ProductNameService(RestTemplate restTemplate, Environment environment) {
    this.restTemplate = restTemplate;
    this.environment = environment;
  }

  @Override
  public String getProductName(int productID) throws EntityNotFoundException {
    String url = environment.getProperty("redsky.url") + "?excludes={excludes}";
    ResponseEntity<String> responseEntity;
    try {
      responseEntity = restTemplate.getForEntity(url, String.class, productID, QUERY_PARAM_EXCLUDES);
    } catch (HttpClientErrorException cause) {
      throw new EntityNotFoundException("Unable to determine product name.", cause);
    }
    String name = "";
    if (responseEntity.getStatusCode().is2xxSuccessful()) {
      name = parseNameFromResult(responseEntity, name);
    } else {
      throw new EntityNotFoundException("Unable to determine product name.");
    }
    return name;
  }

  private String parseNameFromResult(ResponseEntity<String> responseEntity, String name) {
    try {
      name  = new ObjectMapper().readTree(responseEntity.getBody()).get("product").get("item").
          get("product_description").get("title").asText(name);
    } catch (IOException e) {
      throw new RuntimeException("Unable to retrieve product name");
    }
    return name;
  }
}
