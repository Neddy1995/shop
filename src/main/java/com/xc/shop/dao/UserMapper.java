package com.xc.shop.dao;

import com.xc.shop.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //登录操作
    User login(User user);

    User selectUserByName(String userName);
}