package com.example.demo.order.service;


import com.example.demo.order.vo.BillMessageRequestVO;

/**
 * 
 * 账单信息service层接口
 *          （用来处理账单表相关逻辑业务）
 *          
 * @author 苏先华  2017/12/10
 *
 */
public interface IBillService {
    
    /**
     * 点单
     * @param map 账单所需要的相关信息的内容
     * 
     * @return 返回点单是否成功
     * @throws Exception 
     */
    String checkOrder(BillMessageRequestVO billMessageInfo) throws Exception;
    
    
    /**
     * 确认订单
     * 
     * @param BillId 账单流水号
     * 
     * @return 返回true表示确认成功
     */
    String confirmOrder(int billId) throws Exception;
    
    
    /**
     * 确认付款
     * 
     * @param BillId 账单流水号
     * 
     * @return 返回true表示付款成功
     */
    String confirmPayment(int billId) throws Exception;
    
    
    /**
     * 通过账单流水号号查询账单信息
     * 
     * @param Billid账单流水号
     * 
     * @return 返回Bill信息的一个集合
     */
    String getBillById(int billId) throws Exception;
    
    
    /**
     * 通过流水单号范围查询账单信息
     * 
     * @param lowerBound 范围下界
     * @param upperBound 范围上界
     * 
     * @return 返回Bill信息的一个集合
     */
    String getBillByIdRange(int lowerBound,int upperBound) throws Exception;
    

    /**
     * 根据桌号查询账单信息
     * 
     * @param tableId 桌号
     * 
     * @return 返回Bill信息的一个集合
     */
    String getBillByTableId(int tableId) throws Exception;
    
    /**
     * 通过桌号范围查询账单信息
     * 
     * @param lowerBound 范围下界
     * @param upperBound 范围上界
     * 
     * @return 返回Bill信息的一个集合
     */
    String getBillByTableIdRange(int lowerBound,int upperBound) throws Exception;
    

    /**
     * 通过账单总价查询账单信息
     * 
     * @param moneyTotal 账单总价
     * 
     * @return 返回Bill信息的一个集合
     */
    String getBillByTotalPrize(int moneyTotal) throws Exception;
    
    /**
     * 通过账单总价范围查询账单信息
     * 
     * @param lowerBound 范围下界
     * @param upperBound 范围上界
     * 
     * @return 返回Bill信息的一个集合
     */
    String getBillByTotalPrizeRange(int lowerBound,int upperBound) throws Exception;
    
    
    /**
     * 通过状态号查询账单信息
     * 
     * @param state 状态号
     * 
     * @return 返回Bill信息的一个集合
     */
    String getBillByState(int state) throws Exception;
    
    /**
     * 通过状态号范围查询账单信息
     * 
     * @param lowerBound 范围下界
     * @param upperBound 范围上界
     * 
     * @return 返回Bill信息的一个集合
     */
    String getBillByStateRange(int lowerBound,int upperBound) throws Exception;
    
    
    /**
     * 通过账单流水号查询账单的具体信息
     * @param billId 账单流水号
     * @return 账单的具体信息
     */
    String detailBillInfo(int billId) throws Exception;
}
