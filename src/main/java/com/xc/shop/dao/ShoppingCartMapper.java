package com.xc.shop.dao;

import com.xc.shop.bean.ShoppingCart;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(String cartId);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(String cartId);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
}