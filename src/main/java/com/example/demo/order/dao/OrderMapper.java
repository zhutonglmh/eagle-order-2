package com.example.demo.order.dao;

import java.util.List;

import com.example.demo.order.pojo.Order;


/**
 * 订单信息表的处理方法Dao接口
 * @author 勾洪成 2017年12月9日10:45:30
 *
 */
public interface OrderMapper {
	
	/**
	 * 插入单条数据
	 * 
	 * @param order(封装了订单的信息)
	 * 
	 * @return 插入成功的数量
	 */
	int insertOrder(Order order);
	
	/**
	 * 查询单个billId所对应的所有订单
	 * 
	 * @param billId(根据订单号来查订单信息)
	 * 
	 * @return List<Order> 返回每个流水号中所含订单表中信息
	 */
	List<Order> selectOrder(int billId);
	
	/**
	 * 批量插入订单
	 * 
	 * @param list
	 * 
	 * @return 插入成功的数量
	 */
	int insertOrderList(List<Order>list);
}
