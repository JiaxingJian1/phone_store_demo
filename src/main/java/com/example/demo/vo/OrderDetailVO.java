package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailVO {
    private String orderId;
    private String buyerName;
    @JsonProperty("tel")
    private String buyerPhone;
    @JsonProperty("address")
    private String buyerAddress;
    @JsonProperty("num")
    private Integer phoneQuantity;
    private String phoneName;
    @JsonProperty("specs")
    private String specsName;
    @JsonProperty("icon")
    private String phoneIcon;
    @JsonProperty("amount")
    private BigDecimal orderAmount;
}
