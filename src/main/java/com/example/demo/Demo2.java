package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.order.pojo.Food;

@RestController
public class Demo2 {
    
    @Resource
    private Food food;
    
    @RequestMapping("/boot")
    public Map<String,Object> demo2(){
        Map<String,Object> map = new HashMap<String,Object>();
        food.setId(4);
        map.put("key","回复信息！");
        return map;
    }
}
