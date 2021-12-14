package com.example.demo.repository;

import com.example.demo.entity.PhoneSpecs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneSpecRepository extends JpaRepository<PhoneSpecs,Integer> {
    public List<PhoneSpecs> findAllByPhoneId(Integer phoneId);
}
