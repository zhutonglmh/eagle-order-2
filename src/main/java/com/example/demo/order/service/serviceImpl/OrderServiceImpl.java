package com.example.demo.order.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.utils.ConstantConfig;
import com.example.demo.order.dao.BillMapper;
import com.example.demo.order.dao.FoodMapper;
import com.example.demo.order.dao.OrderMapper;
import com.example.demo.order.dto.FoodDto;
import com.example.demo.order.pojo.Food;
import com.example.demo.order.pojo.Order;
import com.example.demo.order.service.IFoodService;
import com.example.demo.order.service.IOrderService;
import com.example.demo.order.vo.BillOrderMessageRequestVO;

/**
 * 订单业务逻辑的实现类
 * @author 勾洪成 2017年12月9日23:38:02
 *
 */
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private FoodMapper foodMapper;
	@Autowired
	private IFoodService foodService;
	
	
	
	
	public boolean marginCheck(List<BillOrderMessageRequestVO> foodDetailList) throws Exception{
	    foodService.foodMapUpdate();
	    for(BillOrderMessageRequestVO varFoodDetail : foodDetailList) {
	        Food originalFood = foodService.mapGetFoodById(varFoodDetail.getFoodId());
	        if(varFoodDetail.getFoodNumber()>originalFood.getNumber()) {
	            return false;
	        }
	    }
	    return true;
	}
	
	
	public boolean insert(int billId, List<BillOrderMessageRequestVO> foodDetailList) throws Exception{
		
		SimpleDateFormat sf = new SimpleDateFormat(ConstantConfig.DATE_FORMAT);
		String createTime = sf.format(new Date());
		String updateTime = createTime;
		List<Food> foodList = new ArrayList<Food>();
		List<Order> orderList = new ArrayList<Order>();
		for(BillOrderMessageRequestVO varFoodDetail : foodDetailList) {
		    Order order = new Order();
		    Food food = new Food();
		    
		    food.setId(varFoodDetail.getFoodId());
		    food.setUpdateTime(updateTime);
		    food.setUpdateUser("朽木·露琪亚");
		    Food originalFood = foodService.mapGetFoodById(varFoodDetail.getFoodId());
		    food.setNumber(originalFood.getNumber()-varFoodDetail.getFoodNumber());
		    
		    order.setBillId(billId);
		    order.setCreateTime(createTime);
		    order.setCreateUser("朽木·露琪亚");
		    order.setDeleteFlag(ConstantConfig.DELETE_FLAG_FALSE);
		    order.setFoodId(varFoodDetail.getFoodId());
		    order.setNumber(varFoodDetail.getFoodNumber());
		    order.setUpdateTime(updateTime);
		    order.setUpdateUser("朽木·露琪亚");
		    
		    foodList.add(food);
		    orderList.add(order);
		}
		foodMapper.updateFoodList(foodList);
		orderMapper.insertOrderList(orderList);
		return true;
	}

	
	public String selectOrder(int billId) throws Exception{
		List<Order> orderList = orderMapper.selectOrder(billId);
		String data = JSON.toJSONString(orderList);
		return data;
	}

}
