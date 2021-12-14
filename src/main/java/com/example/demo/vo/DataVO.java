package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class DataVO {
    private List<PhonesVO> phones;
    private List<CategoriesVO> categories;
}
