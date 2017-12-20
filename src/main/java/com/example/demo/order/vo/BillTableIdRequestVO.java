package com.example.demo.order.vo;

public class BillTableIdRequestVO {
    private int TableId;
    
    public BillTableIdRequestVO() {
        
    }
    public BillTableIdRequestVO(int tableId) {
        super();
        TableId = tableId;
    }

    public int getTableId() {
        return TableId;
    }

    public void setTableId(int tableId) {
        TableId = tableId;
    }
    
    @Override
    public String toString() {
        return "BillTableIdRequest [TableId=" + TableId + "]";
    }
    
    
}
