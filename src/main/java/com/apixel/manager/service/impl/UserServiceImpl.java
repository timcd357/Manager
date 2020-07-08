package com.apixel.manager.service.impl;

import com.apixel.manager.exception.GlobalException;
import com.apixel.manager.pojo.User;
import com.apixel.manager.dao.UserMapper;
import com.apixel.manager.service.IUserService;
import com.apixel.manager.utils.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shixianyu
 * @since 2020-06-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    RedisUtils redisUtils;

    @Resource
    UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> selectUser() {
        return userMapper.selectList(null);
    }

    @Override
    public Message login(HttpServletResponse response, String userName, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("userName",userName);
        //判断用户名是否存在
        List<User> uList = userMapper.selectByMap(map);
        if (uList == null||uList.size()==0) {
            throw new GlobalException(CodeMsg.LOGIN_ERROR);
        }
        String dbPass = uList.get(0).getPassword();
        if (!CommonUtils.md5Encrypt(password).equals(dbPass)) {
            throw new GlobalException(CodeMsg.LOGIN_ERROR);
        }
        //生成cookie
        String token = UUID.randomUUID().toString().replace("-", "");
        CookieUtils.addLoginCookie(response, token, uList.get(0));
        return Message.success(token);
    }

    @Override
    public List<User> selectUserByMap(Map map) {
        return userMapper.selectByMap(map);
    }
}
