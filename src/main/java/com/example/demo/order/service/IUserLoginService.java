package com.example.demo.order.service;

import java.util.Map;

/**
 * 
 * 用户登录业务处理  service层接口
 *            
 * @author 朱同 2017/12/7
 *
 */
public interface IUserLoginService {
	
    /**
     * 用户登录校验处理
     *      (调用了service层方法)
     * 
     * @param param 
     *      (userName: 用户名； password: 密码)
     * @return 
     *      (result:验证结果；userName：用户名)
     */
	public Map<String,Object> LoginCheck(Map<String,Object> map);
}
