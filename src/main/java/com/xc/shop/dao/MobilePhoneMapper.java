package com.xc.shop.dao;

import com.xc.shop.bean.MobilePhone;

public interface MobilePhoneMapper {
    int insert(MobilePhone record);

    int insertSelective(MobilePhone record);
}