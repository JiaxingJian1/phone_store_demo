package com.example.demo.service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.vo.OrderDetailVO;

public interface OrderService {
    public OrderDTO create(OrderDTO orderDTO);
    public OrderDetailVO findOrderDetailByOrderId(String orderId);
    public String pay(String orderId);
}
