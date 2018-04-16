package com.zzu.jcoder;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.json.FastJsonFactory;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.zzu.jcoder.controller.FileController;
import com.zzu.jcoder.controller.IndexController;
import com.zzu.jcoder.controller.UserController;
import com.zzu.jcoder.model._MappingKit;

public class MainConfig extends JFinalConfig {
    public void configConstant(Constants constants) {
        // 加载少量必要配置，随后可用PropKit.get(...)获取值
        PropKit.use("a_little_config.txt");
        constants.setDevMode(PropKit.getBoolean("devMode", false));
        constants.setJsonFactory(new FastJsonFactory());

    }

    public void configRoute(Routes routes) {
        routes.add("/",IndexController.class);
        routes.add("/user",UserController.class);
        routes.add("/file",FileController.class);
    }

    public void configEngine(Engine engine) {

    }
    public static DruidPlugin createDruidPlugin() {
        return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }

    public void configPlugin(Plugins plugins) {
        // 配置C3p0数据库连接池插件
        DruidPlugin druidPlugin = createDruidPlugin();
        plugins.add(druidPlugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        // 所有映射在 MappingKit 中自动化搞定
        _MappingKit.mapping(arp);
        plugins.add(arp);
        System.out.println("数据库加载完成");
    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }

    @Override
    public void afterJFinalStart() {

    }

    public static void main(String[] args){
        JFinal.start("src/main/webapp",8081,"/");
    }

}
