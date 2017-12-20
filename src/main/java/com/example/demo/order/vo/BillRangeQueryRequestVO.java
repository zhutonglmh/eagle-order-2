package com.example.demo.order.vo;

public class BillRangeQueryRequestVO {
    private int lowerBound;
    private int upperBound;
    
    public BillRangeQueryRequestVO() {
        
    }
    
    public BillRangeQueryRequestVO(int lowerBound, int upperBound) {
        super();
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
    public int getLowerBound() {
        return lowerBound;
    }
    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }
    public int getUpperBound() {
        return upperBound;
    }
    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    @Override
    public String toString() {
        return "BillRangeQueryRequest [lowerBound=" + lowerBound + ", upperBound=" + upperBound + "]";
    }
}
