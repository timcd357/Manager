package com.apixel.manager.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        LocalDateTime currentDate = LocalDateTime.now();
        //创建时间默认当前时间
        setFieldValByName("createTime", currentDate,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LocalDateTime currentDate = LocalDateTime.now();
        //修改时间
        setFieldValByName("modifyTime",currentDate,metaObject);
    }
}
