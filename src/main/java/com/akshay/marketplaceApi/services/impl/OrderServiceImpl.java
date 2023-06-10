package com.akshay.marketplaceApi.services.impl;

import com.akshay.marketplaceApi.entities.Order;
import com.akshay.marketplaceApi.exceptions.ResourceNotFoundException;
import com.akshay.marketplaceApi.payloads.OrderDto;
import com.akshay.marketplaceApi.repositories.OrderRepo;
import com.akshay.marketplaceApi.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = this.orderRepo.findAll();
        List<OrderDto> orderDtos = orders.stream().map(order -> this.modelMapper.map(order, OrderDto.class)).collect(Collectors.toList());
        return orderDtos;
    }

    @Override
    public OrderDto getOrderById(int orderId) {
        Order order = this.orderRepo.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("order", "id", orderId));
        return this.modelMapper.map(order, OrderDto.class);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = this.modelMapper.map(orderDto, Order.class);
        Order savedOrder = this.orderRepo.save(order);
        return this.modelMapper.map(savedOrder, OrderDto.class);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, int orderId) {
        Order order = this.orderRepo.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("order", "id", orderId));
        order.setDateCreated(LocalDate.now());
        order.setId(orderDto.getId());
        order.setOrderProducts(orderDto.getOrderProducts());
        order.setStatus(orderDto.getStatus());
        Order updatedOrder = this.orderRepo.save(order);
        return this.modelMapper.map(updatedOrder, OrderDto.class);
    }

    @Override
    public void deleteOrder(int orderId) {
        Order order = this.orderRepo.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("order", "id", orderId));
        this.orderRepo.delete(order);
    }
}
