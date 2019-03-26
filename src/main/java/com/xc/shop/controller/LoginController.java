package com.xc.shop.controller;

import com.xc.shop.bean.User;
import com.xc.shop.service.UserService;
import com.xc.shop.util.ControllerResult;
import com.xc.shop.util.ImageUtil;
import com.xc.shop.util.SessionKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 生成图片验证码
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/code")
    public String getCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("image/jpeg");
        //禁止图像缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        HttpSession session = request.getSession();
        ImageUtil imageUtil = new ImageUtil(80, 30, 4,0);
        session.setAttribute("code", imageUtil.getCode());
        imageUtil.write(response.getOutputStream());
        return null;
    }

    @PostMapping(value = "/login.do")
    public ControllerResult login(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        @RequestParam("paramCode") String paramCode) {

        HttpSession session = request.getSession();
        ControllerResult controllerResult = new ControllerResult();
        try {
            // 校验验证码是否准确
            String sessionCode = session.getAttribute("code").toString();
            if (!sessionCode.equals(paramCode)) {
                controllerResult.setResultCode(ControllerResult.RESULT_CODE_FAIL);
                controllerResult.setMessage("登陆失败：验证码输入错误");
                return controllerResult;
            }

            // 校验用户名和密码是否准确
            User user = userService.login(userName,password);
            if (user == null) {
                controllerResult.setResultCode(ControllerResult.RESULT_CODE_FAIL);
                controllerResult.setMessage("登陆失败：用户名或者密码错误，请重新输入");
                return controllerResult;
            }

            // 登陆成功，将用户信息放到session里面
            session.setAttribute(SessionKeyValue.USER_KEY, user);
            session.setAttribute(SessionKeyValue.USER_ID, user.getUserId());

            controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            controllerResult.setMessage("登陆成功");
            return controllerResult;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return controllerResult;
    }

    public void main(String[] args) {
    }

}















