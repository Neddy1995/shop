package com.xc.shop.dao;

import com.xc.shop.bean.OrderGoods;

public interface OrderGoodsMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    OrderGoods selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);
}