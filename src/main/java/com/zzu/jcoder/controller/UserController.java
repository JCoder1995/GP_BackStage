package com.zzu.jcoder.controller;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.zzu.jcoder.bean.UserBean;
import com.zzu.jcoder.model.User;

import java.util.Date;
import java.util.List;

public class UserController extends Controller {

    public void  index(){
        renderJson("success");
    }

    //用户登陆
    public void login(){
        String userName = getPara("username");
        String passWord = getPara("password");
    }
    //用户注册
    public void register(){
        String userName = getPara("username");
        String passWord = getPara("password");
        String nickName = getPara("nickName");
        String phone=getPara("phone");
        System.out.println("新用户注册"+new Date()+userName);
        boolean status = Userexist(userName);

        if (status){
            new User().set("email",userName).set("psw",passWord).set("ctime",new Date()).set("nickName",nickName).set("phone",phone).save();
            Gson gson = new Gson();
            UserBean userBean = new UserBean(0,"success");
            String jsonObject = gson.toJson(userBean);
            renderJson(jsonObject);
        }
        else {
            Gson gson = new Gson();
            UserBean userBean = new UserBean(1,"error");
            String jsonObject = gson.toJson(userBean);
            renderJson(jsonObject);
        }

    }
    //用户修改密码
    public void updateUser(){
        renderJson("success");
    }

    //判断用户是否存在
    public boolean Userexist(String usernName){
        List<User> user = User.dao.find("select * from `user` WHERE email='"+usernName+"'");
        if (user==null){
            return  true;
        }
        else {
            return false;
        }
    }
}
