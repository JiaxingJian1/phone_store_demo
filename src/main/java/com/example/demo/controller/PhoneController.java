package com.example.demo.controller;

import com.example.demo.service.PhoneService;
import com.example.demo.util.ResultVOUtil;
import com.example.demo.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/index")
    public ResultVO index(){
       return ResultVOUtil.success(phoneService.findDataVO());
    }

    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVO findByCategoryType(@PathVariable("categoryType") Integer categoryType){
        return ResultVOUtil.success(phoneService.findPhoneInfoByCategoryType(categoryType));
    }

    @GetMapping("/findSpecsByPhoneId/{PhoneId}")
    public ResultVO findSpecsByPhoneId(@PathVariable("PhoneId") Integer PhoneId){
        return ResultVOUtil.success(phoneService.findSpecsByPhoneId(PhoneId));
    }
}
