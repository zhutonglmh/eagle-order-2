package com.example.demo.order.vo;

import java.util.List;

public class BillMessageRequestVO {
    private int tableId;
    private int moneyTotal;
    private List<BillOrderMessageRequestVO> food;
    
    public BillMessageRequestVO() {
        
    }
    
    public BillMessageRequestVO(int tableId, int moneyTotal, List<BillOrderMessageRequestVO> food) {
        super();
        this.tableId = tableId;
        this.moneyTotal = moneyTotal;
        this.food = food;
    }
    
    public int getTableId() {
        return tableId;
    }
    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
    public int getMoneyTotal() {
        return moneyTotal;
    }
    public void setMoneyTotal(int moneyTotal) {
        this.moneyTotal = moneyTotal;
    }
    public List<BillOrderMessageRequestVO> getFood() {
        return food;
    }
    public void setFood(List<BillOrderMessageRequestVO> food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "BillMessageInfo [tableId=" + tableId + ", moneyTotal=" + moneyTotal + ", food=" + food + "]";
    }
    
    
}
