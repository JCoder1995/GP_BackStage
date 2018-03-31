package com.zzu.jcoder.model;

import com.jfinal.plugin.activerecord.Model;

public class Test extends Model<Test> {
    public  static final Test dao = new Test().dao();
}
