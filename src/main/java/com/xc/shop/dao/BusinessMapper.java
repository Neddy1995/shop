package com.xc.shop.dao;

import com.xc.shop.bean.Business;

public interface BusinessMapper {
    int deleteByPrimaryKey(String businessId);

    int insert(Business record);

    int insertSelective(Business record);

    Business selectByPrimaryKey(String businessId);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);
}