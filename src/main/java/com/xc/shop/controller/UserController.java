package com.xc.shop.controller;

import com.xc.shop.bean.User;
import com.xc.shop.dao.UserMapper;
import com.xc.shop.service.UserService;
import com.xc.shop.util.ControllerResult;
import com.xc.shop.util.SessionKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
     * 注册
     * @param
     * @return
     */
    @PostMapping(value = "/register.do")
    public ControllerResult userRegister(@RequestParam("userName") String userName,
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
     * @return 用户信息
     */
    @GetMapping(value = "/userInfo.do")
    public ControllerResult userInfo(HttpSession session){
        User user = (User)session.getAttribute(SessionKeyValue.USER_KEY);
        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("查询成功");
        controllerResult.setData(user);
        return controllerResult;

    }
}