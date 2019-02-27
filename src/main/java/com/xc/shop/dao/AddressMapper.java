package com.xc.shop.dao;

import com.xc.shop.bean.Address;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(String addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(String addressId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> selectAllAddress(String userId);
}