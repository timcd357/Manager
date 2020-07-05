package com.apixel.manager.controller.dataController;


import com.apixel.manager.pojo.User;
import com.apixel.manager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shixianyu
 * @since 2020-06-18
 */
@RestController
@RequestMapping("/manager/user")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping("addUser")
    public String insertUser(@ModelAttribute User user){
        userService.insertUser(user);
        return "index";
    }

    @PostMapping("selectUser")
    @ResponseBody
    public List<User> selectUser(){
        return userService.selectUser();
    }

    @PostMapping("login")
    @ResponseBody
    public String userLogin(HttpServletResponse response,@RequestParam("userName") String userName,
                            @RequestParam("password") String password){
        return userService.login(response,userName,password);
    }
}

