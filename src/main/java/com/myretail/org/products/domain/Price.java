package com.myretail.org.products.domain;

import java.math.BigDecimal;
import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Price price = (Price) o;
    return Objects.equals(value, price.value) &&
        currencyCode == price.currencyCode;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, currencyCode);
  }

  public BigDecimal getValue() {
    return value;
  }

  public CurrencyCode getCurrencyCode() {
    return currencyCode;
  }
}
