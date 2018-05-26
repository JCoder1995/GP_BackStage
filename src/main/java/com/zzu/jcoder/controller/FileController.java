package com.zzu.jcoder.controller;

import com.google.gson.*;
import com.jfinal.core.Controller;
import com.jfinal.json.FastJson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.zzu.jcoder.bean.UserBean;
import com.zzu.jcoder.model.File;
import com.zzu.jcoder.plugin.FileType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class FileController extends Controller {

	public void getFileList() {
		String userId = getPara("uid");
		String parentPath = getPara("fid");
		List<File> files = File.dao.find("SELECT * FROM file WHERE parent = " + parentPath + " AND uid = " + userId);
		filesToJson(files);
	}

	public void getFileFolderList() {
		String userId = getPara("uid");
		String parentPath = getPara("fid");
		List<File> files = File.dao
				.find("SELECT * FROM file WHERE parent = " + parentPath + " AND uid = " + userId + " AND filetype = 0");
		filesToJson(files);
	}

	public void addFolder() {
		String userId = getPara("uid");
		String parentPath = getPara("fid");
		String folderName = getPara("name");
		// 判断文件夹是否存在
		if (folderDetection(folderName, parentPath, userId)) {
			System.out.println("文件夹不存在");
			new File().set("uid", userId).set("parent", parentPath).set("name", folderName).set("filetype", 0)
					.set("s_ctime", new Date()).save();
			if (folderDetection(folderName, parentPath, userId) == false) {
				List<File> files = File.dao
						.find("SELECT * FROM file WHERE parent = " + parentPath + " AND uid = " + userId);
				Gson gson = new Gson();
				renderJson(gson.toJson(files));
			} else {
				renderJson();
			}
		}

	}

	// 判断文件是否存在
	public Boolean folderDetection(String name, String parent, String uid) {
		System.out.println(name);
		File file = File.dao.findFirst(
				"SELECT * FROM file WHERE uid = " + uid + "  AND  name = '" + name + "' AND parent = " + parent);
		if (file == null) {
			return true;
		} else
			return false;
	}

	// 生成JSON 文件
	public String ProductJSON(int code, String status) {
		Gson gson = new Gson();
		UserBean userBean = new UserBean(code, status);
		return gson.toJson(userBean);
	}

	// 对文件进行JSON 转化 前端少写一点
	public void filesToJson(List<File> files) {
		Gson gson = new Gson();
		renderJson(gson.toJson(files));
	}

	public void fileUpload() {
		getFile();
		String uid = getPara("uid");
		String fid = getPara("fid");
		String file_name = getPara("filelistname");
		int filetype = new FileType().fileType(file_name);

		new File().set("name", file_name).set("filetype", filetype).set("uid", uid).set("s_ctime", new Date())
				.set("parent", fid).set("filepath", "http://115.159.209.140:8080/GP_BackStage/upload/" + file_name)
				.save();

		System.out.println(filetype);
	}

	private List<String> stringToList(String strs) {

		String str[] = strs.split(",");
		return Arrays.asList(str);
	}

	public void postFileChangeList() {

		int parent = Integer.parseInt(getPara("fid"));
		String json = getPara("file");
		String type = getPara("type");
		
		System.out.println(parent+"   "+json+"   "+type);
		
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonArray jsonArray = parser.parse(json).getAsJsonArray();
		
		System.out.println(jsonArray.size());
		
		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject jsonObject = (JsonObject) jsonArray.get(i);
			System.out.println(jsonObject.get("fid").toString().replace("\"", "").replace("\"", ""));
			int fid =Integer.parseInt(jsonObject.get("fid").toString().replace("\"", "").replace("\"", ""));
			if ("move".equals(type)) {
				System.out.println(fid+"1");
				Db.update("update file set parent = ? where fid = ?", parent,fid );
			//	file = Db.findById("file", String.valueOf(fid)).set("parent", String.valueOf(parent));
				System.out.println(fid+"2");
			//	Db.update("file", file);
				
			} else if("copy".equals(type)) {
				System.out.println(parent);
				File file = File.dao.findById(fid);
				new File().set("name", file.get("name")).set("parent",parent).set("filetype", file.get("filetype")).set("uid", file.get("uid")).set("s_ctime", new Date())
				.set("filepath", "http://115.159.209.140:8080/GP_BackStage/upload/" + file.get("name"))
				.save();
			}
			else {
				File.dao.deleteById(fid);
			}
		}
		renderJson("success");

	}

	public void searchFileList() {
		String uid = getPara("uid");
		String query = getPara("query");
		List<File> files = File.dao.find("SELECT * FROM file WHERE filetype != 0 AND `name`  LIKE '"+query+"%' AND uid = "+uid );
		System.out.println(files.size());
		filesToJson(files);
	}
	
	public void AddFolder() {
		String uid = getPara("uid");
		String fid = getPara("fid");
		String name = getPara("name");
		new File().set("name", name).set("parent",fid).set("filetype", 0).set("uid", uid).set("s_ctime", new Date())
		.save();
	}
}
