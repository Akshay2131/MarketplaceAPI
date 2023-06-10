package com.akshay.marketplaceApi.services.impl;

import com.akshay.marketplaceApi.entities.Product;
import com.akshay.marketplaceApi.exceptions.ResourceNotFoundException;
import com.akshay.marketplaceApi.payloads.ProductDto;
import com.akshay.marketplaceApi.repositories.ProductRepo;
import com.akshay.marketplaceApi.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = this.modelMapper.map(productDto, Product.class);
        Product savedProduct = this.productRepo.save(product);
        return this.modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = this.productRepo.findAll();
        List<ProductDto> productDtos = products.stream().map(product -> this.modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public ProductDto getProductById(int productId) {
        Product product = this.productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("product", "id", productId));
        return this.modelMapper.map(product, ProductDto.class);
    }

    @Override
    @Transactional
    public boolean buyProduct(int productId, int buyerId, int quantity) {
        Product product = this.productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("product", "id", productId));
        if(product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            return true;
        }
        return false;
    }

    @Override
    public void deleteProduct(int productId) {
        Product product = this.productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("product", "id", productId));
        this.productRepo.delete(product);
    }
}
