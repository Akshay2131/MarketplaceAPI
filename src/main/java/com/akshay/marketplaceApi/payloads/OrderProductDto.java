package com.akshay.marketplaceApi.payloads;

import com.akshay.marketplaceApi.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDto {
    private Product product;
    private Integer quantity;
}
