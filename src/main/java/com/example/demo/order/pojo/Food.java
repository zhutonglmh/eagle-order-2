package com.example.demo.order.pojo;


import org.springframework.stereotype.Component;

import com.example.demo.common.utils.CheckCharacterValidator;
import com.example.demo.common.utils.CheckIntegerValidator;


/**
 * 
 * 实体bean 对应数据库中的food表
 * 
 * @author 朱同  2017/12/9
 *
 */
@Component("food")
public class Food {
    
    /* 
        @NotNull    被注释的元素必须不为 null    
        @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值    
        @CheckIntegerValidator  被注释的元素必须是一个正整数
        @CheckCharacterValidator  被注释的元素不许不能包含（@#￥%￥……%）等字符
        @MyIntegerValidator    被注释的元素只能由字字母组成
     */ 
    /**
     * 菜品的id, 对用表中字段id
     */
    private Integer id;

    /**
     * 菜品的名称, 对用表中字段name
     */
    @CheckCharacterValidator
    private String name;

    /**
     * 菜品的价格, 对用表中字段price
     */
    @CheckIntegerValidator
    private Integer price;

    /**
     * 菜品的剩余数量, 对用表中字段number
     */
    @CheckIntegerValidator
    private Integer number;

    /**
     * 菜品的所属类型, 对用表中字段foodtype_code
     */
    @CheckCharacterValidator
    private String foodTypeCode;

    /**
     * 菜品的创建人, 对用表中字段create_user
     */
    @CheckCharacterValidator
    private String createUser;

    /**
     * 菜品的创建时间, 对用表中字段create_time
     */
    private String createTime;

    /**
     * 菜品的修改人, 对用表中字段update_user
     */
    @CheckCharacterValidator
    private String updateUser;

    /**
     * 菜品的修改时间, 对用表中字段update_time
     */
    private String updateTime;

    /**
     * 菜品的删除标记, 对用表中字段delete_flag
     */
    private String deleteFlag;

    /**
     * 菜品的主要原料, 对用表中字段raw
     */
    @CheckCharacterValidator
    private String raw;

    /**
     * 菜品的备注信息, 对用表中字段remark
     */
    private String remark;

    /**
     * 菜品的别名  名字首拼, 对用表中字段aliases
     */
   // @MyIntegerValidator
    private String aliases;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getfoodTypeCode() {
        return foodTypeCode;
    }

    public void setfoodTypeCode(String foodTypeCode) {
        this.foodTypeCode = foodTypeCode == null ? null : foodTypeCode.trim();
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

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw == null ? null : raw.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases == null ? null : aliases.trim();
    }
    /**
     * 获取当前类的String 展示
     */

    @Override
    public String toString() {
        return "Food [id=" + id + ", name=" + name + ", price=" + price + ", number=" + number + ", foodTypeCode="
                + foodTypeCode + ", createUser=" + createUser + ", createTime=" + createTime + ", updateUser="
                + updateUser + ", updateTime=" + updateTime + ", deleteFlag=" + deleteFlag + ", raw=" + raw
                + ", remark=" + remark + ", aliases=" + aliases + "]";
    }
    public void clean(){
        
        setId(null);
        setName(null);
        setPrice(null);
        setAliases(null);
        setCreateTime(null);
        setDeleteFlag(null);
        setfoodTypeCode(null);
        setNumber(null);
        setRaw(null);
        setRemark(null);
        setUpdateTime(null);
        setUpdateUser(null);
    }
}