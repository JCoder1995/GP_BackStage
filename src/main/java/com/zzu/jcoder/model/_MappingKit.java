package com.zzu.jcoder.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;


public class _MappingKit {
	
	public static void mapping(ActiveRecordPlugin arp) {
			arp.addMapping("blog", "uid", User.class);
	}
}

