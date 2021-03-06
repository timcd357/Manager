package com.apixel.manager.config.resolver;

import com.apixel.manager.exception.GlobalException;
import com.apixel.manager.pojo.User;
import com.apixel.manager.service.IUserService;
import com.apixel.manager.utils.CodeMsg;
import com.apixel.manager.utils.CosTant;
import com.apixel.manager.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        return clazz == User.class;
    }
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        String paramToken = request.getParameter(CosTant.COOKIE_NAME_TOKEN);
        String cookieToken = getCookieValue(request, CosTant.COOKIE_NAME_TOKEN);
        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            // return null;
            throw new GlobalException(CodeMsg.USER_NOT_LOGIN);
        }
        String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;
        return TokenUtils.getByToken(response, token);
    }
    private String getCookieValue(HttpServletRequest request, String cookiName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length <= 0) {
            // return null;
            throw new GlobalException(CodeMsg.TOKEN_INVALID);
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookiName)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
