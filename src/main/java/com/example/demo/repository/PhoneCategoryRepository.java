package com.example.demo.repository;

import com.example.demo.entity.PhoneCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneCategoryRepository extends JpaRepository<PhoneCategory,Integer> {
    public PhoneCategory findAllByCategoryType(Integer categoryType);
}
