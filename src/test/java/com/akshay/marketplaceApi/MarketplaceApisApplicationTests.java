package com.akshay.marketplaceApi;

import com.akshay.marketplaceApi.repositories.OrderRepo;
import com.akshay.marketplaceApi.repositories.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MarketplaceApisApplicationTests {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private OrderRepo orderRepo;

    @Test
    public void productRepoTest() {
        String className = this.productRepo.getClass().getName();
        String packageName = this.productRepo.getClass().getPackageName();
        System.out.println(className);
        System.out.println(packageName);
    }

    @Test
    public void orderRepoTest() {
        String className = this.orderRepo.getClass().getName();
        String packageName = this.orderRepo.getClass().getPackageName();
        System.out.println(className);
        System.out.println(packageName);
    }
}
