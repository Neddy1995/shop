package com.xc.shop.service;

import com.xc.shop.bean.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTest {

    @Autowired
    public AddressService addressService;

    @Autowired
    private Environment environment;

    @Test
    public void addAddress () {
        String name = "谢超";
        String phone = "18064979828";
        String prov = "四川省";
        String city = "成都市";
        String area = "龙泉驿区";
        String street = "十陵上街1号";
        String info = "成都大学16栋492";
        String userId = "12";
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
    }

    @Test
    public void selectOneAddress() {
        Address address = addressService.selectOneAddress("26021483625054210");
        address.toString();
        String accessKeyId = environment.getProperty("images.path");
        System.out.printf(""+accessKeyId);
    }

    @Test
    public void selectAllAddress() {
        List<Address> list = addressService.selectAllAddress("12");
        System.out.printf(""+list);
    }

    @Test
    public void deleteAddress() {
        addressService.deleteAddress("26021483625054209");
    }

    @Test
    public void updateAddress(){
        Address address = new Address();
        address.setAddressId("26021483625054210");
        address.setAddressName("谢超");
        address.setAddressPhone("18064979828");
        address.setAddressProv("四川省");
        address.setAddressCity("成都市");
        address.setAddressArea("龙泉驿区");
        address.setAddressStreet("十陵上街1号");
        address.setAddressInfo("成都大学16栋493");
        address.setUserId("12");
        addressService.updateAddress(address);
    }
}