package com.example.demo.controller;

import com.example.demo.dto.OrderDTO;
import com.example.demo.exception.PhoneException;
import com.example.demo.form.OrderForm;
import com.example.demo.service.OrderService;
import com.example.demo.service.PhoneService;
import com.example.demo.util.ResultVOUtil;
import com.example.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NamedEntityGraph;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    PhoneService phoneService;

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数错误，orderForm = {}",orderForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getTel());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setSpecsId(orderForm.getSpecsId());
        orderDTO.setPhoneQuantity(orderForm.getQuantity());

        OrderDTO result =  orderService.create(orderDTO);

        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());

        //减库存
        phoneService.subStock(orderForm.getSpecsId(),orderForm.getQuantity());
        return ResultVOUtil.success(map);
    }

    @GetMapping("/detail/{orderId}")
    public ResultVO findOrderDetail(@PathVariable("orderId") String orderId){
        return ResultVOUtil.success(orderService.findOrderDetailByOrderId(orderId));
    }

}
