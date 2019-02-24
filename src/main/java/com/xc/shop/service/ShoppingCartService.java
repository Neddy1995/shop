package com.xc.shop.service;


import com.xc.shop.bean.ShoppingCart;
import com.xc.shop.dao.ShoppingCartMapper;
import com.xc.shop.pojo.ShoppingCartPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    /**
     * 先判断是否存在该记录，
     * 不存在则直接插入
     * 存在则数量加一
     * @param userId
     * @param number
     * @param goodId
     */
    public void addCartGoodByUser(String userId,int number,int goodId){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setGoodId(goodId);
        shoppingCart.setNumber(number);
        shoppingCart.setUserId(userId);
        ShoppingCart haveCartGood = shoppingCartMapper.selectByUserAndGood(shoppingCart);
        //不存在时
        if(haveCartGood==null) {
            shoppingCartMapper.insert(shoppingCart);
        }
        //存在时
        else{
            haveCartGood.setNumber(haveCartGood.getNumber()+number);
            shoppingCartMapper.updateByPrimaryKey(haveCartGood);
        }
    }

    /**
     * 查询用户购物车中的所有商品信息
     * @param userId
     * @return
     */
    public List<ShoppingCartPo> selectAllCart(String userId) {
        List<ShoppingCartPo> list = shoppingCartMapper.selectGoodByUser(userId);
        return list;
    }

    /**
     * 删除一个或多个购物车中的商品
     * 在结算时要调用
     * 在删除时也需要调用
     * @param list
     */
    public void deleteCart(List list) {
        shoppingCartMapper.deleteByListKey(list);
    }
}
