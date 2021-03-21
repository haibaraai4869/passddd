package com.qys.filetransfer;


import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileInputStream;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * 通过MockMvc测试上传，下载，获取信息的访问
 */
@Log4j2
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTest {

    @Autowired
    MockMvc mockMvc;

    /**
     * 测试上传文件（小文件）
     * @throws Exception
     */
    @Test
    void TestUploadFile() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders.fileUpload("/uploadController/uploadFile")
                    .file(new MockMultipartFile("uploadfile", "asdsa.java", "application/ms-excel",
                    new FileInputStream(new File("C:\\Users\\haibaraai4869\\Desktop\\asdsa.java")))));
            log.info("测试上传完成...");
        } catch (Exception e) {
           log.info("测试上传失败...");
        }
    }

    /**
     * 测试上传文件（大文件）
     * @throws Exception
     */
    @Test
    void TestUploadBigFile() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders.fileUpload("/uploadController/uploadFile")
                    .file(new MockMultipartFile("uploadfile", "1000道互联网Java工程师面试题.pdf", "application/ms-excel",
                            new FileInputStream(new File("C:\\Users\\haibaraai4869\\Desktop\\1000道互联网Java工程师面试题.pdf")))));
            log.info("测试上传完成...");
        } catch (Exception e) {
            log.info("测试上传失败...");
        }
    }

    /**
     * 测试下载文件
     * @throws Exception
     */
    @Test
    void TestDownloadFile() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/downloadController/downloadFile?uuid=dad3c92f-b0e0-4731-a44a-ec95bca400ff"))
                    .andDo(print());
            log.info("测试下载完成...");
        } catch (Exception e) {
            log.info("测试下载失败...");
        }
    }


    /**
     * 测试获取文件信息
     * @throws Exception
     */
    @Test
    void TestGetFileInformation() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/fileInformationController/getFileInformation?uuid=dad3c92f-b0e0-4731-a44a-ec95bca400ff"));
            log.info("测试获取完成...");
        } catch (Exception e) {
            log.info("测试获取失败...");
        }
    }
    //测试结果： {"uid":"dad3c92f-b0e0-4731-a44a-ec95bca400ff","filesize":4542183,"filename":"1000éäºèç½Javaå·¥ç¨å¸é¢è¯é¢.pdf","createtime":"2021-03-21T03:44:53.000+00:00","filedir":"C:\\Users\\haibaraai4869\\Desktop\\ç¬è®°\\filetransfer\\src\\main\\java\\com\\qys\\filetransfer\\dir\\20210321","filetype":".pdf"}
}
