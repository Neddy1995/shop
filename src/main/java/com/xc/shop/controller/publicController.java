package com.xc.shop.controller;

import com.xc.shop.bean.User;
import com.xc.shop.util.ControllerResult;
import com.xc.shop.util.SessionKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 获取后台部分数据
 */

@RestController
public class publicController {

    @Autowired
    private ControllerResult controllerResult;
    /**
     * 获取session
     * @param session
     */
    @GetMapping("/getSession")
    public ControllerResult getSession(HttpSession session){

//        获取session中的值
        User user = (User) session.getAttribute(SessionKeyValue.USER_KEY);
        if (user != null){
            controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            controllerResult.setMessage("已登录");
            controllerResult.setData(user);
            return controllerResult;
        }
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_FAIL);
        controllerResult.setMessage("未登录");
        return controllerResult;
    }

    /**
     * 关闭session
     * @param request
     * @param response
     */

    @GetMapping("/closeSession")
    public void closeSession(HttpServletRequest request,
                             HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute(SessionKeyValue.USER_KEY,null);
    }
}
