package com.example.demo.order.service;


import java.util.List;
import java.util.Map;

import com.example.demo.order.pojo.Order;
import com.example.demo.order.vo.BillOrderMessageRequestVO;

/**
 * 处理订单信息的业务逻辑的类
 * @author 勾洪成 2017年12月9日23:22:10
 *
 */
public interface IOrderService {
	
    
    
    /**
     * 检验是否每个菜品都还有菜
     * 
     * @param map 菜品Id和 菜品数量的 映射
     * 
     * @return 检验结果
     * @throws Exception 
     */
    boolean marginCheck(List<BillOrderMessageRequestVO> foodList) throws Exception;
    
	/**
	 * @param billId 订单流水号
	 * @param map 菜品Id和 菜品数量的 映射
	 * 
	 * @return 插入结果
	 */
	boolean insert(int billId,List<BillOrderMessageRequestVO> foodList) throws Exception;
	
	/**
	 * 
	 * @param billId(根据订单号来查订单信息)
	 * 
	 * @return List<Order> 返回每个流水号中所含订单表中信息
	 */
	String selectOrder(int billId) throws Exception;
}
