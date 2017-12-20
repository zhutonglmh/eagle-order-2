package com.example.demo.order.service;

import java.util.Map;

/**
 * 
 * 菜品信息service层接口 （用来处理菜品类别表相关逻辑业务）
 * 
 * @author 朱同 2017/12/9
 *
 */
public interface IFoodTypeService {

    /**
     * 
     * 根据所给的参数查询符合条件的所有菜品类别信息
     * 
     * @param foodTypeParams (id: 菜品类别的id； name: 菜品类别名称 ； createUser: 菜品的创建人 createTime:创建时间;
     *        updateUser:修改人；updateTime:修改时间等 注：参数可以选择其一，也可以多重条件限制查询。)
     * @return data(所查询到符合条件的菜品json字符串)
     * @throws Exception 
     */
    public String getListFoodType() throws Exception;
    
    /**
     * 
     * 根据所给的参数修改菜品类别单个或多个字段信息(包含逻辑删除)
     * 
     * @param foodTypeParams (name: 菜品类别名称 ；createUser: 菜品的创建人 ；
     *        createTime:创建时间;updateUser:修改人；updateTime:修改时间等 注：参数可以选择其一，也可以多重条件限制查询。)
     * 
     * @return data
     *      (result: 修改操作是否成功  success为成功，failure为失败
     *      data: 本次操作影响的行数)
     */
    public String updateFoodTypeMessage(Map<String,Object> foodTypeMap);
    
    /**
     * 
     * 根据所给的参数添加菜品类别信息
     * 
     * @param foodTypeParams (name: 菜品类别名称 ；createUser: 菜品的创建人 ；
     *        createTime:创建时间;updateUser:修改人；updateTime:修改时间等 )
     * 
     * @return finalResult
     *      (result: 修改结果  success为成功,failure为失败;
     *        data:此次添加数据的主键id)
     */
    public String deleteFoodTypeMessage(int foodTypeId);
    
    /**
     * 
     * 根据所给的参数添加菜品类别信息
     * 
     * @param foodTypeParams (name: 菜品类别名称 ；createUser: 菜品的创建人 ；
     *        createTime:创建时间;updateUser:修改人；updateTime:修改时间等 )
     * 
     * @return finalResult
     *      (result: 修改结果  success为成功,failure为失败;
     *        data:此次添加数据的主键id)
     */
    public String insertFoodTypeMessage(Map<String, Object> foodTypeMap);
}
