package com.qys.filetransfer.service;

import org.springframework.stereotype.Service;

import java.io.File;



public interface DownloadService {

     File getSourceFile(String uuid);

}
