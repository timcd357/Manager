package com.apixel.manager.controller.dataController;


import com.apixel.manager.service.IStorageService;
import com.apixel.manager.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.File;
import java.util.Date;

/**
 * <p>
 * 仓库状态 前端控制器
 * </p>
 *
 * @author shixianyu
 * @since 2020-08-11
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    IStorageService storageService;

    @PostMapping("/upExcel")
    public Message getExcel(MultipartFile excel, String date,String userid){
        return storageService.insertExcel(excel,date,userid);
    }

    @GetMapping("/findLastRecord")
    public Message findLastRecord(){
        return storageService.findLastRecord();
    }

    @RequestMapping("/changeBatch")
    public void changeBatch(){
        storageService.changeBatch();
    }

    @RequestMapping("/findRetrieval")
    public Message findRetrieval(String date){
        return storageService.findRetrieval(date);
    }
}

