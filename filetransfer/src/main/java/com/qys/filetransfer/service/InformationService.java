package com.qys.filetransfer.service;

import com.qys.filetransfer.domain.FileInformation;

public interface InformationService {

    FileInformation getFileInformation(String uuid);

}
