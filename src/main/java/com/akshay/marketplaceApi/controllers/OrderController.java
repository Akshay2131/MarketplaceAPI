package com.akshay.marketplaceApi.controllers;

import com.akshay.marketplaceApi.entities.Order;
import com.akshay.marketplaceApi.entities.OrderProduct;
import com.akshay.marketplaceApi.entities.Product;
import com.akshay.marketplaceApi.exceptions.ResourceNotFoundException;
import com.akshay.marketplaceApi.payloads.ApiResponse;
import com.akshay.marketplaceApi.payloads.OrderDto;
import com.akshay.marketplaceApi.payloads.OrderProductDto;
import com.akshay.marketplaceApi.services.OrderProductService;
import com.akshay.marketplaceApi.services.OrderService;
import com.akshay.marketplaceApi.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(this.orderService.getAllOrders());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getSingleOrder(@PathVariable("orderId") Integer oid) {
        OrderDto orderDto = this.orderService.getOrderById(oid);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto createdOrderDto = this.orderService.createOrder(orderDto);
        return new ResponseEntity<> (createdOrderDto, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto, @PathVariable("orderId") Integer oid) {
        OrderDto updatedOrderDto = this.orderService.updateOrder(orderDto, oid);
        return ResponseEntity.ok(updatedOrderDto);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable("orderId") Integer oid) {
        this.orderService.deleteOrder(oid);
        return new ResponseEntity<>(new ApiResponse("Order Deleted Successfully", true), HttpStatus.OK);
    }
}
