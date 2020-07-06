package com.apixel.manager.utils;

import com.alibaba.fastjson.JSON;
import com.apixel.manager.exception.GlobalException;
import com.apixel.manager.pojo.User;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    /**
     * 为登录用户添加cookie
     * @param response
     * @param token
     * @param user
     */
    public static void addLoginCookie(HttpServletResponse response, String token, User user) {
        //将token存入到redis
        RedisUtils.set(CosTant.COOKIE_NAME_TOKEN + "::" + token, JSON.toJSONString(user), CosTant.TOKEN_EXPIRE);
        //将token写入cookie
        Cookie cookie = new Cookie(CosTant.COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(CosTant.TOKEN_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static String getCookieValue(HttpServletRequest request, String cookiName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length <= 0) {
             return null;
//            throw new GlobalException(CodeMsg.TOKEN_INVALID);
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookiName)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
