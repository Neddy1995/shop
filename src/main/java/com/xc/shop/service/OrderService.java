package com.xc.shop.service;

import com.xc.shop.bean.OrderGoods;
import com.xc.shop.dao.OrderGoodsMapper;
import com.xc.shop.util.TimeUtil;
import com.xc.shop.vo.GoodByCartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    public void selectAllOrder(String userId){
//        List list = orderGoodsMapper.selectAllOrderByUser(userId);
    }

    /**
     * 查询需要结算的商品
     * @param list
     * @return
     */
    public List<GoodByCartVo> selectGoodByCart(List list) {
        List<GoodByCartVo> list1 = orderGoodsMapper.selectGoodByCart(list);
        return list1;
    }

    /**
     * 创建订单
     * @param userId
     * @param addressId
     * @param list
     */
    public void insertOrder(String userId, String addressId, List list) {
        TimeUtil timeUtil = new TimeUtil();
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setAddressId(addressId);
        orderGoods.setUserId(userId);
        orderGoods.setBeginTime(timeUtil.toString(new Date()));
        orderGoods.setState("0");
        orderGoodsMapper.insert(orderGoods);
        System.out.printf(orderGoods.getOrderId());
    }
}
