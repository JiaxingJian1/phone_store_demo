package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SpecsCaseVO {
    @JsonProperty("id")
    private Integer specsId;
    @JsonProperty("name")
    private String specsName;
    @JsonProperty("imgUrl")
    private String specsIcon;
    @JsonProperty("previewImgUrl")
    private String specsPreview;
}
