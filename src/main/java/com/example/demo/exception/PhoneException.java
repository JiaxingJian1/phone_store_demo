package com.example.demo.exception;

import com.example.demo.enums.ResultEnums;

public class PhoneException extends RuntimeException{
    public PhoneException(ResultEnums resultEnums) {
        super(resultEnums.getMsg());
    }
    public PhoneException(String error) {
        super(error);
    }
}
