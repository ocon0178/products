package com.myretail.org.products.api.swagger.configuration;

import com.myretail.org.products.api.swagger.api.NotFoundException;
import com.myretail.org.products.api.swagger.model.InlineResponse400;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Custom exception handler to gracefully handle exceptions thrown during execution of the REST API
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  private Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

  private static final String INTERNAL_SERVER_ERROR = "Unexpected server error.  Please contact your system admin.";

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    String error = "Malformed JSON request";
    return buildResponseEntity(error, status);
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
    return buildResponseEntity(INTERNAL_SERVER_ERROR, status);
  }

  private ResponseEntity<Object> buildResponseEntity(String message, HttpStatus httpStatus) {
    InlineResponse400 inlineResponse400 = new InlineResponse400();
    inlineResponse400.message(message);
    return new ResponseEntity<>(inlineResponse400, httpStatus);
  }

  @SuppressWarnings("unused")
  @ExceptionHandler(RuntimeException.class)
  protected ResponseEntity<Object> handleEntityNotFound(RuntimeException ex) {
    logger.error("Unexpected Server Error has occurred.", ex);
    return buildResponseEntity(INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @SuppressWarnings("unused")
  @ExceptionHandler(NotFoundException.class)
  protected ResponseEntity<Object> handleEntityNotFound(NotFoundException ex) {
    logger.info("Requested product not found.", ex);
    return buildResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

}
