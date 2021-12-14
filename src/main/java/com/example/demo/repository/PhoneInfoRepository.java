package com.example.demo.repository;

import com.example.demo.entity.PhoneInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneInfoRepository extends JpaRepository<PhoneInfo,Integer> {
    public PhoneInfo findAllByPhoneName(String phoneName);

    public List<PhoneInfo> findAllByCategoryType(Integer categoryType);
}
