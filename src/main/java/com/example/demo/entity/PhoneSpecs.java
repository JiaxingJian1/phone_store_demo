package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
public class PhoneSpecs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specsId;
    private Integer phoneId;
    private String specsName;
    private Integer specsStock;
    private BigDecimal specsPrice;
    private String specsIcon;
    private String specsPreview;
    private Date updateTime;
    private Date createTime;
}

