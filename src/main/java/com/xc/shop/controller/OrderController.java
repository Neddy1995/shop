package com.xc.shop.controller;

import com.xc.shop.service.OrderService;
import com.xc.shop.util.ControllerResult;
import com.xc.shop.util.SessionKeyValue;
import com.xc.shop.vo.GoodByCartVo;
import com.xc.shop.vo.OrderGoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询所有订单
     * @param httpSession
     * @return
     */
    @GetMapping(value = "selectAllOrder.do")
    public ControllerResult selectAllOrder(HttpSession httpSession){
        ControllerResult controllerResult =new ControllerResult();

        String userId =(String) httpSession.getAttribute(SessionKeyValue.USER_ID);
//        查询订单
        List<OrderGoodVo> list = orderService.selectAllOrder(userId);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("查询成功！");
        controllerResult.setData(list);
        return controllerResult;

    }

    /**
     * 查询购物车中的商品
     * @param httpSession
     * @param list
     * @return
     */
    @PostMapping(value = "selectGoodByCart.do")
    public ControllerResult selectGoodByCart(HttpSession httpSession,
                                             @RequestParam("list")List list){
        List<GoodByCartVo> list1 = orderService.selectGoodByCart(list);
        ControllerResult controllerResult = new ControllerResult();

        if (list1.size()>0) {
            controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            controllerResult.setMessage("查询成功！");
            controllerResult.setData(list1);
            return controllerResult;
        }else{
            controllerResult.setResultCode(ControllerResult.RESULT_CODE_FAIL);
            controllerResult.setMessage("没有数据");
            return controllerResult;
        }
    }

    /**
     * 创建订单
     * @param httpSession
     * @param addressId
     * @param list
     * @return
     */
    @PostMapping(value = "createOrder.do")
    public ControllerResult createOrder(HttpSession httpSession,
                                        @RequestParam("addressId")String addressId,
                                        @RequestParam("list")List<String> list){
        ControllerResult controllerResult = new ControllerResult();

        String userId = (String) httpSession.getAttribute(SessionKeyValue.USER_ID);
        orderService.insertOrder(userId,addressId,list);

        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("创建成功！");
        return controllerResult;
    }

    /**
     * 删除订单信息
     * @param httpSession
     * @param orderId
     * @return
     */
    @PostMapping(value = "deleteOrder.do")
    public ControllerResult deleteOrder(HttpSession httpSession,
                                        @RequestParam("orderId")String orderId){
        ControllerResult controllerResult = new ControllerResult();
        orderService.deleteOrder(orderId);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("删除成功");
        return controllerResult;
    }

}
