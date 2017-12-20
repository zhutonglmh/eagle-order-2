package com.example.demo.order.vo;

import java.util.List;

public class BillDetailResponseInfoVO {
    private int billId;
    private String createTime;
    private String createUser;
    private String tableId;
    private String state;
    private String stateText;
    private String moneyTotal;
    private List<BillDetailResponseFoodInfoVO>OrderDetail;
    
    public BillDetailResponseInfoVO() {
        
    }
    
    
    
    public BillDetailResponseInfoVO(int billId, String createTime, String createUser, String tableId, String state,
            String stateText, String moneyTotal, List<BillDetailResponseFoodInfoVO> orderDetail) {
        super();
        this.billId = billId;
        this.createTime = createTime;
        this.createUser = createUser;
        this.tableId = tableId;
        this.state = state;
        this.stateText = stateText;
        this.moneyTotal = moneyTotal;
        OrderDetail = orderDetail;
    }



    public int getBillId() {
        return billId;
    }
    public void setBillId(int billId) {
        this.billId = billId;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public String getTableId() {
        return tableId;
    }
    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getMoneyTotal() {
        return moneyTotal;
    }
    public void setMoneyTotal(String moneyTotal) {
        this.moneyTotal = moneyTotal;
    }
    public List<BillDetailResponseFoodInfoVO> getOrderDetail() {
        return OrderDetail;
    }
    public void setOrderDetail(List<BillDetailResponseFoodInfoVO> orderDetail) {
        OrderDetail = orderDetail;
    }

    public String getStateText() {
        return stateText;
    }
    
    public void setStateText(String stateText) {
        this.stateText = stateText;
    }

    @Override
    public String toString() {
        return "BillDetailResponseInfoVO [billId=" + billId + ", createTime=" + createTime + ", createUser="
                + createUser + ", tableId=" + tableId + ", state=" + state + ", stateText=" + stateText
                + ", moneyTotal=" + moneyTotal + ", OrderDetail=" + OrderDetail + "]";
    }
    
    
}
