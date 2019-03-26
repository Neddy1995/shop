package com.xc.shop.service;

import com.xc.shop.bean.Address;
import com.xc.shop.dao.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 添加一个收货地址
     * @param address
     */
    public void addAddress(Address address) {
        addressMapper.insert(address);
    }


    /**
     * 查询一个收货地址
     * @param addressId
     * @return
     */
    public Address selectOneAddress(String addressId) {

        Address address = addressMapper.selectByPrimaryKey(addressId);
        return address;
    }


    /**
     * 查询所有收货地址
     * @param userId
     * @return
     */
    public List<Address> selectAllAddress(String userId) {
        List<Address> list = addressMapper.selectAllAddress(userId);
        return list;
    }

    /**
     * 删除一条收货地址
     * @param addressId
     */
    public void deleteAddress(String addressId) {
        addressMapper.deleteByPrimaryKey(addressId);
    }

    public void updateAddress(Address address) {
        addressMapper.updateByPrimaryKeySelective(address);
    }
}
