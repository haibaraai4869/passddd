package com.qys.filetransfer.service.impl;

import com.qys.filetransfer.controller.UploadController;
import com.qys.filetransfer.service.DownloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
public class DownloadServiceImpl implements DownloadService {
    private static final Logger logger =  LoggerFactory.getLogger(UploadController.class.getName());

    /**
     * 根据uuid去遍历文件目录找到文件，没找到则返回null
     * @param uuid
     * @return
     */
    @Override
    public File getSourceFile(String uuid) {
        /**获取文件目录位置，为了方便测试直接写死，也可通过getAbsolutePath()拼接*/
        String dirSourcePath="\\C:\\Users\\haibaraai4869\\Desktop\\笔记\\filetransfer\\src\\main\\java\\com\\qys\\filetransfer\\dir";
        String sourcePath=null;
        File file = new File(dirSourcePath);
        File[] dirs = file.listFiles();
        for (File f : dirs) {/**遍历文件夹（第一层目录）*/
            boolean flag = false;
            File[] sourceFiles = f.listFiles();
            for (File sourceFile : sourceFiles) {/**遍历文件（第二层）*/
                if(sourceFile.getName().equals(uuid)){/**判断文件的name与uuid，找到则跳出循环*/
                    sourcePath = sourceFile.getAbsolutePath();
                    flag=true;
                    System.out.println("sourcePath:"+sourcePath);
                    break;
                }
            }
            if(flag)break;
            logger.info("不存在该文件{}",uuid);
            return null;
        }
        return new File(sourcePath);
    }
}
