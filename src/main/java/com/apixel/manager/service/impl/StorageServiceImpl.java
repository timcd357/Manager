package com.apixel.manager.service.impl;

import com.apixel.manager.pojo.Storage;
import com.apixel.manager.dao.StorageMapper;
import com.apixel.manager.service.IStorageService;
import com.apixel.manager.utils.ExcelUtils;
import com.apixel.manager.utils.Message;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.management.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 仓库状态 服务实现类
 * </p>
 *
 * @author shixianyu
 * @since 2020-08-11
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements IStorageService {

    @Resource
    private StorageMapper mapper;

    @Override
    public Message insertExcel(MultipartFile excel,String date,String userid) {
        List<Storage> storages = ExcelUtils.readExcelObject(excel, Storage.class);
//        System.out.println(storages);
        for (Storage s:storages
             ) {
            Map map = new HashMap<String,String>();
//            map.put("name",s.getName());
            map.put("num",s.getNum());
            map.put("batch",s.getBatch());
            QueryWrapper<Storage> wrapper = new QueryWrapper<Storage>();
            wrapper.allEq(map);
            wrapper.orderByDesc("real_time");
            Storage s2 = mapper.selectOne(wrapper);
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                s.setRealTime(sf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(s2!=null){
                if(s2.getBatch().equals(s.getBatch())&& s2.getNum().equals(s.getNum())){
                    if(s.getRealTime().getTime()>s2.getRealTime().getTime()){
                        s.setId(s2.getId());
                        mapper.updateById(s);
                    }
                    continue;
                }
            }
            s.setUserId(userid);
            mapper.insert(s);
        }
        return Message.success();
    }

    @Override
    public Message findLastRecord() {
        return Message.success(mapper.findLastRecord());
    }

    @Override
    public void changeBatch() {
        QueryWrapper<Storage> wrapper = new QueryWrapper<>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse=null;
        String divide="2020-08-12 00:00:00";
        try {
            parse = sf.parse(divide);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        wrapper.lt("real_time",parse);
        List<Storage> storages = mapper.selectList(wrapper);
        for (Storage s:storages
             ) {
            QueryWrapper<Storage> w = new QueryWrapper<>();
            w.like("Batch",s.getBatch());
            w.gt("real_time",parse);
            Storage storage = mapper.selectOne(w);
            if(storage==null){
                continue;
            }
            s.setBatch(storage.getBatch());
            mapper.updateById(s);
        }
    }

    @Override
    public Message findRetrieval(String date) {
        List<Storage> list = mapper.findRetrieval(date);
        return Message.success(list);
    }

}
