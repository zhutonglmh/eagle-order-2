package com.example.demo.order.vo;

public class BillTotalPrizeRequestVO {
    private int moneyTotal;
    
    public BillTotalPrizeRequestVO() {
        
    }

    public BillTotalPrizeRequestVO(int moneyTotal) {
        super();
        this.moneyTotal = moneyTotal;
    }

    public int getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(int moneyTotal) {
        this.moneyTotal = moneyTotal;
    }

    @Override
    public String toString() {
        return "BillTotalPrizeRequestVO [moneyTotal=" + moneyTotal + "]";
    }
    
    
}
