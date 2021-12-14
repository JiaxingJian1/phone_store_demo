package com.example.demo.util;

import com.example.demo.vo.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }
    public static ResultVO error(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg("error");
        resultVO.setData(null);
        return resultVO;
    }
}
