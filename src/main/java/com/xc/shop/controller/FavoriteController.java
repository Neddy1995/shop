package com.xc.shop.controller;

import com.xc.shop.pojo.FavoritePo;
import com.xc.shop.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    /**
     * 查询用户所有收藏的商品
     * @param userId
     * @return
     */
    @RequestMapping("/selectAllFavorite.do")
    public List<FavoritePo> selectAllByUser(String userId){
        List<FavoritePo> list = favoriteService.selectAllByUser(userId);
        return list;
    }

    /**
     * 插入一条收藏夹
     * @param userId
     * @param goodId
     * @return
     */
    @RequestMapping("/insertFavorite")
    public String insertFavorite(String userId,String goodId){
        boolean i = favoriteService.insertFavorite(userId,goodId);
        if(i){
            return "收藏成功";
        }
        return "已存在该藏品，不能重复收藏！";
    }

    /**
     * 删除用户勾选的部分商品
     * @param list 封装的为每条收藏夹的id
     * @return
     */
    @RequestMapping("/DeleteFavorite")
    public String DeleteFavorite(List list){
        favoriteService.deleteFavorite(list);
        return "删除成功！";
    }
}
