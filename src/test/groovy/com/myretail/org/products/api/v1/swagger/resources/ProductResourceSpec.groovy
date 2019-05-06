package com.myretail.org.products.api.v1.swagger.resources

import com.myretail.org.products.api.v1.swagger.model.Product
import com.myretail.org.products.api.v1.swagger.model.ProductCurrentPrice
import com.myretail.org.products.domain.CurrencyCode
import com.myretail.org.products.domain.Price
import com.myretail.org.products.domain.ProductEntity
import spock.lang.Specification

class ProductResourceSpec extends Specification {

  def "maps product resource to domain"() {
    given:
    Product resource = new Product(id: 123456, name: "test", currentPrice: new ProductCurrentPrice(value: 55.12, currencyCode: "CAD"))
    when:
    def domain = ProductResource.toDomain(resource)
    then:
    with(domain) {
      id == 123456
      name == "test"
      price.value == 55.12
      price.currencyCode == CurrencyCode.CAD
    }

  }

  def "maps product domain to resource"() {
    given:
    ProductEntity domain = new ProductEntity(987654321, "domain", new Price(1000.22, CurrencyCode.EUR))
    when:
    def resource = ProductResource.toResource(domain)
    then:
    with(resource) {
      id == 987654321
      name == "domain"
      currentPrice.value == 1000.22
      currentPrice.currencyCode == CurrencyCode.EUR.name()
    }
  }
}
