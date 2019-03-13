package com.xc.shop.controller;

import com.xc.shop.bean.User;
import com.xc.shop.dao.UserMapper;
import com.xc.shop.service.UserService;
import com.xc.shop.util.ControllerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /**
     * 测试
     * @return
     */
    @RequestMapping("/user")
    public String userTest(){
        User user = userMapper.selectByPrimaryKey("12");
        return "" + user.toString();
    }

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String userLogin(String name,String password){
        User user = userService.login(name,password);
        if (user !=null){
            user.toString();
            return "index";
        }
        return "login";
    }

    /**
     * 注册
     * @param
     * @return
     */
    @PostMapping(value = "/register.do")
    public ControllerResult userRegister(HttpServletRequest request,
                               HttpServletResponse response,
                               @RequestParam("userName") String userName,
                               @RequestParam("password") String password,
                               @RequestParam("sex") int sex,
                               @RequestParam("age") int age,
                               @RequestParam("profession") String profession){

        User user = new User(userName,password,sex,age,profession);

        ControllerResult controllerResult = new ControllerResult();
        try {
            boolean i = userService.register(user);
            if (i) {
                controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
                controllerResult.setMessage("注册成功！");
                return controllerResult;
            }
            else{
                controllerResult.setResultCode(ControllerResult.RESULT_CODE_FAIL);
                controllerResult.setMessage("已存在该用户！");
                return controllerResult;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return controllerResult;
    }

    /**
     * 查询用户信息
     * @param id
     * @return 用户信息
     */
    @RequestMapping("/userInfo")
    public String userInfo(String id){
        User user = userService.selectUserByKey(id);
        return "" + user.toString();
    }
}