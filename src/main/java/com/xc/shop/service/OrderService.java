package com.xc.shop.service;

import com.xc.shop.bean.OrderDetails;
import com.xc.shop.bean.OrderGoods;
import com.xc.shop.bean.ShoppingCart;
import com.xc.shop.dao.OrderDetailsMapper;
import com.xc.shop.dao.OrderGoodsMapper;
import com.xc.shop.dao.ShoppingCartMapper;
import com.xc.shop.util.TimeUtil;
import com.xc.shop.vo.GoodByCartVo;
import com.xc.shop.vo.OrderDetailsPo;
import com.xc.shop.vo.OrderGoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    public List<OrderGoodVo> selectAllOrder(String userId){
//        查询订单
        List<OrderGoods> list = orderGoodsMapper.selectAllOrderByUser(userId);
        List<OrderGoodVo> list1=new ArrayList<>();
//        循环查询订单详情
        for (OrderGoods orderGoods: list) {
//            先将订单信息插入到Vo对象中
            OrderGoodVo orderGoodVo = new OrderGoodVo();
            orderGoodVo.setBeginTime(orderGoods.getBeginTime());
            orderGoodVo.setState(orderGoods.getState());
            orderGoodVo.setAddressId(orderGoods.getAddressId());
            orderGoodVo.setUserId(orderGoods.getUserId());
            orderGoodVo.setOrderId(orderGoods.getOrderId());
            orderGoodVo.setEndTime(orderGoods.getEndTime());
//            查询订单详情作为list放入Vo对象
            List<OrderDetailsPo> list2 = orderDetailsMapper.selectDetailsByOrder(orderGoods.getOrderId());
            orderGoodVo.setList(list2);
            list1.add(orderGoodVo);
        }
        return list1;
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
    public void insertOrder(String userId, String addressId, List<String> list) {
        TimeUtil timeUtil = new TimeUtil();
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setAddressId(addressId);
        orderGoods.setUserId(userId);
        orderGoods.setBeginTime(timeUtil.toString(new Date()));
//        初始设置为0未支付
        orderGoods.setState("0");
//        插入数据到订单表
        orderGoodsMapper.insert(orderGoods);
//        从购物车循环插入数据到详情表
        for (String shoppingCartId:list) {
            ShoppingCart shoppingCart = shoppingCartMapper.selectByPrimaryKey(shoppingCartId);
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setGoodId(shoppingCart.getGoodId());
            orderDetails.setNumber(shoppingCart.getNumber());
            orderDetails.setOrderId(orderGoods.getOrderId());
            orderDetailsMapper.insert(orderDetails);
        }
//        删除购物车中的商品
        shoppingCartMapper.deleteByListKey(list);
    }

    /**
     * 删除订单信息
     * @param orderId
     */
    public void deleteOrder(String orderId) {
        orderGoodsMapper.deleteByPrimaryKey(orderId);
        orderDetailsMapper.deleteByPrimaryKey(orderId);
    }
}
