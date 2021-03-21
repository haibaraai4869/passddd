package com.qys.filetransfer.domain;

import java.util.Date;

public class FileInformation {
    private String uid;

    private Long filesize;

    private String filename;

    private Date createtime;

    private String filedir;

    private String filetype;

    public FileInformation(String uid, Long filesize, String filename, Date createtime, String filedir, String filetype) {
        this.uid = uid;
        this.filesize = filesize;
        this.filename = filename;
        this.createtime = createtime;
        this.filedir = filedir;
        this.filetype = filetype;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFiledir() {
        return filedir;
    }

    public void setFiledir(String filedir) {
        this.filedir = filedir == null ? null : filedir.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }
}