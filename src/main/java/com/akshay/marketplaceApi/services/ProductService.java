package com.akshay.marketplaceApi.services;

import com.akshay.marketplaceApi.payloads.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(int ProductId);
    boolean buyProduct(int productId, int buyer, int quantity);
    void deleteProduct(int productId);
}
