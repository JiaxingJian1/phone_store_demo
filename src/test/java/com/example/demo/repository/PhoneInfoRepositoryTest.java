package com.example.demo.repository;

import com.example.demo.entity.PhoneCategory;
import com.example.demo.entity.PhoneInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PhoneInfoRepositoryTest {
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;
    @Test
    void findAll(){
        List<PhoneInfo> phoneInfoList = phoneInfoRepository.findAll();
        for (PhoneInfo phoneInfo : phoneInfoList ){
            System.out.println(phoneInfo);
        }
    }
    @Test
    void findAllByPhoneName(){
        PhoneInfo phoneInfo = phoneInfoRepository.findAllByPhoneName("honor V20");
        System.out.println(phoneInfo);
    }
}