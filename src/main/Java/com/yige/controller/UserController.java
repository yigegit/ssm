package com.yige.controller;


import com.yige.pojo.User;
import com.yige.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "dev/login";
    }

    @RequestMapping("login")
    public String login(User user, Model model,HttpSession session){
        user = userService.login(user);
        System.out.println(user);

        if (user!=null){
            //登陆成功
            session.setAttribute("User",user);
            return "dev/index";
        }
        else{
            model.addAttribute("errMsg","登陆失败");
            return "dev/login";
        }

    }


}
