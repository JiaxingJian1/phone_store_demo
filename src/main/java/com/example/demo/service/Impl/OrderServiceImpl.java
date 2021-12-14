package com.example.demo.service.Impl;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.OrderMaster;
import com.example.demo.entity.PhoneInfo;
import com.example.demo.entity.PhoneSpecs;
import com.example.demo.enums.PayStatusEnums;
import com.example.demo.enums.ResultEnums;
import com.example.demo.exception.PhoneException;
import com.example.demo.repository.OrderMasterRepository;
import com.example.demo.repository.PhoneInfoRepository;
import com.example.demo.repository.PhoneSpecRepository;
import com.example.demo.service.OrderService;
import com.example.demo.util.KeyUtil;
import com.example.demo.vo.OrderDetailVO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Data
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private PhoneSpecRepository phoneSpecRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Override
    public OrderDTO create(OrderDTO orderDTO){
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);

        PhoneSpecs phoneSpecs = phoneSpecRepository.findById(orderDTO.getSpecsId()).get();
        if(phoneSpecs == null){
            log.error("【创建订单】规格不存在，phoneSpecs={}",phoneSpecs);
            throw new PhoneException(ResultEnums.SPECS_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneSpecs,orderMaster);

        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        if(phoneInfo == null){
            log.error("【创建订单】手机不存在，phoneInfo={}",phoneSpecs);
            throw new PhoneException(ResultEnums.PHONE_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneInfo,orderMaster);

        //计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        orderAmount = phoneSpecs.getSpecsPrice().divide(new BigDecimal(100))
                .multiply(new BigDecimal(orderDTO.getPhoneQuantity()))
                .add(orderAmount);
        orderMaster.setOrderAmount(orderAmount);

        //orderId
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        orderDTO.setOrderId(orderMaster.getOrderId());

        //payStatus
        orderMaster.setPayStatus(PayStatusEnums.UNPAID.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }

    @Override
    public OrderDetailVO findOrderDetailByOrderId(String orderId){
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        OrderMaster orderMaster = orderMasterRepository.findByOrderId(orderId);
        BeanUtils.copyProperties(orderMaster,orderDetailVO);
        return orderDetailVO;
    }

    @Override
    public String pay(String orderId){
        OrderMaster orderMaster =orderMasterRepository.findByOrderId(orderId);
        if(orderMaster == null){
            log.error("【支付订单】订单不存在orderMaster={}",orderMaster);
            throw new PhoneException(ResultEnums.ORDER_NOT_EXIST);
        }
        if(orderMaster.getPayStatus().equals(PayStatusEnums.UNPAID.getCode())){
            orderMaster.setPayStatus(PayStatusEnums.PAID.getCode());
            orderMasterRepository.save(orderMaster);
        } else {
            log.error("【支付订单】订单已支付",orderMaster);
        }
        return orderId;
    }
}
