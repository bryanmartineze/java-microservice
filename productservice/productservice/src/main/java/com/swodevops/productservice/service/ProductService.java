package com.swodevops.productservice.service;

import com.swodevops.productservice.dto.Product;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    boolean deleteProduct(Long id);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
}
