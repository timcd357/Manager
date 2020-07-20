package com.apixel.manager.service.impl;

import com.apixel.manager.exception.GlobalException;
import com.apixel.manager.pojo.UserBusiness;
import com.apixel.manager.dao.UserBusinessMapper;
import com.apixel.manager.service.IUserBusinessService;
import com.apixel.manager.utils.CodeMsg;
import com.apixel.manager.utils.Message;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public Message getRecord() {
        List<UserBusiness> userBusinesses = userBusinessMapper.selectList(null);
        return Message.success(userBusinesses);
    }

    @Override
    public Message deleteRecord(List<String> ids) {
        for (String id:ids
             ) {
            userBusinessMapper.deleteById(id);
        }
        return Message.success();
    }

    @Override
    public Message getRecord(String itemname, String factory, String batch, String start, String end, String date) {
        QueryWrapper<UserBusiness> wrapper = new QueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(itemname),"itemname",itemname);
        wrapper.like(!StringUtils.isEmpty(factory),"factory",factory);
        wrapper.like(!StringUtils.isEmpty(batch),"batch",batch);
        wrapper.like(!StringUtils.isEmpty(start),"start",start);
        wrapper.like(!StringUtils.isEmpty(end),"end",end);
        wrapper.eq(!StringUtils.isEmpty(date),"date",date);
        List<UserBusiness> list = userBusinessMapper.selectList(wrapper);

        return Message.success(list);
    }
}
