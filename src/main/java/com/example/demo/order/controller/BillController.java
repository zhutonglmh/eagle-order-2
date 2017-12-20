package com.example.demo.order.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.utils.ConstantConfig;
import com.example.demo.order.service.IBillService;
import com.example.demo.order.vo.BillBillIdRequestVO;
import com.example.demo.order.vo.BillMessageRequestVO;
import com.example.demo.order.vo.BillRangeQueryRequestVO;
import com.example.demo.order.vo.BillStateRequestVO;
import com.example.demo.order.vo.BillTableIdRequestVO;
import com.example.demo.order.vo.BillTotalPrizeRequestVO;

@Controller
@RequestMapping("api/bill")
public class BillController {
    
    @Resource
    IBillService billService;

    /**
     * 用以制作日志信息的对象
     */
    private static final Logger logger = LoggerFactory.getLogger(BillController.class);



    /**
     * @author 苏先华 勾洪城
     * 
     * @param billMessageInfo 点单信息对象{ tableId:桌子id
     * 
     *        }
     * 
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkOrder", produces = "text/json;charset=UTF-8")
    public String checkOrder(@RequestBody BillMessageRequestVO billMessageInfo) {
        String result = ConstantConfig.RESPONSE_ERROR;
        try {
            result = billService.checkOrder(billMessageInfo);
            // new Exception();
        } catch (Exception e) {
            logger.error("参数：" + billMessageInfo.toString() + "\n错误信息：" + e.getLocalizedMessage()
                    + e.getMessage());
        }
        return result;
    }


    /**
     * 确认订单
     * 
     * @param BillId 账单流水号
     * 
     * @return 返回true表示确认成功
     * 
     * @author 苏先华 勾洪城
     */
    @RequestMapping(value = "/confirmOrder", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String confirmOrder(@RequestBody BillBillIdRequestVO billIdRequest) {
        String result = ConstantConfig.RESPONSE_ERROR;
        try {
            result = billService.confirmOrder(billIdRequest.getBillId());
        } catch (Exception e) {
            logger.error("参数：" + billIdRequest.toString() + "\n错误信息：" + e.getLocalizedMessage()
                    + e.getMessage());
        }
        return result;
    }


    /**
     * 确认付款
     * 
     * @param BillId 账单流水号
     * 
     * @return 返回true表示付款成功
     * 
     * @author 苏先华 勾洪城
     */
    @RequestMapping(value = "/confirmPayment", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String confirmPayment(@RequestBody BillBillIdRequestVO billIdRequest) {
        // /@Param("billId")int billId
        String result = ConstantConfig.RESPONSE_ERROR;
        try {
            result = billService.confirmPayment(billIdRequest.getBillId());
        } catch (Exception e) {
            logger.error("参数：" + billIdRequest.toString() + "\n错误信息：" + e.getLocalizedMessage()
                    + e.getMessage());
        }
        return result;
    }



    /**
     * 通过账单流水号号查询账单信息
     * 
     * @param Billid账单流水号
     * 
     * @author 苏先华 勾洪城
     * 
     * @return 返回Bill信息的一个集合
     */
    @RequestMapping(value = "/getBillById", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getBillById(@RequestBody BillBillIdRequestVO billIdRequest) {
        // @Param("billId")int billId
        String result = ConstantConfig.RESPONSE_ERROR;
        try {
            result = billService.getBillById(billIdRequest.getBillId());
        } catch (Exception e) {
            logger.error("参数：" + billIdRequest + "\n错误信息：" + e.getLocalizedMessage()
                    + e.getMessage());
        }
        return result;
    }


    /**
     * 通过流水单号范围查询账单信息
     * 
     * @param lowerBound 范围下界
     * @param upperBound 范围上界
     * 
     * @author 苏先华
     * 
     * @return 返回Bill信息的一个集合
     */
    @RequestMapping(value = "/getBillByIdRange", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getBillByIdRange(@RequestBody BillRangeQueryRequestVO billRangeQueryRequest) {
        String result = ConstantConfig.RESPONSE_ERROR;
        try {
            result =
                    billService.getBillByIdRange(billRangeQueryRequest.getLowerBound(),
                            billRangeQueryRequest.getUpperBound());
        } catch (Exception e) {
            logger.error("参数：" + billRangeQueryRequest + "\n错误信息：" + e.getLocalizedMessage()
                    + e.getMessage());
        }
        return result;
    }


    /**
     * 根据桌号查询账单信息
     * 
     * @param tableId 桌号
     * 
     * @author 苏先华
     * 
     * @return 返回Bill信息的一个集合
     */
    @RequestMapping(value = "/getBillByTableId", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getBillByTableId(@RequestBody BillTableIdRequestVO billTableIdRequest) {
        // @Param("tableId")int tableId
        String result = ConstantConfig.DELETE_FLAG_FALSE;
        try {
            result = billService.getBillByTableId(billTableIdRequest.getTableId());
        } catch (Exception e) {
            logger.error("参数：" + billTableIdRequest + "\n错误信息：" + e.getLocalizedMessage()
                    + e.getMessage());
        }
        return result;
    }

    /**
     * 通过桌号范围查询账单信息
     * 
     * @param lowerBound 范围下界
     * @param upperBound 范围上界
     * 
     * @author 苏先华
     * 
     * @return 返回Bill信息的一个集合
     */
    @RequestMapping(value = "/getBillByTableIdRange", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getBillByTableIdRange(@RequestBody BillRangeQueryRequestVO billRangeQueryRequest) {
        // @Param("lowerBound")int lowerBound,@Param("upperBound")int upperBound
        String result = ConstantConfig.RESPONSE_ERROR;
        try {
            result =
                    billService.getBillByTableIdRange(billRangeQueryRequest.getLowerBound(),
                            billRangeQueryRequest.getUpperBound());
        } catch (Exception e) {
            logger.error("参数：" + billRangeQueryRequest.toString() + "\n错误信息："
                    + e.getLocalizedMessage() + e.getMessage());
        }
        return result;
    }


    /**
     * 通过查询所有账单信息
     * 
     * @return 返回Bill信息的一个集合
     * 
     * @author 苏先华
     */
    @RequestMapping(value = "/getBillAll", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getBillAll() {
        String result = ConstantConfig.RESPONSE_ERROR;
        try {
            result = billService.getBillByTableIdRange(0, 4);
        } catch (Exception e) {
            logger.error("参数：无\n错误信息：" + e.getLocalizedMessage() + e.getMessage());
        }
        return result;
    }

    /**
     * 通过账单总价查询账单信息
     * 
     * @param moneyTotal 账单总价
     * 
     * @return 返回Bill信息的一个集合
     * 
     * @author 苏先华
     */
    @RequestMapping(value = "/getBillByTotalPrize", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getBillByTotalPrize(@RequestBody BillTotalPrizeRequestVO billTotalPrizeRequest) {
        // @Param("moneyTotal")int moneyTotal
        String result = ConstantConfig.RESPONSE_ERROR;
        try {
            result = billService.getBillByTotalPrize(billTotalPrizeRequest.getMoneyTotal());
        } catch (Exception e) {
            logger.error("参数：" + billTotalPrizeRequest + "\n错误信息：" + e.getLocalizedMessage()
                    + e.getMessage());
        }
        return result;
    }

    /**
     * 通过账单总价范围查询账单信息
     * 
     * @param lowerBound 范围下界
     * @param upperBound 范围上界
     * 
     * @return 返回Bill信息的一个集合
     * 
     * @author 苏先华
     */
    @RequestMapping(value = "/getBillByTotalPrizeRange", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getBillByTotalPrizeRange(
            @RequestBody BillRangeQueryRequestVO billRangeQueryRequest) {
        // @Param("lowerBound")int lowerBound,@Param("upperBound")int upperBound
        String result = ConstantConfig.RESPONSE_ERROR;
        try {
            result =
                    billService.getBillByTotalPrizeRange(billRangeQueryRequest.getLowerBound(),
                            billRangeQueryRequest.getUpperBound());
        } catch (Exception e) {
            logger.error("参数：" + billRangeQueryRequest + "\n错误信息：" + e.getLocalizedMessage()
                    + e.getMessage());
        }
        return result;
    }


    /**
     * 通过状态号查询账单信息
     * 
     * @param state 状态号
     * 
     * @return 返回Bill信息的一个集合
     * 
     * @author 苏先华 勾洪城
     */
    @RequestMapping(value = "/getBillByState", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getBillByState(@RequestBody BillStateRequestVO billStateRequest) {
        // @Param("state")int state
        String result = ConstantConfig.RESPONSE_ERROR;
        try {
            result = billService.getBillByState(billStateRequest.getState());
        } catch (Exception e) {
            logger.error("参数：" + billStateRequest + "\n错误信息：" + e.getLocalizedMessage()
                    + e.getMessage());
        }
        return result;
    }

    /**
     * 通过状态号范围查询账单信息
     * 
     * @param lowerBound 范围下界
     * @param upperBound 范围上界
     * 
     * @return 返回Bill信息的一个集合
     * 
     * @author 苏先华 勾洪城
     */
    @RequestMapping(value = "/getBillByStateRange", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getBillByStateRange(@RequestBody BillRangeQueryRequestVO billRangeQueryRequest) {
        String result = ConstantConfig.RESPONSE_ERROR;
        try {
            result =
                    billService.getBillByStateRange(billRangeQueryRequest.getLowerBound(),
                            billRangeQueryRequest.getUpperBound());
        } catch (Exception e) {
            logger.error("参数：" + billRangeQueryRequest + "\n错误信息：" + e.getLocalizedMessage()
                    + e.getMessage());
        }
        return result;
    }

    /**
     * 通过账单流水号查询账单的具体信息
     * 
     * @param billId 账单流水号
     * @return 账单的具体信息
     * 
     * @author 苏先华
     */
    @RequestMapping(value = "/detailBillInfo", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String detailBillInfo(@RequestBody BillBillIdRequestVO billIdRequest) {
        String result = ConstantConfig.RESPONSE_ERROR;
        try {
            result = billService.detailBillInfo(billIdRequest.getBillId());
        } catch (Exception e) {
            logger.error("参数：" + billIdRequest + "\n错误信息：" + e.getLocalizedMessage()
                    + e.getMessage());
        }
        return result;
    }
}
