package com.qys.filetransfer.controller;


import com.qys.filetransfer.service.DownloadService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 用于接收表单提交信息，注意：ajax无法接收处理文件流，必须使用表单提交
 */
@Controller
@RequestMapping("/downloadController")
public class DownloadController {
    private static final Logger logger =  LoggerFactory.getLogger(UploadController.class.getName());

    @Autowired
    DownloadService downloadService;

    /**
     * 接收uuid去获取文件，并把文件流通过response响应回前台实现下载
     * @param uuid
     * @param response
     * @return
     */
    @RequestMapping("/downloadFile")
    public String downLoad(String uuid, HttpServletResponse response) {
        logger.info("接收到下载文件uuid{}",uuid);
        File sourceFile = downloadService.getSourceFile(uuid);/**根据uuid去获取文件，获取不到返回指定error页面*/
        if(sourceFile==null){
            return "error";
        }
        response.setContentType("application/octet-stream;charset=utf-8");/**设置响应字符集*/
        response.addHeader("Content-Disposition","attachment;filename=" + uuid);/**设置响应头*/

        /**解析文件*/
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            logger.info("开始响应文件流...");
            os = response.getOutputStream();
            fis = new FileInputStream(sourceFile);
            bis = new BufferedInputStream(fis);
            int i = bis.read(buffer);
            while(i != -1){
                os.write(buffer);
                i = bis.read(buffer);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.info("文件转换错误");
        }
        logger.info("----------file download succeed---",uuid);
        try {
            bis.close();
            fis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.info("流关闭异常");
        }

        return null;
    }
}