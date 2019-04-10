package com.xc.shop.service;

import com.xc.shop.vo.FavoritePo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FavoriteServiceTest {

    @Autowired
    private FavoriteService favoriteService;

    private String favoriteId;


    @Test
    public void insertFavorite() {
        System.out.printf("11111");
        boolean i = favoriteService.insertFavorite("12","1");
        System.out.printf(""+i);
    }

    @Test
    public void selectAllByUser() {
        List<FavoritePo> list = favoriteService.selectAllByUser("12");
        for (FavoritePo item:list) {
            favoriteId = item.getFavoriteId();
        }
        System.out.printf(""+list);
    }


    @Test
    public void deleteFavorite() {
        List list = new ArrayList();
        favoriteId="26021483625054208";
        list.add(favoriteId);
        favoriteService.deleteFavorite(list);
    }
}