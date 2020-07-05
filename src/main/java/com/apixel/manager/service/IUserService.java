package com.apixel.manager.service;

import com.apixel.manager.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shixianyu
 * @since 2020-06-18
 */
public interface IUserService extends IService<User> {
    void insertUser(User user);
    List<User> selectUser();
    String login(HttpServletResponse response,String userName,String password);
}
