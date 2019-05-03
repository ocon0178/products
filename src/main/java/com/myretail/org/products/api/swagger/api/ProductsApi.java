
package com.myretail.org.products.api.swagger.api;

import com.myretail.org.products.api.swagger.model.InlineResponse400;
import com.myretail.org.products.api.swagger.model.Product;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.7).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-01T15:48:04.346Z[GMT]")
@Api(value = "products", description = "the products API")
public interface ProductsApi {

    @ApiOperation(value = "", nickname = "productsIdGet", notes = "Obtain information about the product by its unique id", response = Product.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully returned a product", response = Product.class),
        @ApiResponse(code = 400, message = "Invalid request", response = InlineResponse400.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = InlineResponse400.class) })
    @RequestMapping(value = "/products/{id}",
        produces = { MediaType.APPLICATION_JSON_VALUE },
        method = RequestMethod.GET)
    ResponseEntity<Product> productsIdGet(@ApiParam(value = "Numeric id of the product to get", required = true) @PathVariable("id") Integer id);


    @ApiOperation(value = "", nickname = "productsIdPut", notes = "Updates the product by its unique id", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succesfully updated the product"),
        @ApiResponse(code = 400, message = "Invalid request", response = InlineResponse400.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = InlineResponse400.class) })
    @RequestMapping(value = "/products/{id}",
        produces = { "*/*" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> productsIdPut(@ApiParam(value = "Numeric id of the product to get", required = true) @PathVariable("id") Integer id, @ApiParam(value = "updates the product in the data store") @Valid @RequestBody Product body);

}
