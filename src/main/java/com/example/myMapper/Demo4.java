package com.example.myMapper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo4 {
    
    @RequestMapping("/demo4")
    public String demo2(){
        String ss = null;
        ss = ss.toString();
        return "String2!!!";
    }
}
