package com.example.demo.order.vo;

public class BillOrderMessageRequestVO {
    private int foodId;
    private int foodNumber;
    
    public BillOrderMessageRequestVO() {
        
    }
    
    public BillOrderMessageRequestVO(int foodId, int foodNumber) {
        super();
        this.foodId = foodId;
        this.foodNumber = foodNumber;
    }
    
    public int getFoodId() {
        return foodId;
    }
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
    public int getFoodNumber() {
        return foodNumber;
    }
    public void setFoodNumber(int foodNumber) {
        this.foodNumber = foodNumber;
    }

    @Override
    public String toString() {
        return "OrderMessageInfo [foodId=" + foodId + ", foodNumber=" + foodNumber + "]";
    }
    
    
}
