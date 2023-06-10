package com.akshay.marketplaceApi.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
    private int productId;
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotNull
    private Double price;
    @NotNull
    private Integer quantity;
}
