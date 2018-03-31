package com.zzu.jcoder.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;


public class _MappingKit {
	
	public static void mapping(ActiveRecordPlugin arp) {
			arp.addMapping("user", "uid", User.class);
			arp.addMapping("file", "fid", File.class);
		    arp.addMapping("test", "a", Test.class);
	}
}

