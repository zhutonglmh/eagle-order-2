package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * 全局捕获异常类
 * @author zhuto
 *
 */
@ControllerAdvice
public class MycontrollerHandleException {
  
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String errorHandle(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "-1");
        map.put("message", "请求有误");
        String result = JSON.toJSONString(map);
        return result;
    }
}
