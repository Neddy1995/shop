package com.xc.shop.dao;

import com.xc.shop.bean.OrderDetails;
import com.xc.shop.vo.OrderDetailVo;
import com.xc.shop.vo.OrderDetailsPo;

import java.util.List;

public interface OrderDetailsMapper {
    int deleteByPrimaryKey(String detailId);

    int insert(OrderDetails record);

    int insertSelective(OrderDetails record);

    OrderDetails selectByPrimaryKey(String detailId);

    int updateByPrimaryKeySelective(OrderDetails record);

    int updateByPrimaryKey(OrderDetails record);

    List<OrderDetailsPo> selectDetailsByOrder(String orderId);
}