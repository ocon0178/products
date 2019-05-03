package com.myretail.org.products.api.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.org.products.api.IProductResourceService;
import com.myretail.org.products.api.swagger.model.Product;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-01T15:48:04.346Z[GMT]")
@Controller
public class ProductsApiController implements ProductsApi {

    private static final Logger log = LoggerFactory.getLogger(ProductsApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final IProductResourceService productService;

    @Autowired
    public ProductsApiController(ObjectMapper objectMapper, HttpServletRequest request, IProductResourceService productService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.productService = productService;
    }

    public ResponseEntity<Product> productsIdGet(@ApiParam(value = "Numeric id of the product to get",required=true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Product>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> productsIdPut(@ApiParam(value = "Numeric id of the product to get",required=true) @PathVariable("id") Integer id,@ApiParam(value = "updates the product in the data store"  )  @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
