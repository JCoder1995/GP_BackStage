package com.zzu.jcoder.bean;

/**
 * Created by JCoder on 2018/4/10.
 */

public class UserInfo {

    public String id;
    public String userName;
    public String nickName;
    public String phone;
    public String passWord;
    public UserInfo(String id, String userName, String nickName, String phone, String passWord) {
        this.id = id;
        this.userName = userName;
        this.nickName = nickName;
        this.phone = phone;
        this.passWord = passWord;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
