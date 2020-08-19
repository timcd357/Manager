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
    public Message insertExcel(MultipartFile excel, String date, String userid) {
        List<Storage> storages = ExcelUtils.readExcelObject(excel, Storage.class);
//        System.out.println(storages);
        int n = 0;
        for (Storage s : storages
        ) {
            Map map = new HashMap<String, String>();
//            map.put("name",s.getName());
            if(date.equals("2020-08-12")){
                map.put("batch", s.getBatch().substring(0,s.getBatch().indexOf("-")-5));
            }else {
                map.put("batch", s.getBatch());
            }
            QueryWrapper<Storage> wrapper = new QueryWrapper<>();
            //入库查询
            List s1 = mapper.selectByMap(map);
            map.put("num", s.getNum());
            wrapper.allEq(map);
            wrapper.orderByDesc("real_time");
            wrapper.last("limit 1");
            Storage s2 = mapper.selectOne(wrapper);
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            s.setUserId(userid);
            try {
                s.setRealTime(sf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (s2 != null) {
                if (s.getRealTime().getTime() > s2.getRealTime().getTime()) {
                    s.setId(s2.getId());
                    mapper.updateById(s);
                    n++;
                }
                continue;
            }
            Storage preTime = mapper.getPreTime(sf.format(s.getRealTime()));
            mapper.insert(s);
            if(s1.size()==0&&preTime!=null){
                s.setNum(-s.getNum());
                s.setRealTime(preTime.getRealTime());
                s.setId(null);
                mapper.insert(s);
            }
        }
        //确定在没有两天的数据完全相同的情况下才执行下面的逻辑,否则会空出一天的数据量，导致前一天的数据出错
        if(n!=storages.size()){
            List<Storage> retrieval = mapper.retrieval();
            for (Storage s : retrieval
            ) {
                mapper.updateById(s);
            }
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
        Date parse = null;
        String divide = "2020-08-12 00:00:00";
        try {
            parse = sf.parse(divide);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        wrapper.lt("real_time", parse);
        List<Storage> storages = mapper.selectList(wrapper);
        for (Storage s : storages
        ) {
            QueryWrapper<Storage> w = new QueryWrapper<>();
            w.like("Batch", s.getBatch());
            w.gt("real_time", parse);
            Storage storage = mapper.selectOne(w);
            if (storage == null) {
                continue;
            }
            s.setBatch(storage.getBatch());
            mapper.updateById(s);
        }
    }

    @Override
    public Message findRetrieval() {
        List<Storage> list = mapper.findRetrieval();
        return Message.success(list);
    }

}
