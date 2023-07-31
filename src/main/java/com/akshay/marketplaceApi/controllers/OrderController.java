package com.akshay.marketplaceApi.controllers;

import com.akshay.marketplaceApi.payloads.ApiResponse;
import com.akshay.marketplaceApi.payloads.OrderDto;
import com.akshay.marketplaceApi.services.OrderService;
import com.akshay.marketplaceApi.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        return new ResponseEntity<>(this.orderService.getOrderById(oid), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        return new ResponseEntity<> (this.orderService.createOrder(orderDto), HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto, @PathVariable("orderId") Integer oid) {
        return ResponseEntity.ok(this.orderService.updateOrder(orderDto, oid));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable("orderId") Integer oid) {
        this.orderService.deleteOrder(oid);
        return new ResponseEntity<>(new ApiResponse("Order Deleted Successfully", true), HttpStatus.OK);
    }
}
