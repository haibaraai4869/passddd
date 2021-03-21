package com.qys.filetransfer.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    public String uploadFileData(MultipartFile uploadFile);

    public String saveFileData(MultipartFile uploadFile, String fileUUID);

    public String createFile(MultipartFile uploadFile, String dirName, String fileUUID);
}
