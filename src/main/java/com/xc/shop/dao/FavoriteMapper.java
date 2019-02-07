package com.xc.shop.dao;

import com.xc.shop.bean.Favorite;

public interface FavoriteMapper {
    int deleteByPrimaryKey(String favoriteId);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(String favoriteId);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
}