package com.xc.shop.controller;

import com.xc.shop.service.OrderService;
import com.xc.shop.util.ControllerResult;
import com.xc.shop.util.SessionKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "selectAllOrder.do")
    public ControllerResult selectAllOrder(HttpSession httpSession){
        ControllerResult controllerResult =new ControllerResult();

        String userId =(String) httpSession.getAttribute(SessionKeyValue.USER_ID);
//        查询订单
        orderService.selectAllOrder(userId);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("查询成功！");

        return controllerResult;

    }
}
