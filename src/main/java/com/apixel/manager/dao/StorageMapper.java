package com.apixel.manager.dao;

import com.apixel.manager.pojo.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 仓库状态 Mapper 接口
 * </p>
 *
 * @author shixianyu
 * @since 2020-08-11
 */
public interface StorageMapper extends BaseMapper<Storage> {
    List<Storage> findLastRecord();
    List<Storage> findRetrieval(String date);
}
