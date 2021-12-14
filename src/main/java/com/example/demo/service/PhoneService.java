package com.example.demo.service;

import com.example.demo.vo.DataVO;
import com.example.demo.vo.PhonesVO;
import com.example.demo.vo.SpecsVO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface PhoneService {
    public DataVO findDataVO();
    public List<PhonesVO> findPhoneInfoByCategoryType(Integer categoryType);
    public SpecsVO findSpecsByPhoneId(Integer phoneId);
    public void subStock(Integer specsId, Integer quantity);
}
