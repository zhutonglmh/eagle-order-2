package com.example.demo.order.service;

import java.util.List;

import com.example.demo.order.pojo.Table;

/**
 * 处理台位逻辑的业务的类
 * @author 勾洪成 2017年12月9日15:08:44
 *
 */
public interface ITableService {
	
	/**
	 * 
	 * @param deleteFlag(这个台位现在是否可用)
	 * @return List<Table> s
	 */
	String selectTable();
	
}
