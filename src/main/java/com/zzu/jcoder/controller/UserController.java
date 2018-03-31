package com.zzu.jcoder.controller;

import com.jfinal.core.Controller;
import com.zzu.jcoder.model.User;

import java.util.Date;

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
        new User().set("email",userName).set("psw",passWord).set("ctime",new Date()).set("nickName",nickName).set("phone",phone).save();
        renderJson("success");
    }
    //用户修改密码
    public void updateUser(){
        renderJson("success");
    }

}
