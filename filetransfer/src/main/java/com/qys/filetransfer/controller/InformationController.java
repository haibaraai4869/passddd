package com.qys.filetransfer.controller;


import com.qys.filetransfer.domain.FileInformation;
import com.qys.filetransfer.service.InformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用于接收表单提交信息，通过uuid去数据库中获取元数据信息
 */
@Controller
@RequestMapping("/fileInformationController")
public class InformationController {
    private static final Logger logger =  LoggerFactory.getLogger(UploadController.class.getName());

    @Autowired
    InformationService informationService;

    /**
     * 元数据信息获取方法
     * @param uuid
     * @return
     */
    @RequestMapping("/getFileInformation")
    @ResponseBody
    public Object getFileInformation(String uuid){
        logger.info("获取文件元数据，uuid{}",uuid);
        FileInformation fileInformation = informationService.getFileInformation(uuid);
        return fileInformation;
    }

}
