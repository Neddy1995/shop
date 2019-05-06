package com.xc.shop.service;

import com.xc.shop.bean.OrderDetails;
import com.xc.shop.bean.OrderGoods;
import com.xc.shop.bean.ShoppingCart;
import com.xc.shop.dao.OrderDetailsMapper;
import com.xc.shop.dao.OrderGoodsMapper;
import com.xc.shop.dao.ShoppingCartMapper;
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

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

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
}
