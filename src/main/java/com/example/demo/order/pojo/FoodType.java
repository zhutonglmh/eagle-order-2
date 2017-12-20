package com.example.demo.order.pojo;

import org.springframework.stereotype.Component;

/**
 * 
 * 实体bean 对应数据库中的foodtype表
 * 
 * @author 朱同  2017/12/9
 *
 */
@Component("foodType")
public class FoodType {
    
    /**
     * 菜品类型的主键, 对用表中字段id
     */
    private Integer id;

    /**
     * 菜品类型的名称, 对用表中字段name
     */
    private String name;

    /**
     * 创建人, 对用表中字段create_user
     */
    private String createUser;
    
    /**
     * 创建时间, 对用表中字段create_time
     */
    private String createTime;

    /**
     * 修改人, 对用表中字段update_user
     */
    private String updateUser;

    /**
     * 修改时间, 对用表中字段update_time
     */
    private String updateTime;

    /**
     * 逻辑删除标记, 对用表中字段delete_flag（Y:代表此数据不被使用， N:代表此数据被使用'）
     */
    private String deleteFlag;

    /**
     * 菜品类型的编码, 对用表中字段code
     */
    private String code;

    
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
    /**
     * 获取当前类的String 展示
     */
    public String toString() {
        return this.toString();
    }
}