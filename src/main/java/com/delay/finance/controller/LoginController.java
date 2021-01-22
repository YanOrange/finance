package com.delay.finance.controller;

import com.delay.finance.entity.User;
import com.delay.finance.service.UserService;
import com.delay.finance.utils.ExecuteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("login")
public class LoginController extends BaseController{

    @Autowired
    UserService userService;

    //登录后台
    @RequestMapping("doLogin")
    @ResponseBody
    public ExecuteResult login(@RequestParam("userName") String userName, @RequestParam("passWord")String passWord){

        User user = userService.findByAccountAndPassWord(userName,passWord);
        if(user==null){
            return ExecuteResult.fail(1,"用户名不存在或密码错误");
        }
        getSession().setAttribute("user",user);
        return ExecuteResult.ok();
    }

}
