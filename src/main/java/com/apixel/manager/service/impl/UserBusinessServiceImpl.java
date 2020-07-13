package com.apixel.manager.service.impl;

import com.apixel.manager.exception.GlobalException;
import com.apixel.manager.pojo.UserBusiness;
import com.apixel.manager.dao.UserBusinessMapper;
import com.apixel.manager.service.IUserBusinessService;
import com.apixel.manager.utils.CodeMsg;
import com.apixel.manager.utils.Message;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户业务表 服务实现类
 * </p>
 *
 * @author shixianyu
 * @since 2020-07-09
 */
@Service
public class UserBusinessServiceImpl extends ServiceImpl<UserBusinessMapper, UserBusiness> implements IUserBusinessService {
    @Resource
    UserBusinessMapper userBusinessMapper;

    @Override
    public Message insertRecord(List<UserBusiness> records) {
        if(records.isEmpty()){
            throw new GlobalException(CodeMsg.DATA_EMPTY_ERROR);
        }
        for (UserBusiness u:records
             ) {
            userBusinessMapper.insert(u);
        }
        return Message.success();
    }

    @Override
    public Message insertRecord(UserBusiness userBusiness) {
        if(userBusiness==null){
            throw new GlobalException(CodeMsg.DATA_EMPTY_ERROR);
        }
        userBusinessMapper.insert(userBusiness);
        return Message.success();
    }
}
