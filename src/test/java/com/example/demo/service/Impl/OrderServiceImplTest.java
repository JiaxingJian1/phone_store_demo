package com.example.demo.service.Impl;

import com.example.demo.dto.OrderDTO;
import com.example.demo.service.OrderService;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void creatTest(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("建家兴");
        orderDTO.setBuyerPhone("19829700857");
        orderDTO.setBuyerAddress("西电南校区");
        orderDTO.setSpecsId(2);
        orderDTO.setPhoneQuantity(1);

        OrderDTO result = orderService.create(orderDTO);
        System.out.println(result);
    }
    @Test
    public void pay(){
        System.out.println(orderService.pay("1637746062646813071" ));
    }
}