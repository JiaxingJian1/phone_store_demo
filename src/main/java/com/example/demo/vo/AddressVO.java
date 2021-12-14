package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressVO {
    @JsonProperty("id")
    private Integer addressId;
    @JsonProperty("areaCode")
    private String areaCode;
    @JsonProperty("name")
    private String buyerName;
    @JsonProperty("tel")
    private String buyerPhone;
    @JsonProperty("address")
    private String buyerAddress;
}
