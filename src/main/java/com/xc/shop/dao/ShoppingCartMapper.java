package com.xc.shop.dao;

import com.xc.shop.bean.ShoppingCart;
import com.xc.shop.pojo.ShoppingCartPo;

import java.util.List;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(String cartId);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(String cartId);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);


//    查询购物车中是否已存在这条记录
    ShoppingCart selectByUserAndGood(ShoppingCart record);

//    查询用户购物车信息
    List<ShoppingCartPo> selectGoodByUser(String userId);

//    删除购物车中的部分记录
    void deleteByListKey(List list);
}