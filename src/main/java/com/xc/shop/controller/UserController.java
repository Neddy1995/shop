package com.xc.shop.controller;

import com.xc.shop.bean.User;
import com.xc.shop.dao.UserMapper;
import com.xc.shop.service.UserService;
import com.xc.shop.util.ControllerResult;
import com.xc.shop.util.SessionKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                               @RequestParam("sex") String sex,
                               @RequestParam("age") String age,
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
        User user = userService.selectUserByKey((String) session.getAttribute(SessionKeyValue.USER_ID));
        session.setAttribute(SessionKeyValue.USER_KEY,user);
        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("查询成功");
        controllerResult.setData(user);
        return controllerResult;

    }

    @PostMapping(value = "/userUpdate.do")
    public ControllerResult userUpdate(HttpSession session,
                                       @RequestParam("userName")String userName,
                                       @RequestParam("userSex")String userSex,
                                       @RequestParam("userAge")String userAge,
                                       @RequestParam("userPro")String userPro){
        ControllerResult controllerResult = new ControllerResult();
        User user = (User)session.getAttribute(SessionKeyValue.USER_KEY);
        user.setUserName(userName);
        user.setSex(userSex);
        user.setAge(userAge);
        user.setProfession(userPro);
        userService.update(user);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("修改成功！");
        return controllerResult;
    }
}