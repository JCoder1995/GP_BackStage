package com.zzu.jcoder.controller;


import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.zzu.jcoder.bean.UserBean;
import com.zzu.jcoder.model.File;

import java.util.Date;
import java.util.List;

public class FileController extends Controller {

    public void getIndexFileList(){
        String userId =  getPara("uid");
        List<File> files = File.dao.find("SELECT * FROM file WHERE parent = "+0+" AND uid = "+userId);
        Gson gson = new Gson();
        renderJson(gson.toJson(files));
    }

    public void addFolder(){
        String userId =  getPara("uid");
        String parentPath = getPara("fid");
        String folderName = getPara("name");
        //判断文件夹是否存在
       if (folderDetection(folderName,parentPath,userId)){
           System.out.println("文件夹不存在");
           new File().set("uid",userId).set("parent",parentPath).set("name",folderName).set("s_ctime",new Date()).save();
            if (folderDetection(folderName,parentPath,userId)==false){
                List<File> files = File.dao.find("SELECT * FROM file WHERE parent = "+parentPath+" AND uid = "+userId);
                Gson gson = new Gson();
                renderJson(gson.toJson(files));
            }
            else {
                renderJson();
            }
        }

    }

    public void addTxt(){

    }

    public void addPhoto(){

    }
    public void addFiles(){

    }
    //判断文件是否存在
    public Boolean folderDetection(String name,String parent,String uid){
        System.out.println(name);
        File file  = File.dao.findFirst("SELECT * FROM file WHERE uid = "+uid+"  AND  name = '"+name+"' AND parent = "+parent);
        if (file==null){
            return true;
        }
        else return  false;
    }
    //生成JSON 文件
    public String ProductJSON(int code,String status) {
        Gson gson = new Gson();
        UserBean userBean = new UserBean(code, status);
        return gson.toJson(userBean);
    }
    }
