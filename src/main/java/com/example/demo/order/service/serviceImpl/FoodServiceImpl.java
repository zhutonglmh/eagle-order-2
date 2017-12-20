package com.example.demo.order.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.utils.ConstantConfig;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.order.dao.FoodMapper;
import com.example.demo.order.dto.FoodDto;
import com.example.demo.order.pojo.Food;
import com.example.demo.order.service.IFoodService;
import com.example.demo.order.vo.FoodOperationVO;

/**
 * 
 * 菜品信息service层 （用来处理菜品表相关逻辑业务）
 * 
 * @author 朱同 (雏鹰订餐系统组) 2017/12/9
 *
 */
@Service("foodService")
public class FoodServiceImpl implements IFoodService {


    /**
     * dao层业务类foodMapper
     */
    @Resource
    private FoodMapper foodMapper;

    @Resource
    private FoodOperationVO foodOperation;

    @Resource
    private Food food;

    @Resource
    private FoodDto foodDto;

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
     */
    @Override
    public String getFoodListByParams(FoodDto foodParam) throws Exception {

        foodParam.setNumber(0);
        foodParam.setCompareType("greater");
        // 全部转换成大写
        if (foodParam.getAliases() != null) {
            String aliases = foodParam.getAliases();
            foodParam.setAliases(aliases);
        }
        List<Food> foodList = new ArrayList<Food>();
        foodList = foodMapper.getFoodListByParams(foodParam);
        List<Food> foodListRes = new ArrayList<Food>();
        // 查询总条数int total = foodMapper.getTotalByParams(foodParam);
        if (foodList.size() > 0) {
            // 关于最后修改时间处理
            Iterator<Food> it = foodList.iterator();
            while (it.hasNext()) {
                Food food = it.next();
                String finalTime = food.getUpdateTime();
                if (finalTime == null || "".equals(finalTime)) {
                    food.setUpdateTime(food.getCreateTime());
                } else {}
                foodListRes.add(food);
            }
        } else {}
        String data = JSON.toJSONString(foodListRes);
        return data;
    }


    /**
     * 修改菜品信息
     * @author 朱同 (雏鹰订餐系统组) 2017/12/9
     * 
     * @param updateFoodMap (id: 菜品的id； name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode:
     *        菜品的所属类型; createUser: 菜品的创建人等 注：参数可以选择其一，同时修改多个字段。包含逻辑删除)
     * 
     * @return result json字符串({result:SUCCESS(成功)||FAILURE(失败),data:此次操作改动的条数})
     */
    @Override
    public String updateFoodMessage(Food food) throws Exception {

        String foodName = food.getName();
        int foodId = 0;
        foodId = food.getId();
        if(null != foodName && 0 != foodId){
            foodDto.clean();
            foodDto.setName(foodName);
            List<Food> foodListValid = new ArrayList<Food>();
            foodListValid = foodMapper.getFoodListByParams(foodDto);
            if(foodListValid.size() > 0){
                if(foodListValid.get(0).getId() != foodId){
                    return ConstantConfig.RESULT_FAILURE;
                }
            }
        }
        // 获取当前时间
        SimpleDateFormat df = new SimpleDateFormat(ConstantConfig.DATE_FORMAT);// 设置日期格式
        food.setUpdateTime(df.format(new Date()));
        food.setUpdateUser(ConstantConfig.DEFAULT_USER);
        int result = foodMapper.updateByPrimaryKeySelective(food);
        if (result > 0) {
            foodOperation.setResult(ConstantConfig.RESULT_SUCCESS);
        } else {
            foodOperation.setResult(ConstantConfig.RESULT_FAILURE);
        }
        foodOperation.setData(result);
        return JSON.toJSONString(foodOperation);
    }

    /**
     * 增加菜品信息
     * @author 朱同 (雏鹰订餐系统组) 2017/12/14
     * 
     * @param foodMap (name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode: 菜品的所属类型; createUser:
     *        菜品的创建人等菜品信息)
     * 
     * @return  result json字符串({result:SUCCESS(成功)||FAILURE(失败),data:此次添加数据的主键id})
     */
    @Override
    public String insertFoodMessage(Food food) throws Exception {

        String foodName = food.getName();
        if(null == foodName){
            return ConstantConfig.RESULT_FAILURE;
        }else{
            foodDto.clean();
            foodDto.setName(foodName);
            List<Food> foodListValid = new ArrayList<Food>();
            foodListValid = foodMapper.getFoodListByParams(foodDto);
            if(foodListValid.size() > 0){
                return ConstantConfig.RESULT_FAILURE;
            }
        }
        String insertResult = null;
        food.setDeleteFlag("N");
        food.setCreateUser("管理员");
        // 获取当前时间
        SimpleDateFormat df = new SimpleDateFormat(ConstantConfig.DATE_FORMAT);// 设置日期格式
        food.setCreateTime(df.format(new Date()));
        // 新增加数据的id存在于food实体bean中
        int result = foodMapper.insertSelective(food);
        if (result > 0) {
            food.setDeleteFlag("Y");
            foodOperation.setResult(ConstantConfig.RESULT_SUCCESS);
        } else {
            foodOperation.setResult(ConstantConfig.RESULT_FAILURE);
        }
        foodOperation.setData(food.getId());
        insertResult = JSON.toJSONString(foodOperation);

        return insertResult;
    }

    /**
     * 删除菜品信息（注：此方法非逻辑删除，暂时仅供单元测试使用）
     * 
     * @author 朱同 (雏鹰订餐系统组) 2017/12/14
     * 
     * @param id (菜品 id)
     * 
     * @return result json字符串({result:SUCCESS(成功)||FAILURE(失败),data:此次添加数据的主键id})
     */
    @Override
    public String deleteFoodMessage(int id) throws Exception {

        int result = foodMapper.deleteByPrimaryKey(id);
        // 判断删除是否删除成功
        if (result > 0) {
            return ConstantConfig.RESULT_SUCCESS;
        } else {
            return ConstantConfig.RESULT_FAILURE;
        }
    }
    /**
     * @author 苏先华
     * 
     *         用来做映射的一次性的映射缓存,在 marginChek(校验函数) 和 insert(插入函数)中被使用
     */
    private Map<Integer, Food> foodMap;

    /**
     * @author 苏先华
     * 
     *         更新FoodService里的菜品数据缓存
     * 
     */
    public void foodMapUpdate() {
        List<Food> foodList = foodMapper.getFoodListByParams(new FoodDto());
        foodMap = new HashMap<Integer, Food>();
        for (Food varFood : foodList) {
            foodMap.put(varFood.getId(), varFood);
        }
    }

    /**
     * @author 苏先华
     * 
     *         根据菜品ID从缓存里取出一条数据
     * 
     * @param foodId 需要的菜品的ID
     * 
     * @return ID对应的菜品数据
     */
    public Food mapGetFoodById(int foodId) {
        return foodMap.get(foodId);
    }
    
}
