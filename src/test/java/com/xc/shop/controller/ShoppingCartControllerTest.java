package com.xc.shop.controller;

import com.xc.shop.dao.ShoppingCartMapper;
import com.xc.shop.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartControllerTest {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 测试删除接口
     */
    @Test
    public void name() {
        List list = new ArrayList();
        list.add("1111");
        list.add("1111");
        list.toString();
        shoppingCartService.deleteCart(list);
    }
}