package com.example.demo.order.pojo;


/**
 * 类Bill对应的是数据库中表bill的字段，
 * Bill表是用于存储台位信息类型的表
 * @author 勾洪成 2017年12月9日13:14:35
 *
 */
public class Bill {
	
	/**
	 * 账单的Id
	 */
    private Integer id;

    /**
     * 台位的Id
     */
    private Integer tableId;

    /**
     * 账单的状态，0代表已下单，未付账。 1代表已付账
     */
    private Byte state;

    /**
     * 对应的账单的总钱数
     */
    private Integer moneyTotal;

    /**
     * 账单的创建人
     */
    private String createUser;

    /**
     * 账单的创建时间
     */
    private String createTime;

    /**
     * 账单的修改人
     */
    private String updateUser;

    /**
     * 修改的修改人
     */
    private String updateTime;

    /**
     * Y代表这个数据不被使用， N代表数据库在使用
     */
    private String deleteFlag;

    public Bill(){}

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(Integer moneyTotal) {
        this.moneyTotal = moneyTotal;
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

    @Override
    public String toString() {
        return "Bill [id=" + id + ", tableId=" + tableId + ", state=" + state + ", moneyTotal=" + moneyTotal
                + ", createUser=" + createUser + ", createTime=" + createTime + ", updateUser=" + updateUser
                + ", updateTime=" + updateTime + ", deleteFlag=" + deleteFlag + "]";
    }
}