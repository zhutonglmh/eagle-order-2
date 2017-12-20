package com.example.demo.order.vo;

import org.springframework.stereotype.Component;

@Component("foodOperation")
public class FoodOperationVO {

    private String result ;
    
    private Integer data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
    
}
