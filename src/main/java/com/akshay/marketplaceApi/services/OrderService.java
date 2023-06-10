package com.akshay.marketplaceApi.services;

import com.akshay.marketplaceApi.payloads.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();
    OrderDto getOrderById(int orderId);
    OrderDto createOrder(OrderDto orderDto);
    OrderDto updateOrder(OrderDto orderDto, int orderId);
    void deleteOrder(int orderId);
}
