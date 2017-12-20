package com.example.demo.order.pojo;

import java.util.Date;

/**
 * 类Order对应的是数据库中表order的字段，
 * order表是用于存储订单信息类型的表
 * @author 勾洪成  2017年12月9日00:28:03
 *
 */
public class Order {
	
	/**
	 * 对应的是账单表中的id
	 */
	private Integer billId;

	/**
	 * 对应的是菜品表中的id
	 */
    private Integer foodId;
    
    /**
     * 每个流水单中对应每个菜品的数量
     */
    private Integer number;

    /**
     * 订单的创建人
     */
    private String createUser;

    /**
     * 订单创建的时间
     */
    private String createTime;

    /**
     * 订单的修改人
     */
    private String updateUser;

   /**
    * 订单的修改时间
    */
    private String updateTime;

    /**
     * 订单删除的标记,Y:代表此数据不被使用，N:代表此数据被使用
     */
    private String deleteFlag;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

	@Override
	public String toString() {
		return "Order [billId=" + billId + ", foodId=" + foodId + ", number=" + number + ", createUser=" + createUser
				+ ", createTime=" + createTime + ", updateUser=" + updateUser + ", updateTime=" + updateTime
				+ ", deleteFlag=" + deleteFlag + "]";
	}
    
}
