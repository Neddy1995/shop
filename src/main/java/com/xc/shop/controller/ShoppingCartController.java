package com.xc.shop.controller;

import com.xc.shop.bean.User;
import com.xc.shop.pojo.ShoppingCartPo;
import com.xc.shop.service.ShoppingCartService;
import com.xc.shop.util.ControllerResult;
import com.xc.shop.util.SessionKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService  shoppingCartService;


    /**
     * 添加购物车
     * @param request
     * @param response
     * @param number
     * @param goodId
     * @return
     */
    @RequestMapping("/addCart.do")
    public ControllerResult addCartGoodByUser(HttpServletRequest request,
                                              HttpServletResponse response,
                                              @RequestParam int number,
                                              @RequestParam int goodId){
        HttpSession session = request.getSession();
        ControllerResult controllerResult = new ControllerResult();
        User user = (User) session.getAttribute("user");

//        添加操作
        shoppingCartService.addCartGoodByUser(user.getUserId(),number,goodId);

        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("添加成功！");
        return controllerResult;
    }

    /**
     * 查询用户添加到购物车的所有商品
     * @param
     * @return
     */
    @GetMapping("/selectAllCart.do")
    public ControllerResult selectAllCart(HttpServletRequest request,
                                          HttpServletResponse response){

        HttpSession session = request.getSession();
        ControllerResult controllerResult = new ControllerResult();
        User user = (User) session.getAttribute(SessionKeyValue.USER_KEY);

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
     * @param list
     * @return
     */
    @RequestMapping("/deleteCart")
    public String DeleteCart(List list){
        shoppingCartService.deleteCart(list);
        return "删除成功";
    }



}
