package com.xc.shop.service;


import com.xc.shop.bean.ShoppingCart;
import com.xc.shop.dao.ShoppingCartMapper;
import com.xc.shop.vo.ShoppingCartPo;
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
     * @param goodId
     */
    public void addCartGoodByUser(String userId,String goodId){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setGoodId(goodId);
        shoppingCart.setUserId(userId);
        ShoppingCart haveCartGood = shoppingCartMapper.selectByUserAndGood(shoppingCart);
        //不存在时
        if(haveCartGood==null) {
            shoppingCart.setNumber("1");
            shoppingCartMapper.insert(shoppingCart);
        }
        //存在时
        else{
            haveCartGood.setNumber(Integer.parseInt(haveCartGood.getNumber()) + 1 + "");
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
        System.out.printf("1111111111");
        shoppingCartMapper.deleteByListKey(list);
    }

    /**
     * 修改购物车信息
     * @param shoppingCart
     */
    public void updateByPrimaryKeySelective(ShoppingCart shoppingCart){
        shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart);
    }
}
