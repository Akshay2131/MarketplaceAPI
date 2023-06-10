package com.akshay.marketplaceApi.repositories;

import com.akshay.marketplaceApi.entities.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepo extends JpaRepository<OrderProduct, Integer> {
}
