package com.example.demo.order.vo;

public class BillStateRequestVO {
    private int state;

    public BillStateRequestVO() {
        
    }

    public BillStateRequestVO(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BillStateRequestVO [state=" + state + "]";
    }
    
    
}
