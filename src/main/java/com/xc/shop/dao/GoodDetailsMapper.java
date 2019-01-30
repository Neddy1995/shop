package com.xc.shop.dao;

import com.xc.shop.bean.GoodDetails;

public interface GoodDetailsMapper {
    int deleteByPrimaryKey(Integer detailId);

    int insert(GoodDetails record);

    int insertSelective(GoodDetails record);

    GoodDetails selectByPrimaryKey(Integer detailId);

    int updateByPrimaryKeySelective(GoodDetails record);

    int updateByPrimaryKey(GoodDetails record);
}