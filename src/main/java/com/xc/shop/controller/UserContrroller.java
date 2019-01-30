package com.xc.shop.controller;

import com.xc.shop.bean.User;
import com.xc.shop.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserContrroller {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    public String userTest(){
        User user = userMapper.selectByPrimaryKey("12");
        return "" + user.toString();
    }

}
