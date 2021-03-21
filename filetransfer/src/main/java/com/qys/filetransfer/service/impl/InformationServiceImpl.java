package com.qys.filetransfer.service.impl;

import com.qys.filetransfer.controller.UploadController;
import com.qys.filetransfer.domain.FileInformation;
import com.qys.filetransfer.domain.FileInformationExample;
import com.qys.filetransfer.mapper.FileInformationMapper;
import com.qys.filetransfer.service.InformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文件元数据信息业务层
 */
@Service
public class InformationServiceImpl implements InformationService {
    private static final Logger logger =  LoggerFactory.getLogger(UploadController.class.getName());
    @Autowired
    FileInformationMapper mapper;

    /**
     * 获取元数据方法
     * @param uuid
     * @return
     */
    @Override
    public FileInformation getFileInformation(String uuid) {
        /**直接通过mybatis-generator插件生成的接口去查询数据并返回*/
        FileInformation fileInformation = mapper.selectByPrimaryKey(uuid);
        logger.info("得到文件元数据{}",fileInformation);
        return fileInformation;
    }
}
