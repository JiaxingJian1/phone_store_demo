package com.example.demo.dto;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private Integer specsId;
    private Integer phoneQuantity;
}
