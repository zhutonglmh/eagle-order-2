package com.example.demo.order.dao;

import java.util.List;

import com.example.demo.order.pojo.Bill;


/**
 * 
 * 账单信息dao层 接口
 *          （用来处理账单表相关逻辑业务）
 *          
 * @author 苏先华  2017/12/10
 *
 */
public interface BillMapper {
    
    /**
     * 查询当前最大ID
     * 
     * @return (当前账单表最大ID)
     */
    int selectMaxId();
    
    /**
     * 根据id查询账单表的信息
     * 
     * @param id
     * 
     * @return (账单表的一个集合)
     */
    List<Bill> selectBillById(int id);
    
    
    /**
     * 
     * 根据id的一个范围查询账单表的信息
     * 
     * @param lowerBound  查询范围下界
     * @param upperBound  查询范围上界
     * 
     * @return (账单表的一个集合)
     */
    List<Bill> selectBillByIdRange(int lowerBound,int upperBound);
    
    /**
     * 根据table_id查询账单表的信息
     * 
     * @param table_id
     * 
     * @return (账单表的一个集合)
     */
    List<Bill> selectBillByTableId(int tableId);
    
    /**
     * 
     * 根据table_id的一个范围查询账单表的信息
     * 
     * @param lowerBound  查询范围下界
     * @param upperBound  查询范围上界
     * 
     * @return (账单表的一个集合)
     */
    List<Bill> selectBillByTableIdRange(int lowerBound,int upperBound);
    
    /**
     * 根据total_prize查询账单表的信息
     * 
     * @param total_prize
     * 
     * @return (账单表的一个集合)
     */
    List<Bill> selectBillByTotalPrize(int moneyTotal);
    
    /**
     * 
     * 根据total_prize的一个范围查询账单表的信息
     * 
     * @param lowerBound  查询范围下界
     * @param upperBound  查询范围上界
     * 
     * @return (账单表的一个集合)
     */
    List<Bill> selectBillByTotalPrizeRange(int lowerBound,int upperBound);
    
    /**
     * 根据state查询账单表的信息
     * 
     * @param state
     * 
     * @return (账单表的一个集合)
     */
    List<Bill> selectBillByState(int state);
    
    /**
     * 
     * 根据state的一个范围查询账单表的信息
     * 
     * @param lowerBound  查询范围下界
     * @param upperBound  查询范围上界
     * 
     * @return (账单表的一个集合)
     */
    List<Bill> selectBillByStateRange(int lowerBound,int upperBound);
    
    
    /**
     * 插入一条数据记录
     * 
     * @param record 将要被插入的记录
     * 
     * @return 返回插入是否成功
     */
    int insert(Bill record);
    
    
    /**
     * 更新一条数据
     * 
     * @param record 被更新的数据
     * 
     * @return 更新是否成功
     */
    int updateByPrimaryKeySelective(Bill record);
}