package com.example.demo.order.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.order.dto.FoodDto;
import com.example.demo.order.pojo.Food;


/**
 * 
 * 菜品信息dao层 接口 （用来处理菜品表相关逻辑业务）
 * 
 * @author 朱同 2017/12/9
 *
 */
public interface FoodMapper {


    /**
     * 根据id删除表中数据（物理删除 仅供单元测试进行使用）
     * 
     * @param id（主键id）
     * 
     * @return (删除结果 ：此次删除操作影响的条数)
     * 
     * @author 朱同 (雏鹰订餐系统组) 2017/12/14
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 增加菜品信息（完整添加）
     * 
     * @param foodMap (name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode: 菜品的所属类型; createUser:
     *        菜品的创建人等菜品信息)
     * 
     * @return data (增加结果 ：操作影响的条数)
     * 
     * @author 朱同 (雏鹰订餐系统组) 2017/12/14
     */
    int insert(Food record);

    /**
     * 增加菜品信息（可选择性添加）
     * 
     * @param record (name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode: 菜品的所属类型; createUser:
     *        菜品的创建人等菜品信息)
     * 
     * @return data (增加结果 ：操作影响的条数)
     * 
     * @author 朱同 (雏鹰订餐系统组) 2017/12/14
     */
    int insertSelective(Food record);

    /**
     * 根据主键查询表中某一条数据
     * 
     * @param id（主键）
     * 
     * @return food
     * 
     * @author 朱同 (雏鹰订餐系统组) 2017/12/14
     */
    Food selectByPrimaryKey(Integer id);

    /**
     * 修改菜品信息（可选择性修改）
     * 
     * @param record (id: 菜品的id； name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode:
     *        菜品的所属类型; createUser: 菜品的创建人等 注：参数可以选择其一，同时修改多个字段。包含逻辑删除)
     * 
     * @return result (修改结果 ：此次修改操作影响的条数)
     * 
     * @author 朱同 (雏鹰订餐系统组) 2017/12/14
     */
    int updateByPrimaryKeySelective(Food record);

    /**
     * 修改菜品信息（整体修改）
     * 
     * @param record (id: 菜品的id； name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode:
     *        菜品的所属类型; createUser: 菜品的创建人等 注：参数可以选择其一，同时修改多个字段。包含逻辑删除)
     * 
     * @return result (修改结果 ：此次修改操作影响的条数)
     * 
     * @author 朱同 (雏鹰订餐系统组) 2017/12/14
     */
    int updateByPrimaryKey(Food record);

    /**
     * 
     * 根据所给的参数查询符合条件的所有菜品信息（选择性修改）
     * 
     * @param foodParam (id: 菜品的id； name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode: 菜品的所属类型;
     *        createUser: 菜品的创建人;restriction: 查询剩余量大于或者小于或者等于;等 注：参数可以选择其一，也可以多重条件限制查询。)
     * @return data(所查询到符合条件的菜品List集合)
     * 
     * @author 朱同 (雏鹰订餐系统组) 2017/12/14
     */
    public List<Food> getFoodListByParams(FoodDto foodParam);
    
    /**
     * 
     * 根据所给的参数查询符合条件的所有菜品信息（选择性修改）
     * 
     * @param foodlist (id: 菜品的id； name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode: 菜品的所属类型;
     *        createUser: 菜品的创建人;restriction: 查询剩余量大于或者小于或者等于;等 注：参数可以选择其一，也可以多重条件限制查询。)
     *        
     * @return 批量修改结果  改动的条数
     * 
     * @author 朱同 (雏鹰订餐系统组) 2017/12/14
     * 
     */
    public int updateFoodList(List<Food> foodlist);
    
    /**
     * 查询总条数total
     * 
     * @author 朱同 (雏鹰订餐系统组) 2017/12/14
     * 
     * @param foodParams (id: 菜品的id； name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode:
     *        菜品的所属类型; createUser: 菜品的创建人;start: 起始页数;limit: 前段显示条数等 注：参数可以选择其一，也可以多重条件限制查询。)
     * 
     * @return 查询到的菜品信息总条数
     */
    public int getTotalByParams(FoodDto foodParam);
}
