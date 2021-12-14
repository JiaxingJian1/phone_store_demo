package com.example.demo.service.Impl;

import com.example.demo.form.AddressForm;
import com.example.demo.service.AddressService;
import com.example.demo.vo.AddressVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressServiceImplTest {
    @Autowired
    public AddressService addressService;
    @Test
    void findAll() {
        List<AddressVO> addressVOList = addressService.findAll();
        int id = 0;
    }
    @Test
    void saveOrUpdate(){
        AddressForm addressForm = new AddressForm();
        addressForm.setId(35);
        addressForm.setName("建家兴");
        addressForm.setTel("19829700857");
        addressForm.setProvince("陕西省");
        addressForm.setCity("西安市");
        addressForm.setCounty("长安区");
        addressForm.setAreaCode("710100");
        addressForm.setAddressDetail("西电南校区");
        addressService.saveOrUpdate(addressForm);
    }
}