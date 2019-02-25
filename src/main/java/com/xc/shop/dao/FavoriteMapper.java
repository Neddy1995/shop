package com.xc.shop.dao;

import com.xc.shop.bean.Favorite;
import com.xc.shop.pojo.FavoritePo;

import java.util.List;

public interface FavoriteMapper {
    int deleteByPrimaryKey(String favoriteId);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(String favoriteId);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);

    List<FavoritePo> selectByUser(String userId);

    Favorite selectByUserAndGood(Favorite favorite);

    void deleteFavorite(List list);
}