package com.example.demo.repository;

import com.example.demo.entity.PhoneCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PhoneCategoryRepositoryTest {
    @Autowired
    private PhoneCategoryRepository phoneCategoryRepository;
    @Test
    void findAll(){
        List<PhoneCategory> phoneCategoryList = phoneCategoryRepository.findAll();
        for (PhoneCategory phoneCategory : phoneCategoryList ){
            System.out.println(phoneCategory);
        }
    }
    @Test
    void findByCategoryType(){
        PhoneCategory phoneCategory = phoneCategoryRepository.findAllByCategoryType(1);
        System.out.println(phoneCategory);
    }

}