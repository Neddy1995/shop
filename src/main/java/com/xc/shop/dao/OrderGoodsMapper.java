package com.xc.shop.dao;

import com.xc.shop.bean.OrderGoods;
import com.xc.shop.vo.GoodByCartVo;

import java.util.List;

public interface OrderGoodsMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    OrderGoods selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);

    List selectAllOrderByUser(String userId);

    List<GoodByCartVo> selectGoodByCart(List list);
}