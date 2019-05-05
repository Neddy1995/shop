package com.xc.shop.controller;

import com.xc.shop.bean.Address;
import com.xc.shop.bean.User;
import com.xc.shop.service.AddressService;
import com.xc.shop.util.ControllerResult;
import com.xc.shop.util.SessionKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private ControllerResult controllerResult;


    /**
     * 添加收货地址
     * @param name
     * @param phone
     * @param prov
     * @param city
     * @param area
     * @param street
     * @param info
     * @return
     */
    @PostMapping(value = "/addAddress.do")
    public ControllerResult addaddress(HttpSession session,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone,
                             @RequestParam("prov") String prov,
                             @RequestParam("city") String city,
                             @RequestParam("area") String area,
                             @RequestParam("street") String street,
                             @RequestParam("info") String info){
        User user =(User) session.getAttribute(SessionKeyValue.USER_KEY);

        Address address = new Address();
        address.setAddressName(name);
        address.setAddressPhone(phone);
        address.setAddressProv(prov);
        address.setAddressCity(city);
        address.setAddressArea(area);
        address.setAddressStreet(street);
        address.setAddressInfo(info);
        address.setUserId(user.getUserId());

//        添加地址
        addressService.addAddress(address);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("添加成功！");
        return controllerResult;
    }

    /**
     * 查询一条记录
     * @return
     */
    @GetMapping(value = "/selectOneAddress.do")
    public ControllerResult selectAddress(HttpSession session){
        User user =(User) session.getAttribute(SessionKeyValue.USER_KEY);
//        查询一条记录
        Address address = addressService.selectOneAddress(user.getUserId());
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("查询成功！");
        controllerResult.setData(address);
        return controllerResult;
    }

    /**
     * 查询所有收货地址
     * @return
     */
    @GetMapping(value="/selectAllAddress.do")
    public ControllerResult selectAllAddress(HttpSession session){
        User user = (User) session.getAttribute(SessionKeyValue.USER_KEY);

//        查询所有
        List<Address> list = addressService.selectAllAddress(user.getUserId());
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("查询成功！");
        controllerResult.setData(list);
        return controllerResult;
    }


    /**
     * 删除一条收货地址
     * @param addressId
     * @return
     */
    @PostMapping(value = "/deleteAddress.do")
    public ControllerResult deleteAddress(HttpSession session,
                                @RequestParam("addressId") String addressId){
        addressService.deleteAddress(addressId);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("删除成功！");
        return controllerResult;
    }

    @PostMapping(value = "/updateAddress.do")
    public ControllerResult updateAddress(HttpSession session,
                                @RequestParam("addressId") String addressId,
                                @RequestParam("name") String name,
                                @RequestParam("phone") String phone,
                                @RequestParam("prov") String prov,
                                @RequestParam("city") String city,
                                @RequestParam("area") String area,
                                @RequestParam("street") String street,
                                @RequestParam("info") String info){
        User user =(User) session.getAttribute(SessionKeyValue.USER_KEY);
        Address address = new Address();
        address.setAddressId(addressId);
        address.setAddressName(name);
        address.setAddressPhone(phone);
        address.setAddressProv(prov);
        address.setAddressCity(city);
        address.setAddressArea(area);
        address.setAddressStreet(street);
        address.setAddressInfo(info);
        address.setUserId(user.getUserId());

//        修改信息
        addressService.updateAddress(address);

        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("修改成功！");
        return controllerResult;
    }
}
