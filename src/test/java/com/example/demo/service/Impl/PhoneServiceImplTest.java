package com.example.demo.service.Impl;

import com.example.demo.service.PhoneService;
import com.example.demo.vo.DataVO;
import com.example.demo.vo.PhonesVO;
import com.example.demo.vo.SpecsVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PhoneServiceImplTest {
    @Autowired
    PhoneService phoneService;

    @Test
    void findDataVO(){
        DataVO dataVO = phoneService.findDataVO();
        int id = 0;
    }
    @Test
    void findPhoneInfoByCategoryType(){
        List<PhonesVO> phonesVOList = phoneService.findPhoneInfoByCategoryType(1);
        int id = 1;
    }
    @Test
    void findSpecsByPhoneId(){
        SpecsVO specsVO = phoneService.findSpecsByPhoneId(1);
        int id = 1;
    }
    @Test
    void subStockTest(){
        phoneService.subStock(1,1);
        int id = 1;
    }
}