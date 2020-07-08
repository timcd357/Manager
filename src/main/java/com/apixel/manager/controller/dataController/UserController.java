package com.apixel.manager.controller.dataController;


import com.apixel.manager.exception.GlobalException;
import com.apixel.manager.pojo.User;
import com.apixel.manager.service.IUserService;
import com.apixel.manager.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shixianyu
 * @since 2020-06-18
 */
@Controller
@RequestMapping("/manager/user")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping("addUser")
    public String insertUser(@ModelAttribute User user){
        userService.insertUser(user);
        return "/user/login";
    }
    @PostMapping("regist")
    @ResponseBody
    public Message regist(@ModelAttribute User user){
        if(user==null||StringUtils.isEmpty(user.getUserName())||StringUtils.isEmpty(user.getPassword())){
            throw new GlobalException(CodeMsg.USERMSG_ERROR);
//            return Message.error(CodeMsg.USERMSG_ERROR);
        }
        Map map = new HashMap();
        map.put("userName",user.getUserName());
        if(!userService.selectUserByMap(map).isEmpty()){
            throw new GlobalException(CodeMsg.USERNAME_DUPLICATE);
//            return Message.error(CodeMsg.USERNAME_DUPLICATE);
        }
        if(!StringUtils.isEmpty(user.getEmail())){
            map.clear();
            map.put("email",user.getEmail());
            if(!userService.selectUserByMap(map).isEmpty()){
                throw new GlobalException(CodeMsg.EMAIL_DUPLICATE);
//            return Message.error(CodeMsg.EMAIL_DUPLICATE);
            }
        }
        if(!StringUtils.isEmpty(user.getPhone())){
            map.clear();
            map.put("phone",user.getPhone());
            if(!userService.selectUserByMap(map).isEmpty()){
                throw new GlobalException(CodeMsg.PHONE_DUPLICATE);
//            return Message.error(CodeMsg.PHONE_DUPLICATE);
            }
        }
        user.setPassword(CommonUtils.md5Encrypt(user.getPassword()));
        userService.insertUser(user);
        return Message.success();
    }

    @PostMapping("selectUser")
    @ResponseBody
    public List<User> selectUser(){
        return userService.selectUser();
    }

    @PostMapping("login")
    @ResponseBody
    public Message userLogin(HttpServletResponse response, @RequestParam("userName") String userName,
                             @RequestParam("password") String password){
        return userService.login(response, userName, password);
    }

    @PostMapping("getUserByToken")
    @ResponseBody
    public String getUserByToken(String token){
        if(StringUtils.isEmpty(token)){
            return null;
        }
         return (String) RedisUtils.get(CosTant.COOKIE_NAME_TOKEN + "::" + token);
    }

    @PostMapping("checkUserName")
    @ResponseBody
    public Message checkUserName(String userName){
        Map map = new HashMap();
        map.put("userName",userName);
        List<User> users = userService.selectUserByMap(map);
        if(!users.isEmpty()){
            throw new GlobalException(CodeMsg.USERNAME_DUPLICATE);
        }
        return Message.success();
    }
}

