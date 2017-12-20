package com.example.demo.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.order.pojo.Table;

/**
 * 台位信息表的处理Dao接口
 * @author 勾洪成 2017年12月9日14:56:39
 *
 */
public interface TableMapper {
	
	/**
	 * 
	 * @return List<Table> 返回所有的台位
	 */
	List<Table> selectTable(String deleteFlag);
	
	
	Table selectByIdAndState(@Param("iddd") int id, @Param("stated")String state);
	
	int updateByPrimaryKeySelective(Table table);
    
}