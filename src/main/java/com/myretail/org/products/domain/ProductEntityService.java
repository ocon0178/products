package com.myretail.org.products.domain;


import com.myretail.org.products.api.IProductResourceService;
import org.springframework.stereotype.Service;

/**
 * Provides service methods for interacting with products
 */
@Service
public class ProductEntityService implements IProductResourceService {

  private final IProductRepository productRepository;

  public ProductEntityService(IProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public ProductEntity getProduct(int id) throws EntityNotFoundException {
    return productRepository.getById(id);
  }

  @Override
  public void updateProduct(ProductEntity product) throws EntityNotFoundException {
    productRepository.update(product);
  }
}
