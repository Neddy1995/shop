package com.xc.shop.service;

import com.xc.shop.bean.User;
import com.xc.shop.dao.UserMapper;
import com.xc.shop.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param name
     * @param password
     * @return user：登录成功，返回用户信息
     * @return null：登录失败，返回空
     */
    public User login(String name, String password) {
        User userLogin = new User();
        userLogin.setUserName(name);
        userLogin.setPassword(password);
//        登录查询
        User user = userMapper.login(userLogin);
        if (user != null) {
            return user;
        }
        return null;
    }

    /**
     * 注册
     * @param user
     * @return true:无用户名，注册成功
     * false：有用户名，注册失败
     */
    public boolean register(User user){
//        查询是否存在用户名
        User haveUser = userMapper.selectUserByName(user.getUserName());
        if(haveUser == null){
//            自动生成注册时间，权限
            System.out.printf(user.getUserName());
            user.setRegtime(new TimeUtil().toString(new Date()));
            user.setPower(1);
//            插入用户
            userMapper.insert(user);
            return true;
        }
        return false;
    }

    /**
     *查询用户信息
     * @param id
     * @return user
     */
    public User selectUserByKey(String id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    /**
     * 修改用户信息
     * @param user
     */
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
