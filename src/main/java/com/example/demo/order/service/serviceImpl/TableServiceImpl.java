package com.example.demo.order.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.order.dao.TableMapper;
import com.example.demo.order.pojo.Table;
import com.example.demo.order.service.ITableService;

@Service(value="tableServiceImpl")
public class TableServiceImpl implements ITableService {
	
	@Autowired
	private TableMapper tableMapper;
	
	public String selectTable() {
		String deleteFlag = "N";
		List<Table>  tableList = tableMapper.selectTable(deleteFlag);
		String data = JSON.toJSONString(tableList);
		return data;
	}
}
