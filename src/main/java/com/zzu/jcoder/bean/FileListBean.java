package com.zzu.jcoder.bean;

import java.util.Date;

public class FileListBean {
    public String name;
    public Date c_mtime;
    public int fid;
    public int uid;
    public int filetype;

    public FileListBean(String name,Date c_ctime, int fid, int uid, int filetype){
        this.name = name;
        this.c_mtime = c_ctime;
        this.fid = fid;
        this.uid = uid;
        this.filetype = filetype;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFiletype() {
        return filetype;
    }

    public void setFiletype(int filetype) {
        this.filetype = filetype;
    }
    public Date getC_mtime() {
        return c_mtime;
    }

    public void setC_mtime(Date c_mtime) {
        this.c_mtime = c_mtime;
    }
}
