package com.apixel.manager.utils;

import com.alibaba.fastjson.JSON;
import com.apixel.manager.exception.GlobalException;
import com.apixel.manager.pojo.User;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

public class TokenUtils {
    public static User getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User user = JSON.parseObject((String)RedisUtils.get(CosTant.COOKIE_NAME_TOKEN + "::" + token),User.class);
        //重置有效期
        if (user == null) {
            throw new GlobalException(CodeMsg.USER_NOT_LOGIN);
        }
        CookieUtils.addLoginCookie(response, token, user);
        return user;
    }
}
