package com.xc.shop.dao;

import com.xc.shop.bean.MobilePhone;
import org.apache.ibatis.annotations.Param;

public interface MobilePhoneMapper {
    int insert(MobilePhone record);

    int insertSelective(MobilePhone record);

    MobilePhone selectMobilePhoneGoodDetail(@Param("goodId") String goodId);
}