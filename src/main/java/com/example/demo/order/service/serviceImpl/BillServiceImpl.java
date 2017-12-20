package com.example.demo.order.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.utils.ConstantConfig;
import com.example.demo.order.dao.BillMapper;
import com.example.demo.order.dao.FoodMapper;
import com.example.demo.order.dao.OrderMapper;
import com.example.demo.order.dao.TableMapper;
import com.example.demo.order.pojo.Bill;
import com.example.demo.order.pojo.Food;
import com.example.demo.order.pojo.Order;
import com.example.demo.order.pojo.Table;
import com.example.demo.order.service.IBillService;
import com.example.demo.order.service.IFoodService;
import com.example.demo.order.service.IOrderService;
import com.example.demo.order.vo.BillDetailResponseFoodInfoVO;
import com.example.demo.order.vo.BillDetailResponseInfoVO;
import com.example.demo.order.vo.BillMessageRequestVO;

/**
 * 
 * 与账单有关的服务类
 * 
 * @author 苏先华
 * 
 */
@Service
public class BillServiceImpl implements IBillService{

    @Resource
    BillMapper billMapper;
    
    @Resource
    OrderMapper orderMapper;
    
    @Resource
    FoodMapper foodMapper;
    
    @Resource
    IFoodService foodService;
    
    @Resource
    IOrderService orderService;
    
    @Resource
    TableMapper tableMapper;
    
    /**
     * 点单
     * @param map 账单所需要的相关信息的内容
     * 
     * @return 返回点单是否成功
     */
    @Transactional
    public String checkOrder(BillMessageRequestVO billMessageInfo) throws Exception{
        int tableId = billMessageInfo.getTableId();
        int moneyTotal = billMessageInfo.getMoneyTotal();
        
        JSONObject resultJson = new JSONObject();
        resultJson.put(ConstantConfig.BILL_STATE, ConstantConfig.BILL_STATE_PLACE_ORDER);
        resultJson.put(ConstantConfig.BILL_STATE_TEXT, ConstantConfig.BILL_STATE_PLACE_ORDER_TEXT);
        
        if(!orderService.marginCheck(billMessageInfo.getFood())) {
            resultJson.put(ConstantConfig.BILL_ID, ConstantConfig.RETURN_STATE_EXCEPTION);
            return resultJson.toJSONString();
        }
        
        
        Bill bill = new Bill();
        bill.setTableId(tableId);
        SimpleDateFormat sf = new SimpleDateFormat(ConstantConfig.DATE_FORMAT);
        String createTime = sf.format(new Date());
        bill.setCreateTime(createTime);
        bill.setCreateUser("日番谷·冬狮郎");
        bill.setDeleteFlag(ConstantConfig.DELETE_FLAG_FALSE);
        bill.setState(ConstantConfig.BILL_STATE_PLACE_ORDER);
        bill.setUpdateTime(createTime);
        bill.setUpdateUser("日番谷·冬狮郎");
        bill.setMoneyTotal(moneyTotal);
        billMapper.insert(bill);
        
        Table table = new Table();
        table.setId(tableId);
        table.setState((byte)1);
        
        tableMapper.updateByPrimaryKeySelective(table);
        
        orderService.insert(bill.getId(),billMessageInfo.getFood());
        resultJson.put(ConstantConfig.BILL_ID, bill.getId());
        
        String result = resultJson.toJSONString();
        
        return result;
    }

    /**
     * 确认订单
     * 
     * @param BillId 账单流水号
     * 
     * @return 返回1表示确认成功
     */
    public String confirmOrder(int billId) throws Exception{
        Bill bill = new Bill();
        bill.setId(billId);
        bill.setUpdateUser("风语者艾玛丝");
        SimpleDateFormat sf = new SimpleDateFormat(ConstantConfig.DATE_FORMAT);
        String updateTime = sf.format(new Date());
        bill.setUpdateTime(updateTime);
        bill.setState((byte)1);
        
        billMapper.updateByPrimaryKeySelective(bill);
        
        JSONObject resultJson = new JSONObject();
        resultJson.put(ConstantConfig.BILL_ID, billId);
        resultJson.put(ConstantConfig.BILL_STATE, ConstantConfig.BILL_STATE_LOCK_BILL);
        resultJson.put(ConstantConfig.BILL_STATE_TEXT, ConstantConfig.BILL_STATE_LOCK_BILL_TEXT);
        
        
        return resultJson.toJSONString();
    }

    /**
     * 确认付款
     * 
     * @param BillId 账单流水号
     * 
     * @return 返回1表示付款成功
     */
    public String confirmPayment(int billId) throws Exception{
        Bill bill = new Bill();
        bill.setId(billId);
        bill.setUpdateUser("探险家伊泽瑞尔");
        SimpleDateFormat sf = new SimpleDateFormat(ConstantConfig.DATE_FORMAT);
        String updateTime = sf.format(new Date());
        bill.setUpdateTime(updateTime);
        bill.setState(ConstantConfig.BILL_STATE_ACCOUNT_PAID);
        billMapper.updateByPrimaryKeySelective(bill);
        
        bill = billMapper.selectBillById(billId).get(0);
        
        Table table = new Table();
        table.setId(bill.getTableId());
        table.setState((byte)0);
        
        tableMapper.updateByPrimaryKeySelective(table);
        
        
        JSONObject resultJson = new JSONObject();
        resultJson.put(ConstantConfig.BILL_ID, billId);
        resultJson.put(ConstantConfig.BILL_STATE, ConstantConfig.BILL_STATE_ACCOUNT_PAID);
        resultJson.put(ConstantConfig.BILL_STATE_TEXT, ConstantConfig.BILL_STATE_ACCOUNT_PAID_TEXT);
        
        
        return resultJson.toJSONString();
    }

    /**
     * 通过账单流水号号查询账单信息
     * 
     * @param Billid账单流水号
     * 
     * @return 返回Bill信息的一个集合
     */
    public String getBillById(int billId) throws Exception{
        List<Bill> billList = new ArrayList<Bill>();
        billList = billMapper.selectBillById(billId);
        String data = JSON.toJSONString(billList);
        return data;
    }

    /**
     * 通过流水单号范围查询账单信息
     * 
     * @param lowerBound 范围下界
     * @param upperBound 范围上界
     * 
     * @return 返回Bill信息的一个集合
     */
    public String getBillByIdRange(int lowerBound, int upperBound) throws Exception{
        List<Bill> billList = new ArrayList<Bill>();
        billList = billMapper.selectBillByIdRange(lowerBound, upperBound);
        String data = JSON.toJSONString(billList);
        return data;
    }

    /**
     * 根据桌号查询账单信息
     * 
     * @param tableId 桌号
     * 
     * @return 返回Bill信息的一个集合
     */
    public String getBillByTableId(int tableId) throws Exception{
        List<Bill> billList = new ArrayList<Bill>();
        try {
            billList = billMapper.selectBillByTableId(tableId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw e;
        }
        String data = JSON.toJSONString(billList);
        return data;
    }

    /**
     * 通过桌号范围查询账单信息
     * 
     * @param lowerBound 范围下界
     * @param upperBound 范围上界
     * 
     * @return 返回Bill信息的一个集合
     */
    public String getBillByTableIdRange(int lowerBound, int upperBound) throws Exception{
        List<Bill> billList = new ArrayList<Bill>();
        billList = billMapper.selectBillByTableIdRange(lowerBound, upperBound);
        String data = JSON.toJSONString(billList);
        return data;
    }

    public String getBillByTotalPrize(int moneyTotal) throws Exception{
        List<Bill> billList = new ArrayList<Bill>();
        billList = billMapper.selectBillByTotalPrize(moneyTotal);
        String data = JSON.toJSONString(billList);
        return data;
    }

    public String getBillByTotalPrizeRange(int lowerBound, int upperBound) throws Exception{
        List<Bill> billList = new ArrayList<Bill>();
        billList = billMapper.selectBillByTotalPrizeRange(lowerBound, upperBound);
        String data = JSON.toJSONString(billList);
        return data;
    }

    public String getBillByState(int state) throws Exception{
        List<Bill> billList = new ArrayList<Bill>();
        billList = billMapper.selectBillByState(state);
        String data = JSON.toJSONString(billList);
        return data;
    }

    public String getBillByStateRange(int lowerBound, int upperBound) throws Exception{
        List<Bill> billList = new ArrayList<Bill>();
        billList = billMapper.selectBillByStateRange(lowerBound, upperBound);
        String data = JSON.toJSONString(billList);
        return data;
    }

    public String detailBillInfo(int billId) throws Exception{
        List<Bill> billList = new ArrayList<Bill>();
        billList = billMapper.selectBillById(billId);
        String result="";
        
        foodService.foodMapUpdate();
        
        if(!billList.isEmpty()) {
            Bill bill = billList.get(0);
            BillDetailResponseInfoVO billDetailResponseInfoVO = new BillDetailResponseInfoVO();
            billDetailResponseInfoVO.setBillId(billId);
            billDetailResponseInfoVO.setCreateTime(bill.getCreateTime());
            billDetailResponseInfoVO.setCreateUser(bill.getCreateUser());
            billDetailResponseInfoVO.setMoneyTotal(bill.getMoneyTotal().toString());
            billDetailResponseInfoVO.setState(bill.getState().toString());
            if(ConstantConfig.BILL_STATE_PLACE_ORDER==bill.getState()) {
                billDetailResponseInfoVO.setStateText(ConstantConfig.BILL_STATE_PLACE_ORDER_TEXT);
            } else if(ConstantConfig.BILL_STATE_LOCK_BILL==bill.getState()) {
                billDetailResponseInfoVO.setStateText(ConstantConfig.BILL_STATE_LOCK_BILL_TEXT);
            } else if(ConstantConfig.BILL_STATE_ACCOUNT_PAID==bill.getState()) {
                billDetailResponseInfoVO.setStateText(ConstantConfig.BILL_STATE_ACCOUNT_PAID_TEXT);
            }
            billDetailResponseInfoVO.setTableId(bill.getTableId().toString());
            
            List<BillDetailResponseFoodInfoVO>orderDetail = new ArrayList<BillDetailResponseFoodInfoVO>();
            List<Order>orderList = orderMapper.selectOrder(billId);
            for(Order varOrder : orderList) {
                BillDetailResponseFoodInfoVO varOrderDetail = new BillDetailResponseFoodInfoVO();
                Food varFood = foodService.mapGetFoodById(varOrder.getFoodId());
                if(varFood == null)continue;
                varOrderDetail.setFoodId(varOrder.getFoodId());
                varOrderDetail.setFoodName(varFood.getName());
                varOrderDetail.setFoodNumber(varOrder.getNumber());
                varOrderDetail.setFoodPrize(varFood.getPrice());
                varOrderDetail.setFoodTotalPrize(varOrder.getNumber()*varFood.getPrice());
                orderDetail.add(varOrderDetail);
            }
            billDetailResponseInfoVO.setOrderDetail(orderDetail);
            
            result = JSON.toJSONString(billDetailResponseInfoVO);
            
        } else {
            result = ConstantConfig.RETURN_STATE_EXCEPTION;
        }
        return result;
    }

}
