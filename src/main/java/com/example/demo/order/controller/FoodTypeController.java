package com.example.demo.order.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.utils.ConstantConfig;
import com.example.demo.order.service.IFoodTypeService;

/**
 * 
 * 菜品类别 控制器层(处理关于菜品类别相关的请求)
 * 
 * @author 朱同 2017/12/10
 *
 */
@Controller
@RequestMapping("api/foodType")
public class FoodTypeController {
    
    
    /**
     * 日志输出
     */
     private static final Logger log = LoggerFactory.getLogger(FoodTypeController.class);

    @Resource
    private IFoodTypeService foodTypeService;

    /**
     * 查询所有的菜品类别
     * 
     * @param
     * 
     * @return result json字符串({result:SUCCESS(成功)||FAILURE(失败),data:此次操作改动的条数}) ||
     *         faliure:未知错误;"系统异常":代表系统异常;
     * 
     * @update 朱同 (雏鹰订餐系统组) 2017年12月14日
     */
    @RequestMapping(value = "/getAllFoodType", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getAllFoodType() {
        
        String result = "failure";
        //异常捕捉
        try {
            result =  foodTypeService.getListFoodType();
        } catch (Exception e) {
            log.error("参数：" +  "\n错误信息：" + e.toString());
            result = ConstantConfig.SystemException;
        }
        return result;
    }
}
