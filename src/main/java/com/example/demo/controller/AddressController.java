package com.example.demo.controller;

import com.example.demo.exception.PhoneException;
import com.example.demo.form.AddressForm;
import com.example.demo.service.AddressService;
import com.example.demo.util.ResultVOUtil;
import com.example.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
@Slf4j
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public ResultVO list(){
        return ResultVOUtil.success(addressService.findAll());
    }

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody AddressForm addressForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【添加地址】参数错误，addressForm = {}",addressForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }
        addressService.saveOrUpdate(addressForm);

        return ResultVOUtil.success(null);
    }

    @PutMapping("/update")
    public ResultVO update(@Valid @RequestBody AddressForm addressForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【修改地址】参数错误，addressForm = {}",addressForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }
        addressService.saveOrUpdate(addressForm);

        return ResultVOUtil.success(null);
    }
}
