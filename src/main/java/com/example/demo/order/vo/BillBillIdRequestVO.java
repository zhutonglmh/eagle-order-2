package com.example.demo.order.vo;

public class BillBillIdRequestVO{
    private int billId;

    public BillBillIdRequestVO(){
        
    }
    
    public BillBillIdRequestVO(int billId) {
        super();
        this.billId = billId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    @Override
    public String toString() {
        return "BillRequest [billId=" + billId + "]";
    }
    
    
    
}
