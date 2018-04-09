package com.zzu.jcoder.bean;

/**
 * Created by JCoder on 2018/4/9.
 */

public class UserBean {
        public int code;
        public String msg;

        public UserBean(int i, String success) {
                this.code=i;
                this.msg = success;
        }

        public int getCode() {
                return code;
        }

        public void setCode(int code) {
                this.code = code;
        }

        public String getMsg() {
                return msg;
        }

        public void setMsg(String msg) {
                this.msg = msg;
        }
}
