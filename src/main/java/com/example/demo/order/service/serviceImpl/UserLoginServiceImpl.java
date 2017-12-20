package com.example.demo.order.service.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.common.utils.Md5;
import com.example.demo.order.dao.UserLoginMapper;
import com.example.demo.order.pojo.UserLogin;
import com.example.demo.order.service.IUserLoginService;

/**
 * 
 * 用户登录业务处理service 实现层
 *       (实现了service层接口中的方法)
 *            
 * @author 朱同 2017/12/7
 *
 */
@Service("userLoginService")
public class UserLoginServiceImpl implements IUserLoginService{

    /**
     * 以dao层接口类型引入dao层实现类
     *      (用户登录处理方法类)
     */
	@Autowired
	private UserLoginMapper userLoginMapper;
	
	/**
	 * 用户实体pojo类
	 */
	private UserLogin user;

	/**
     * 用户登录校验处理
     *      (调用了service层方法)
     * 
     * @param param 
     *      (userName: 用户名； password: 密码)
     * @return 
     *      (result:验证结果；userName：用户名)
     */
    public Map<String, Object> LoginCheck(Map<String, Object> map) {
            String result = "false";
            Map<String,Object> params = new HashMap<String,Object>();
            Map<String,Object> resultMap = new HashMap<String,Object>();
            String userName = (String) map.get("userName");
            String password = (String) map.get("password");
            params.put("username", userName);
            user = userLoginMapper.selectUserMse(params);
            if(user != null){
                //调用md5 获取密码加密后的形式
                String userPassword = Md5.getMd5ByParams(password);
                String sqlPassword = user.getUserpassword();
                if(userPassword.equals(sqlPassword)){
                    result = "success";
                }
                else{
                    result = "false";
                }
            }
            else{
                result = "false";
            }
            resultMap.put("result", result); 
            resultMap.put("userName", userName);
            return resultMap;
    }
}
