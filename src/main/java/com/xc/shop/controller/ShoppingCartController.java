package com.xc.shop.controller;

import com.xc.shop.bean.ShoppingCart;
import com.xc.shop.pojo.ShoppingCartPo;
import com.xc.shop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService  shoppingCartService;

    @RequestMapping("/addCart")
    public String addCartGoodByUser(String userId,int number,int goodId){
        shoppingCartService.addCartGoodByUser(userId,number,goodId);
        return "添加成功！";
    }

    /**
     * 查询用户添加到购物车的所有商品
     * @param userId
     * @return
     */
    @RequestMapping("/selectAllCart")
    public List<ShoppingCartPo> selectAllCart(String userId){
        List<ShoppingCartPo> list = shoppingCartService.selectAllCart(userId);
        return list;
    }

    @RequestMapping("/deleteCart")
    public String DeleteCart(List list){
        shoppingCartService.deleteCart(list);
        return "删除成功";
    }



}
