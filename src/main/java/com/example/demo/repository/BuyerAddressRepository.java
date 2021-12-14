package com.example.demo.repository;

import com.example.demo.entity.BuyerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerAddressRepository extends JpaRepository<BuyerAddress,Integer> {
}
