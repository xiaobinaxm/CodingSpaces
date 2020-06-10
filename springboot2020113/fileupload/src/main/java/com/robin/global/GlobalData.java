package com.robin.global;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description controllerAdvice用来做全局数据使用
 * @Author Robin
 * @Date 2020/4/6 11:21
 */
@ControllerAdvice
public class GlobalData {

    //info相当于一个全局的key值，value值就是return的map值
    @ModelAttribute(value = "info")
    public Map<String,Object> myData(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","robin");
        map.put("address", "com.robin");
        return map;
    }
}
