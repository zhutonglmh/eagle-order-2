package com.example.demo.order.dao;

import java.util.Map;

import com.example.demo.order.pojo.UserLogin;

/**
 * 
 * 用户信息表处理方法 dao 层接口
 * 
 * @author 朱同   2017/12/7
 * 
 */
public interface UserLoginMapper {
    
    /**
     * 
     * @param id
     *      (用户id)
     * @return id 
     *      (执行删除该条数据操作后的数据id)
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 
     * @param record
     *      (新增的用户信息数据)
     * @return id
     *      (执行新增操作新增后的该条数据id)
     */
    int insert(UserLogin record);
    
    /**
     * 
     * @param map
     *      (userName: 用户名； password: 密码；)
     * @return
     *      (result:验证结果;)
     */
    UserLogin selectUserMse(Map<String,Object> map);
}