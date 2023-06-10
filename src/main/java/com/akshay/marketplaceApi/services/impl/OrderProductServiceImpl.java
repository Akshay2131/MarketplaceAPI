package com.akshay.marketplaceApi.services.impl;

import com.akshay.marketplaceApi.entities.OrderProduct;
import com.akshay.marketplaceApi.repositories.OrderProductRepo;
import com.akshay.marketplaceApi.services.OrderProductService;

public class OrderProductServiceImpl implements OrderProductService {
    private final OrderProductRepo orderProductRepo;

    public OrderProductServiceImpl(OrderProductRepo orderProductRepo) {
        this.orderProductRepo = orderProductRepo;
    }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepo.save(orderProduct);
    }
}
