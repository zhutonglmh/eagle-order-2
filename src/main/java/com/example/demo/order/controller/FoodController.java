package com.example.demo.order.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.utils.ConstantConfig;
import com.example.demo.order.dto.FoodDto;
import com.example.demo.order.pojo.Food;
import com.example.demo.order.service.IFoodService;

/**
 * 
 * 菜品管理controller层(负责处理关于菜品相关的请求)
 * 
 * @author 朱同(雏鹰订餐系统组) 2017/12/9
 *
 */
@Controller
@RequestMapping("api/food")
public class FoodController {

    /**
     * 日志输出类
     */
    private static final Logger log = LoggerFactory.getLogger(FoodController.class);

    /**
     * 引入Service 层foodService接口
     */
    @Resource
    private IFoodService foodService;


    /**
     * 根据菜品类型查找该类型下所有的菜品信息
     * 
     * @param foodParams (id: 菜品的id； name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode:
     *        菜品的所属类型; createUser: 菜品的创建人;start: 起始页数;limit: 前段显示条数等 注：参数可以选择其一，也可以多重条件限制查询。)
     * 
     * @return result :json字符串(返回菜品类型列表集合json字符串),faliure:未知错误;"系统异常":代表系统异常
     * @throws Exception 
     * 
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     * 
     */
    @RequestMapping(value = "/getFoodList", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getFoodList(@RequestBody @Validated FoodDto foodParams, BindingResult resultValid) throws Exception {

        String result = "failure";
        if(resultValid.getErrorCount()>0){  
            for(FieldError error:resultValid.getFieldErrors()){  
                return error.getField()+":"+error.getDefaultMessage();  
            }  
            //如果验证出错,向前台返回错误信息"FAILURE"
           return ConstantConfig.RESULT_FAILURE;  
        }  
       //异常捕捉
          /*  String ss = null;
            ss.chars();*/
            result = foodService.getFoodListByParams(foodParams);
            
        return result;
    }

    /**
     * 添加菜品信息
     * 
     * @param foodMap (name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode: 菜品的所属类型; createUser:
     *        菜品的创建人等菜品信息)
     * 
     * @return result json字符串({result:SUCCESS(成功)||FAILURE(失败),data:此次操作改动的条数}) ||
     *         faliure:未知错误;"系统异常":代表系统异常
     *
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    @RequestMapping(value = "insertFood", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertFood(@RequestBody @Valid Food food, BindingResult resultValid) {

        String result = "failure";
        if(resultValid.getErrorCount()>0){  
            for(FieldError error:resultValid.getFieldErrors()){  
                return error.getField()+":"+error.getDefaultMessage();  
            }  
            //如果验证出错,向前台返回错误信息"FAILURE"
           return ConstantConfig.RESULT_FAILURE;  
        }
      //异常捕捉
        try {
            result = foodService.insertFoodMessage(food);
        } catch (Exception e) {
            log.error("参数：" + food.toString() + "\n错误信息：" + e.toString());
            result = ConstantConfig.SystemException;
        }
        return result;
    }

    /**
     * 修改菜品信息
     * 
     * @param foodMap (name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode: 菜品的所属类型; createUser:
     *        菜品的创建人等菜品信息)
     * 
     * @return result json字符串({result:SUCCESS(成功)||FAILURE(失败),data:此次操作改动的条数}) ||
     *         faliure:未知错误;"系统异常":代表系统异常
     * 
     * @update 朱同(雏鹰订餐系统组) 2017年12月14日
     */
    @RequestMapping(value = "/updateFood", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateFood(@RequestBody @Valid Food food, BindingResult bingingresult) {

        if(bingingresult.getErrorCount()>0){  
            for(FieldError error:bingingresult.getFieldErrors()){  
                return error.getField()+":"+error.getDefaultMessage();  
            }  
            //如果验证出错,向前台返回错误信息"FAILURE"
           return ConstantConfig.RESULT_FAILURE;  
        }
        String result = "failure";
      //异常捕捉
        try {
            result = foodService.updateFoodMessage(food);
        } catch (Exception e) {
            log.error("参数：" + food.toString() + "\n错误信息：" + e.toString());
            result = ConstantConfig.SystemException;
        }
        return result;
    }

    /**
     * 逻辑删除菜品信息
     * 
     * @param foodMap (name: 菜品名称 price: 菜品的价格； number: 菜品的剩余数量; foodTypeCode: 菜品的所属类型; createUser:
     *        菜品的创建人等菜品信息)
     * 
     * @return result json字符串({result:SUCCESS(成功)||FAILURE(失败),data:此次操作改动的条数}) ||
     *         faliure:未知错误;"系统异常":代表系统异常
     * 
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    @RequestMapping(value = "/deleteFood", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String deleteFood(@RequestBody @Valid Food food,BindingResult bingingresult) {

        if(bingingresult.getErrorCount()>0){  
            for(FieldError error:bingingresult.getFieldErrors()){  
                log.error(error.getField()+":"+error.getDefaultMessage());
                return error.getField()+":"+error.getDefaultMessage();  
            }  
            //如果验证出错,向前台返回错误信息"FAILURE"
           return ConstantConfig.RESULT_FAILURE;  
        }
        String result = "failure";
      //异常捕捉
        try {
            result = foodService.updateFoodMessage(food);
        } catch (Exception e) {
            log.error("参数：" + food.toString() + "\n错误信息：" + e.toString());
            result = ConstantConfig.SystemException;
        }
        return result;
    }
}
