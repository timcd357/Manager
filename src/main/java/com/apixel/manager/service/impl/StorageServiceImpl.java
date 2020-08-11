package com.apixel.manager.service.impl;

import com.apixel.manager.pojo.Storage;
import com.apixel.manager.dao.StorageMapper;
import com.apixel.manager.service.IStorageService;
import com.apixel.manager.utils.ExcelUtils;
import com.apixel.manager.utils.Message;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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
            List l = mapper.selectByMap(map);
            if(l.size()>0){
                Storage s2 = (Storage) l.get(0);
                if(s2.getBatch().equals(s.getBatch())&& s2.getNum().equals(s.getNum())){
                    continue;
                }
            }
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                s.setRealTime(sf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            s.setUserId(userid);
            mapper.insert(s);
        }
        return Message.success();
    }
}
