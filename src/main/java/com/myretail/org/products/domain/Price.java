package com.myretail.org.products.domain;

import java.math.BigDecimal;

/**
 * Value Object to store price information
 */
public class Price {

  private final BigDecimal value;
  private final CurrencyCode currencyCode;

  public Price(BigDecimal value, CurrencyCode currencyCode) {
    this.value = value;
    this.currencyCode = currencyCode;
  }

  public BigDecimal getValue() {
    return value;
  }

  public CurrencyCode getCurrencyCode() {
    return currencyCode;
  }
}
