package com.example.demo.order.service;


import com.example.demo.order.dto.FoodDto;
import com.example.demo.order.pojo.Food;

/**
 * 
 * 菜品信息service层接口
 *          （用来处理菜品表相关逻辑业务）
 *          
 * @author 朱同 2017/12/9
 *
 */
public interface IFoodService {
    
    /**
     * 
     * 根据所给的参数查询符合条件的所有菜品信息
     * 
     * @author 朱同(雏鹰订餐系统组) 2017/12/14
     * 
     * @param paramMap (id: 菜品的id； name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode: 菜品的所属类型;
     *        createUser: 菜品的创建人等 注：参数可以选择其一，也可以多重条件限制查询。)
     * 
     * @return result :json字符串(返回菜品类型列表集合json字符串)
     * 
     * @throws Exception
     */
    public String getFoodListByParams(FoodDto foodParam) throws Exception;
    
    /**
     * 修改菜品信息
     * @author 朱同 (雏鹰订餐系统组) 2017/12/9
     * 
     * @param updateFoodMap (id: 菜品的id； name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode:
     *        菜品的所属类型; createUser: 菜品的创建人等 注：参数可以选择其一，同时修改多个字段。包含逻辑删除)
     * 
     * @return result json字符串({result:SUCCESS(成功)||FAILURE(失败),data:此次操作改动的条数})
     * 
     * @throws Exception 
     */
    public String updateFoodMessage(Food food) throws Exception;
    
    /**
     * 增加菜品信息
     * @author 朱同 (雏鹰订餐系统组) 2017/12/14
     * 
     * @param foodMap (name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode: 菜品的所属类型; createUser:
     *        菜品的创建人等菜品信息)
     * 
     * @return  result json字符串({result:SUCCESS(成功)||FAILURE(失败),data:此次添加数据的主键id})
     * 
     * @throws Exception 
     */
    public String insertFoodMessage(Food food) throws Exception;
    
    /**
     * 删除菜品信息（注：此方法非逻辑删除，暂时仅供单元测试使用）
     * 
     * @author 朱同 (雏鹰订餐系统组) 2017/12/14
     * 
     * @param id (菜品 id)
     * 
     * @return result json字符串({result:SUCCESS(成功)||FAILURE(失败),data:此次添加数据的主键id})
     * 
     * @throws Exception 
     */
    public String deleteFoodMessage(int id) throws Exception;
    
    /**
     * @author 苏先华
     * 
     * 更新FoodService里的菜品数据缓存
     * 
     */
    void foodMapUpdate();
    
    
    /**
     * @author 苏先华
     * 
     * 根据菜品ID从缓存里取出一条数据
     * 
     * @param foodId 需要的菜品的ID
     * 
     * @return ID对应的菜品数据
     */
    Food mapGetFoodById(int foodId);
    
}
