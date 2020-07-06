package com.apixel.manager.utils;

public class CosTant {
    /**
     * 登录token前缀
     */
    public static final String COOKIE_NAME_TOKEN = "login_token";
    /**
     * token过期时间，2天
     */
    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;

    public static CodeMsg SUCCESS = new CodeMsg(200, "成功");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg REQUEST_ILLEGAL = new CodeMsg(500102, "请求非法");
    public static CodeMsg ACCESS_LIMIT_REACHED = new CodeMsg(500103, "访问太频繁！");
    //登录模块 5002XX
    public static CodeMsg USER_NOT_LOGIN = new CodeMsg(500200, "用户未登录");
    public static CodeMsg TOKEN_INVALID = new CodeMsg(500201, "token无效");
    public static CodeMsg USERNAME_NOT_EXIST = new CodeMsg(500202, "用户名不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500203, "密码错误");
}
