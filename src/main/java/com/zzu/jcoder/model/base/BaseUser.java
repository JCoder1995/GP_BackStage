package com.zzu.jcoder.model.base;


import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

public abstract class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean {
}
