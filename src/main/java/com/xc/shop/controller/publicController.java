package com.xc.shop.controller;

import com.xc.shop.bean.User;
import com.xc.shop.util.SessionKeyValue;
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

    /**
     * 获取session
     * @param request
     * @param response
     */
    @GetMapping("/getSession")
    public User getSession(HttpServletRequest request,
                           HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionKeyValue.USER_KEY);
        if (user != null){
            return user;
        }
        return null;
    }

    @GetMapping("/closeSession")
    public void closeSession(HttpServletRequest request,
                             HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute(SessionKeyValue.USER_KEY,null);
    }
}
