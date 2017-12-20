package com.example.demo.order.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.order.pojo.FoodType;


/**
 * 
 * 菜品类别信息dao层 接口
 *          （用来处理菜品类别表相关逻辑业务）
 *          
 * @author 朱同 2017/12/9
 *
 */
public interface FoodTypeMapper {
    
    /**
     * 根据id删除表中数据（物理删除  仅供单元测试进行使用）
     * 
     * @param id（主键id）
     * 
     * @return (删除结果  ：此次删除操作影响的条数)
     * 
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 
     * 根据所给的参数添加菜品类别信息（完整添加）
     * 
     * @param foodTypeParams 
     *      (name: 菜品类别名称 ；createUser: 菜品的创建人 ；
     *       createTime:创建时间;updateUser:修改人；updateTime:修改时间等 
     *       注：参数可以选择其一，亦可使用多个)
     *       
     * @return 
     *      (增加结果  ：此次删除操作影响的条数)
     *      
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    int insert(FoodType record);

    /**
     * 
     * 根据所给的参数添加菜品类别信息（可选择性添加）
     * 
     * @param foodTypeParams 
     *      (name: 菜品类别名称 ；createUser: 菜品的创建人 ；
     *       createTime:创建时间;updateUser:修改人；updateTime:修改时间等 
     *       注：参数可以选择其一，亦可使用多个)
     *       
     * @return result
     *      (添加结果  ：此次删除操作影响的条数)
     *      
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    int insertSelective(FoodType record);

    /**
     * 根据主键查询表中某一条数据
     * 
     * @param id（主键）
     * 
     * @return food
     * 
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    FoodType selectByPrimaryKey(Integer id);

    /**
     * 
     * 根据所给的参数修改菜品类别单个或多个字段信息
     * 
     * @param record 
     *      (name: 菜品类别名称 ；createUser: 菜品的创建人 ；
     *       createTime:创建时间;updateUser:修改人；updateTime:修改时间等 
     *       注：可以单个字段修改，亦可多个字段同时修改。)
     *       
     * @return 
     *      data((修改结果  ：此次修改操作影响的条数))
     *      
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    int updateByPrimaryKeySelective(FoodType record);

    /**
     * 
     * 根据所给的参数修改菜品类别单个或多个字段信息
     * 
     * @param record 
     *      (name: 菜品类别名称 ；createUser: 菜品的创建人 ；
     *       createTime:创建时间;updateUser:修改人；updateTime:修改时间等 
     *       注：可以单个字段修改，亦可多个字段同时修改。)
     *       
     * @return 
     *      data((修改结果  ：此次修改操作影响的条数))
     *      
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    int updateByPrimaryKey(FoodType record);
    
    /**
     * 
     * 根据所给的参数查询符合条件的所有菜品类别信息
     * 
     * @param foodTypeParams 
     *      (id: 菜品类别的id； name: 菜品类别名称 ；
     *      createUser: 菜品的创建人  createTime:创建时间;
     *      updateUser:修改人；updateTime:修改时间等  注：参数可以选择其一，也可以多重条件限制查询。)
     * @return 
     *      data(所查询到符合条件的菜品json字符串)
     *      
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    List<FoodType> getListfoodTypeByParams(FoodType foodType);
}