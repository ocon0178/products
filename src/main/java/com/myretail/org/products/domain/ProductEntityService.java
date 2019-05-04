package com.myretail.org.products.domain;


import com.myretail.org.products.api.IProductResourceService;
import org.springframework.stereotype.Service;

/**
 * Provides service methods for interacting with products
 */
@Service
public class ProductEntityService implements IProductResourceService {

  private final IProductRepository productRepository;
  private final IProductNameService productNameService;

  public ProductEntityService(IProductRepository productRepository, IProductNameService productNameService) {
    this.productRepository = productRepository;
    this.productNameService = productNameService;
  }

  @Override
  public ProductEntity getProduct(int id) throws EntityNotFoundException {
    ProductEntity productEntity = productRepository.getById(id);
    String name = "";
    try {
      name = productNameService.getProductName(id);
    } catch (EntityNotFoundException ignored) {
    }
    productEntity.setName(name);
    return productEntity;
  }

  @Override
  public void updateProduct(ProductEntity product) throws EntityNotFoundException {
    productRepository.update(product);
  }
}
