package com.myretail.org.products.domain

import spock.lang.Specification

class ProductEntityServiceSpec extends Specification {

  ProductEntityService productEntityService
  IProductNameService productNameService = Mock()
  IProductRepository productRepository = Mock()

  def setup() {
    productEntityService = new ProductEntityService(productRepository, productNameService)
  }

  def "product includes info from external service and repository"() {
    given:
    def name = "Titleist ProV1"
    def id = 9999
    def price = new Price(50.99, CurrencyCode.USD)
    def expected = new ProductEntity(id, name, price)
    productNameService.getProductName(id) >> name
    productRepository.getById(id) >> new ProductEntity(id, null, price)
    when:
    def result = productEntityService.getProduct(id)
    then:
    result == expected
  }

  def "empty string is returned for product name if unable to look it up in redsky"() {
    given:
    def id = 1
    def price = new Price(1.99, CurrencyCode.EUR)
    def expected = new ProductEntity(id, "", price)
    productNameService.getProductName(id) >> {throw new EntityNotFoundException("unable to remember the product's name!")}
    productRepository.getById(id) >> new ProductEntity(id, "ignore", price)
    when:
    def result = productEntityService.getProduct(id)
    then:
    expected == result
  }
}
