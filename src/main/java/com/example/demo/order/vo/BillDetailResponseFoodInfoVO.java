package com.example.demo.order.vo;

public class BillDetailResponseFoodInfoVO {
    private int foodId;
    private String foodName;
    private int foodNumber;
    private int foodPrize;
    private int foodTotalPrize;
    
    
    public BillDetailResponseFoodInfoVO() {
        
    }
    
    public BillDetailResponseFoodInfoVO(int foodId, String foodName, int foodNumber, int foodPrize, int foodTotalPrize) {
        super();
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodNumber = foodNumber;
        this.foodPrize = foodPrize;
        this.foodTotalPrize = foodTotalPrize;
    }
    
    
    public int getFoodId() {
        return foodId;
    }
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public int getFoodNumber() {
        return foodNumber;
    }
    public void setFoodNumber(int foodNumber) {
        this.foodNumber = foodNumber;
    }
    public int getFoodPrize() {
        return foodPrize;
    }
    public void setFoodPrize(int foodPrize) {
        this.foodPrize = foodPrize;
    }
    public int getFoodTotalPrize() {
        return foodTotalPrize;
    }
    public void setFoodTotalPrize(int foodTotalPrize) {
        this.foodTotalPrize = foodTotalPrize;
    }
    
    
}
