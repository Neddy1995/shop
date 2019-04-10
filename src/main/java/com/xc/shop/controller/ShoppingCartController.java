package com.xc.shop.controller;

import com.xc.shop.bean.ShoppingCart;
import com.xc.shop.bean.User;
import com.xc.shop.vo.ShoppingCartPo;
import com.xc.shop.service.ShoppingCartService;
import com.xc.shop.util.ControllerResult;
import com.xc.shop.util.SessionKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService  shoppingCartService;

    /**
     * 添加购物车
     * @param session
     * @param number
     * @param goodId
     * @return
     */
    @PostMapping(value = "/addCart.do")
    public ControllerResult addCartGoodByUser(HttpSession session,
                                              @RequestParam String number,
                                              @RequestParam String goodId){
        User user = (User) session.getAttribute("user");

//        添加操作
        shoppingCartService.addCartGoodByUser(user.getUserId(),number,goodId);

        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("添加成功！");
        return controllerResult;
    }

    /**
     * 查询用户添加到购物车的所有商品
     * @param session
     * @return
     */
    @GetMapping(value = "/selectAllCart.do")
    public ControllerResult selectAllCart(HttpSession session){

        User user = (User) session.getAttribute(SessionKeyValue.USER_KEY);

        ControllerResult controllerResult = new ControllerResult();
//        查询购物车
        List<ShoppingCartPo> list = shoppingCartService.selectAllCart(user.getUserId());

        if (list != null){
            controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            controllerResult.setMessage("查询成功");
            controllerResult.setData(list);
            return controllerResult;
        }
        else{
            controllerResult.setResultCode(ControllerResult.RESULT_CODE_FAIL);
            controllerResult.setMessage("购物车为空");
            return controllerResult;
        }
    }

    /**
     * 批量删除购物车中的商品
     * @param session
     * @param list
     * @return
     */
    @PostMapping(value = "/deleteCart.do")
    public ControllerResult DeleteCart(HttpSession session,
                             @RequestParam List list){

        ControllerResult controllerResult = new ControllerResult();
//        批量删除购物车的商品
        shoppingCartService.deleteCart(list);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("删除成功");
        return controllerResult;
    }

    @PostMapping(value="/updateCart.do")
    public ControllerResult UpdateCart(HttpSession httpSession,
                                       @RequestParam String cartId,
                                       @RequestParam String number){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartId(cartId);
        shoppingCart.setNumber(number);
//        修改数据
        shoppingCartService.updateByPrimaryKeySelective(shoppingCart);

        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("修改成功");
        return controllerResult;
    }


}
