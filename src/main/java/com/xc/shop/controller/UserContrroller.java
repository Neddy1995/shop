package com.xc.shop.controller;

import com.xc.shop.bean.User;
import com.xc.shop.dao.UserMapper;
import com.xc.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserContrroller {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /**
     * 测试
     * @return
     */
    @RequestMapping("/user")
    public String userTest(){
        User user = userMapper.selectByPrimaryKey("12");
        return "" + user.toString();
    }

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String userLogin(String name,String password){
        User user = userService.login(name,password);
        if (user !=null){
            user.toString();
            return "index";
        }
        return "login";
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public String userRegister(User user){
        boolean i = userService.register(user);
        if (i){
            return "login";
        }
        System.out.printf("已存在该用户");
        return "register";
    }

    /**
     * 查询用户信息
     * @param id
     * @return 用户信息
     */
    @RequestMapping("/userInfo")
    public String userInfo(String id){
        User user = userService.selectUserByKey(id);
        return "" + user.toString();
    }
}