package com.example.demo.order.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.order.service.IOrderService;
import com.example.demo.order.service.serviceImpl.OrderServiceImpl;

/**
 * 用于处理订单请求的信息控制层
 * @author 勾洪成 2017年12月9日23:04:31
 *
 */
@Controller
@RequestMapping("api/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
}
