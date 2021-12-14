package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class PhonesVO {
    @JsonProperty("id")
    private Integer phoneId;
    @JsonProperty("tittle")
    private String phoneName;
    @JsonProperty("price")
    private BigDecimal phonePrice;
    @JsonProperty("desc")
    private String phoneDescription;
    @JsonProperty("tag")
    private List<Map<String,String>> phoneTag;
    @JsonProperty("thumb")
    private String phoneIcon;
}
