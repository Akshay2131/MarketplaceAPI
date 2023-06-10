package com.akshay.marketplaceApi.controllers;

import com.akshay.marketplaceApi.payloads.ApiResponse;
import com.akshay.marketplaceApi.payloads.BuyRequest;
import com.akshay.marketplaceApi.payloads.ProductDto;
import com.akshay.marketplaceApi.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    //Create Product
    @PostMapping("/")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        ProductDto createProductDto = this.productService.createProduct(productDto);
        return new ResponseEntity<> (createProductDto, HttpStatus.CREATED);
    }

    //Get All Products
    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    //Get Single Product Using productId
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getSingleUser(@PathVariable("productId") Integer pid) {
        ProductDto productDto = this.productService.getProductById(pid);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    //Buy a product
    @PostMapping("/buy")
    public ResponseEntity<?> buyProduct(@RequestBody BuyRequest buyRequest) {
        boolean purchased = this.productService.buyProduct(buyRequest.getProductId(), buyRequest.getBuyerId(), buyRequest.getQuantity());
        if(purchased) {
            return ResponseEntity.ok("Product purchased successfully");
        }
        else {
            return ResponseEntity.badRequest().body("Product Out of stock");
        }
    }

    //Delete a product using productId
    @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("productId") Integer pid) {
        this.productService.deleteProduct(pid);
        return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
    }
}
