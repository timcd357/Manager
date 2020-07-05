package com.apixel.manager.config.interceptor;

import com.apixel.manager.pojo.User;
import com.apixel.manager.utils.CookieUtils;
import com.apixel.manager.utils.TokenUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apixel.manager.utils.CosTant;

public class LoginHandleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String paramToken = request.getParameter(CosTant.COOKIE_NAME_TOKEN);
        String cookieToken = CookieUtils.getCookieValue(request, CosTant.COOKIE_NAME_TOKEN);
        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            // return null;
            request.getRequestDispatcher("/login").forward(request,response);
//            throw new GlobalException(CodeMsg.USER_NOT_LOGIN);
        }
        String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;
        User user = TokenUtils.getByToken(response, token);
        if(user!=null){
            return true;
        }
        return false;
    }
}
