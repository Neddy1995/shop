package com.xc.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图跳转的controller
 */


@Controller
public class PageJumpController {

    /**
     * 跳转到登陆页面
     * @return
     */
    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }

    /**
     * 跳转到系统首页
     * @return
     */
    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }
}
