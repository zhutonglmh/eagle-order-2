package com.example.demo.order.controller;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.order.service.IUserLoginService;

/**
 * 
 * 用户登录功能 Controller管理类
 * 
 * @author 朱同   2017/12/7
 */
@Controller
@RequestMapping("api/login")
public class UserLoginController {

    /**
     * service 层业务处理类   （以接口类型引入）
     */
    @Resource
    private IUserLoginService userLoginService;

    /**
     * 用户登录校验处理
     *      (调用了service层方法)
     * 
     * @param param 
     *      (userName: 用户名； password: 密码；)
     * @return 
     *      (result:验证结果;)
     */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> loginController(@RequestBody Map<String, Object> param) {
        return userLoginService.LoginCheck(param);
    }
}
