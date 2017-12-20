package com.example.demo.order.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.order.dao.FoodTypeMapper;
import com.example.demo.order.pojo.FoodType;
import com.example.demo.order.service.IFoodTypeService;

/**
 * 
 * 菜品信息service层 （用来处理菜品类别表相关逻辑业务）
 * 
 * @author 朱同 2017/12/9
 *
 */
@Service("foodTypeService")
public class FoodTypeServiceImpl implements IFoodTypeService {

    /**
     * dao层业务类foodTypeMapper
     */
    @Resource
    private FoodTypeMapper foodTypeMapper;
    
    @Resource
    private FoodType foodType;
    

    /**
     * 
     * 根据所给的参数查询符合条件的所有菜品类别信息
     * 
     * @param foodTypeParams (id: 菜品类别的id； name: 菜品类别名称 ； createUser: 菜品的创建人 createTime:创建时间;
     *        updateUser:修改人；updateTime:修改时间等 注：参数可以选择其一，也可以多重条件限制查询。)
     * @return data(所查询到符合条件的菜品json字符串)
     * 
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    @Override
    public String getListFoodType() throws Exception{
        
        List<FoodType> foodTypeList = new ArrayList<FoodType>();
        foodTypeList = foodTypeMapper.getListfoodTypeByParams(foodType);
        String data = JSON.toJSONString(foodTypeList);
        return data;
    }

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
     *      
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    @Override
    public String updateFoodTypeMessage(Map<String,Object> foodTypeMap) {

        String jsonStr = JSON.toJSONString(foodTypeMap);
        FoodType foodType = JSON.parseObject(jsonStr, FoodType.class);
        int result = foodTypeMapper.updateByPrimaryKeySelective(foodType);
        JSONObject updateResultJsonObj = new JSONObject();
        if(result > 0){
            updateResultJsonObj.put("result", "success");
            updateResultJsonObj.put("data", result);
        }
        else{
            updateResultJsonObj.put("result", "failure");
        }
        return JSON.toJSONString(updateResultJsonObj);
    }

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
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    @Override
    public String insertFoodTypeMessage(Map<String, Object> foodTypeMap) {

        String jsonStr = JSON.toJSONString(foodTypeMap);
        FoodType foodType = JSON.parseObject(jsonStr, FoodType.class);
        int result = foodTypeMapper.insertSelective(foodType);
        JSONObject insertJsonObj = new JSONObject();
        if(result > 0){
            insertJsonObj.put("result", "success");
            insertJsonObj.put("data",foodType.getId());
        }else{
            insertJsonObj.put("result", "failure");
        }
        String finalResult = JSON.toJSONString(insertJsonObj);
        return finalResult;
    }

    /**
     * 物理删除菜品信息（注：此方法非逻辑删除，暂时仅供单元测试使用）
     * 
     * @param id (菜品类型 id)
     * 
     * @return data 删除结果
     *        (result: 删除结果  success为成功,failure为失败;
     *        data:本次操作影响的条数)
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    public String deleteFoodTypeMessage(int foodTypeId) {

        int result = foodTypeMapper.deleteByPrimaryKey(foodTypeId);
        JSONObject deleteJsonObj = new JSONObject();
        if(result > 0){
            deleteJsonObj.put("result", "success");
        }else{
            deleteJsonObj.put("result", "failure");
        }
        String finalResult = JSON.toJSONString(deleteJsonObj);
        return finalResult;
    }
}
