package com.xc.shop.service;

import com.xc.shop.dao.OrderGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    public void selectAllOrder(String userId){
//        List list = orderGoodsMapper.selectAllOrderByUser(userId);
    }
}
