package com.example.demo.order.pojo;

import java.util.Date;

/**
 * 类Table对应的是数据库中表table的字段，
 * table表是用于存储台位信息类型的表
 * @author 勾洪成 2017年12月9日00:37:04
 *
 */
public class Table {
	
	/**
	 * 台位的id
	 */
	private Integer id;

	/**
	 * 台位的名称
	 */
    private String name;

    /**
     * 台位的状态，只能赋值为0或1， 0代表没有被占用，1代表着台位被占用
     */
    private Byte state;

   /**
    * 每个台位最大可容纳的人数
    */
    private Integer maxnum;

	/**
	 * 订单创建人
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

	public Table() {}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getMaxnum() {
        return maxnum;
    }

    public void setMaxnum(Integer maxnum) {
        this.maxnum = maxnum;
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
		return "Table [id=" + id + ", name=" + name + ", state=" + state + ", maxnum=" + maxnum + ", createUser="
				+ createUser + ", createTime=" + createTime + ", updateUser=" + updateUser + ", updateTime="
				+ updateTime + ", deleteFlag=" + deleteFlag + "]";
	}

}
