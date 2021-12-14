package com.example.demo.repository;

import com.example.demo.entity.BuyerAddress;
import com.example.demo.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,Integer> {
    public OrderMaster findByOrderId(String orderId);

}
