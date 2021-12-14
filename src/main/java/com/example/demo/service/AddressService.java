package com.example.demo.service;

import com.example.demo.form.AddressForm;
import com.example.demo.vo.AddressVO;

import java.util.List;

public interface AddressService {
    public List<AddressVO> findAll();
    public void saveOrUpdate(AddressForm addressForm);
}
