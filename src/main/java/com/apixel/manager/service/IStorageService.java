package com.apixel.manager.service;

import com.apixel.manager.pojo.Storage;
import com.apixel.manager.utils.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * <p>
 * 仓库状态 服务类
 * </p>
 *
 * @author shixianyu
 * @since 2020-08-11
 */
public interface IStorageService extends IService<Storage> {
    Message insertExcel(MultipartFile excel,String date,String userid);
    Message findLastRecord();
    void changeBatch();
    Message findRetrieval();
}
