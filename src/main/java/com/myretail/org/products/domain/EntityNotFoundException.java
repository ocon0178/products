package com.myretail.org.products.domain;

/**
 * Thrown when a requested resource is not found in the persisted storage
 */
public class EntityNotFoundException extends Exception {

  public EntityNotFoundException(String message) {
    super(message);
  }

  public EntityNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
