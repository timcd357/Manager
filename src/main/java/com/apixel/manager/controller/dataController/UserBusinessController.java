package com.apixel.manager.controller.dataController;


import com.apixel.manager.pojo.UserBusiness;
import com.apixel.manager.service.IUserBusinessService;
import com.apixel.manager.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户业务表 前端控制器
 * </p>
 *
 * @author shixianyu
 * @since 2020-07-09
 */
@RestController
@RequestMapping("/user-business")
public class UserBusinessController {

    @Autowired
    IUserBusinessService userBusinessService;

    /**
     * 插入复数的用户记录数据
     * @param records
     * @return
     */
    @PutMapping("/insertList")
    public Message insertdata(List<UserBusiness> records) {
        return userBusinessService.insertRecord(records);
    }
    @PutMapping("/insert")
    public Message insertdata(UserBusiness record) {
        return userBusinessService.insertRecord(record);
    }
    @GetMapping("/getRecord")
    public Message getAllRecord(){
        return userBusinessService.getRecord();
    }
    @DeleteMapping("/deleteRecord")
    public Message deleteRecord(@RequestParam("ids") List<String> ids){
        return userBusinessService.deleteRecord(ids);
    }
}

