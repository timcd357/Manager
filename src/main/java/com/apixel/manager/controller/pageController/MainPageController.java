package com.apixel.manager.controller.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {
    @RequestMapping("/")
    public String root(){
        return "redirect:/index";
    }
    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }
    @RequestMapping("/main")
    public String userMain(){
        return "/user/main";
    }
    @RequestMapping("/login")
    public String userLogin(){
        return "/user/login";
    }
    @RequestMapping("/regist")
    public String userRegist(){
        return "/user/regist";
    }
    @RequestMapping("/userLog")
    public String userLog(){
        return "/user/userLog";
    }
}
