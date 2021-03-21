package com.qys.filetransfer.service.impl;

import com.qys.filetransfer.controller.UploadController;
import com.qys.filetransfer.domain.FileInformation;
import com.qys.filetransfer.mapper.FileInformationMapper;
import com.qys.filetransfer.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 上传文件业务层
 */
@Service
public class UploadServiceImpl implements UploadService {
    private static final Logger logger =  LoggerFactory.getLogger(UploadServiceImpl.class.getName());
    @Autowired
    FileInformationMapper fileInformationmapper;

   public String uploadFileData(MultipartFile uploadFile) {
       logger.info("获取上传文件...");
       String fileUUID = UUID.randomUUID().toString();/**给文件随机生成uuid*/
       logger.info("正在生成uuid{}",fileUUID);
       String dirName = saveFileData(uploadFile,fileUUID);/**保存元数据并返回路径方法*/

       createFile(uploadFile,dirName,fileUUID);/**创建文件方法*/

       return fileUUID;
    }

    /**
     * 解析传入文件的元数据，调用mapper接口方法存到数据库中
     * @param uploadFile
     * @param fileUUID
     * @return
     */
    public String saveFileData(MultipartFile uploadFile, String fileUUID){
        logger.info("保存文件信息...");
        String fileName = uploadFile.getOriginalFilename();/**获取文件原始名*/
        long size = uploadFile.getSize();/**获取文件大小*/
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");/**获取文件日期*/
        String dateStr=sdf.format(date);

        /**截取文件日期作为文件夹名*/
        String yyyy = dateStr.substring(0,4);
        String MM = dateStr.substring(5,7);
        String dd = dateStr.substring(8,10);
        File directory = new File("");//设定为当前文件夹
        /**为了测试方便直接写死绝对路径，也可以通过directory.getAbsolutePath()获取后拼接*/
        String dirName = "C:\\Users\\haibaraai4869\\Desktop\\笔记\\filetransfer\\src\\main\\java\\com\\qys\\filetransfer\\dir\\"+yyyy+MM+dd;
        FileInformation fileInformation = new FileInformation(fileUUID, size, fileName, date, dirName, "." + fileName.split("\\.")[1]);
        fileInformationmapper.insert(fileInformation);/**把元数据信息插入数据库*/

        return dirName;

    }

    public String createFile(MultipartFile uploadFile, String dirName, String fileUUID){
        File file = new File(dirName);
        if (!file.isDirectory()) {/**查看是否已有该文件夹*/
            try {
                file.mkdir();
            } catch (Exception e) {
               logger.info("创建文件夹出错");
            }
        }
        else{
           logger.info("文件目录已存在");
        }


        /**根据saveData方法回传的dir拼接绝对路径创建文件*/
        File dataFile = new File(dirName+"\\"+fileUUID);
        try {
            uploadFile.transferTo(dataFile);
            dataFile.createNewFile();
            logger.info("创建文件成功");
        } catch (Exception e) {
           logger.info("创建文件失败");
        }

        return "ok";
    }


}
