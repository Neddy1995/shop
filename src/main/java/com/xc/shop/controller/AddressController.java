package com.xc.shop.controller;

import com.xc.shop.bean.Address;
import com.xc.shop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 添加收货地址
     * @param name
     * @param phone
     * @param prov
     * @param city
     * @param area
     * @param street
     * @param info
     * @param userId
     * @return
     */
    @RequestMapping("/addAddress")
    public String addAddress(String name,String phone,String prov,String city,String area,String street,String info,String userId){
        Address address = new Address();
        address.setAddressName(name);
        address.setAddressPhone(phone);
        address.setAddressProv(prov);
        address.setAddressCity(city);
        address.setAddressArea(area);
        address.setAddressStreet(street);
        address.setAddressInfo(info);
        address.setUserId(userId);
        addressService.addAddress(address);
        return "添加成功";
    }

    /**
     * 查询一条记录
     * @return
     */
    @RequestMapping("/selectOneAddress")
    public Address selectAddress(String addressId){
        Address address = addressService.selectOneAddress(addressId);
        return address;
    }

    /**
     * 查询所有收货地址
     * @return
     */
    @RequestMapping("/selectAllAddress")
    public List selectAllAddress(String userId){
        List<Address> list = addressService.selectAllAddress(userId);
        return list;
    }


    /**
     * 删除一条收货地址
     * @param addressId
     * @return
     */
    @RequestMapping("/deleteAddress")
    public String deleteAddress(String addressId){
        addressService.deleteAddress(addressId);
        return "删除成功";
    }

    @RequestMapping("/updateAddress")
    public String updateAddress(String addressId,String name,String phone,String prov,String city,String area,String street,String info,String userId){
        Address address = new Address();
        address.setAddressId(addressId);
        address.setAddressName(name);
        address.setAddressPhone(phone);
        address.setAddressProv(prov);
        address.setAddressCity(city);
        address.setAddressArea(area);
        address.setAddressStreet(street);
        address.setAddressInfo(info);
        address.setUserId(userId);
        addressService.updateAddress(address);
        return "修改成功";
    }

}
