package com.xc.shop.service;

import com.xc.shop.bean.Address;
import com.xc.shop.dao.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
     * 随机产生一条收货地址
     * @param userId
     * @return
     */
    public Address selectOneAddress(String userId) {
        List<Address> list = addressMapper.selectAllAddress(userId);
        Random random = new Random();
        int i = random.nextInt(list.size());
        Address address =list.get(i);
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
