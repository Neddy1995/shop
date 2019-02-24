package com.xc.shop.controller;

import com.xc.shop.bean.ShoppingCart;
import com.xc.shop.service.ShoppingCartService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShoppingCartControllerTest {


    @Test
    public void deleteCart() {
        List list = new ArrayList();
        list.add("1111");
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        shoppingCartService.deleteCart(list);
    }
}