package com.zzu.jcoder.controller;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.zzu.jcoder.bean.UserBean;

public class IndexController extends Controller {

    public void index(){
        Gson gson = new Gson();
        UserBean userBean = new UserBean(0,"success");
        String jsonObject = gson.toJson(userBean);
        renderJson(jsonObject);
    }
}
