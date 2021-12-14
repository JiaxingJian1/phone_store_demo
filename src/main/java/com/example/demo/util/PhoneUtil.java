package com.example.demo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneUtil {
    public static List<Map<String,String>> createTag(String phoneTag){
        String[] phoneTags = phoneTag.split("&");
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map ;
        for(String s : phoneTags){
            map = new HashMap<>();
            map.put("name",s);
            list.add(map);
        }
        return list;
    }
}
