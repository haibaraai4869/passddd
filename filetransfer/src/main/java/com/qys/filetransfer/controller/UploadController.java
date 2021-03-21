package com.qys.filetransfer.controller;

import com.qys.filetransfer.service.impl.UploadServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用于接收前端ajax传回的文件，用MultipartFile接收
 */
@Controller
@RequestMapping("/uploadController")
public class UploadController {
    private static final Logger logger =  LoggerFactory.getLogger(UploadController.class.getName());
    @Autowired
    UploadServiceImpl uploadService;

    /**
     * 上传文件方法
     * @param uploadfile
     * @return
     */
    @RequestMapping("/uploadFile")
    public @ResponseBody Object uploadFile(MultipartFile uploadfile){
        logger.info("开始上传文件...");
        String uuid = uploadService.uploadFileData(uploadfile);
        logger.info("返回uuid{}...",uuid);
        return uuid;
    }



}
