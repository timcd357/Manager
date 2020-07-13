package com.apixel.manager.service;

import com.apixel.manager.pojo.UserBusiness;
import com.apixel.manager.utils.Message;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户业务表 服务类
 * </p>
 *
 * @author shixianyu
 * @since 2020-07-09
 */
public interface IUserBusinessService extends IService<UserBusiness> {
    Message insertRecord(List<UserBusiness> records);
    Message insertRecord(UserBusiness userBusiness);

}
