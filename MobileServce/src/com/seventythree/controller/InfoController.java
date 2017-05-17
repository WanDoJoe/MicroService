package com.seventythree.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.seventythree.model.InfoModel;
import com.seventythree.service.InfoService;
import com.seventythree.service.imp.InfoServiceImpl;

//控制器的写法
// class 上添加注释 @Controller
//Service 上 对引用的Dao或者Service 添加 注释@Autowired 可以添加多个


@Controller
public class InfoController extends BaseController{
	@Autowired
	InfoService infoService;
	@Autowired
	InfoServiceImpl infoImpl;
	
	@RequestMapping(value="/updateinfo")
	public void updateinfo(HttpServletResponse response
			,HttpServletRequest request){
		InfoModel info=new InfoModel();
		info.setImages("aaaaaaaaaaaasetImagesaaaaaaaaaaaaaaaaaa");
		info.setName("admin");
		infoImpl.updateInfoModel(info);
		
		
	}
	
	
	@RequestMapping(value="/addinfo")
	public void insertinfo(HttpServletResponse response
			,HttpServletRequest request) throws Exception{
		
		StringBuffer imgJsons=new StringBuffer();
		for (int i = 0; i < 10; i++) {
			imgJsons.append("static/superman/img/logo/bd_logo1_31bdc765.png");
			imgJsons.append("@and@");
		}
		
		InfoModel infoDBinsert=new InfoModel();
		infoDBinsert.setName("admin");
		infoDBinsert.setAuthor("author");
		infoDBinsert.setContent("this is content @$#$!,__--~~faslfk'sdjnasflk");
		infoDBinsert.setDate("0000-00-00 00:00:00.000000");
		infoDBinsert.setImages(imgJsons.toString());
		infoDBinsert.setTitle("12432543sasd");
		infoService.insertInfoModel(infoDBinsert);
		
	}

	@RequestMapping(value="/findinfo")
	public void findInfo(String id,HttpServletResponse response
			,HttpServletRequest request) throws Exception{
		Gson gson=new Gson();
		String gsonOb="";
		/**
		 * 获取前台传入数据
		 */
//		String pass = request.getParameter("pass");
//		String idstr = request.getParameter("ids");
//		System.out.println(pass);
//		System.out.println(idstr);
		/**
		 * 查询数据库
		 */
		JSONObject infoDBJson=new JSONObject();
		try{
		
		InfoModel infoDB= infoService.selectById("1");
//		System.out.println(infoDB.getId()+"=="+infoDB.getName());
		
		gsonOb=gson.toJson(infoDB);
		System.out.println("gsonOb="+gsonOb);
//		if(null==infoDB){
//		}
//		infoDBJson.put("id", infoDB.getId());
//		infoDBJson.put("name", infoDB.getName());
//		infoDBJson.put("title", infoDB.getTitle());
//		infoDBJson.put("author", infoDB.getAuthor());
//		infoDBJson.put("content",infoDB.getContent());
//		infoDBJson.put("date",infoDB.getDate());
//		JSONArray array=new JSONArray();
//		String imags=infoDB.getImages();
//		for(int i=0;i<imags.split("@and@").length;i++){
//			array.put(imags.split("@and@")[i]);
//		}
//		infoDBJson.put("imgs", array);
//		
		}catch(Exception e){
			infoDBJson.put("message", e.toString());
		}

//		outStr(response, infoDBJson.toString());
		outStr(response, gsonOb);
		
		/**
		 * 往前台发送数据的两种方式
		 */
		/**
		 * 利用response 发送
		 */
		JSONObject ob=new JSONObject();
		ob.put("name", "jsonName");
		ob.put("id", "1");
//		outStr(response,ob.toString());
		
		
		/**
		 * 使用springmvc 的ModelAndView   方法需要return   ModelAndView
		 */
		ModelAndView modelAndView=new ModelAndView();

//		List list=new ArrayList<String>();
//		list.add("aaaa");
//		list.add("bbbb");
//		list.add("cccc");
//		
//		List listOb=new ArrayList<Object>();
//		
//		InfoModel model=new InfoModel();
//		model.setName("modelName");
//		
//		listOb.add(model);
//		listOb.add(model);
//		
//		Map<String,Map<String,Object>> map=new HashMap<String, Map<String,Object>>();
//		Map<String,Object> mapData=new HashMap<String,Object>();
//		mapData.put("name", "jsonName");
//		mapData.put("id", "12");
//		mapData.put("list", list);
//		mapData.put("model", model);
//		mapData.put("listOb", listOb);
//		
//		map.put("datastr", mapData);
////		modelAndView.addObject("data",ob.toString());
//		modelAndView.addAllObjects(map);
//		modelAndView.addObject(infoDB);
//		return modelAndView;
		
	}
	
//	protected void outStr(HttpServletResponse response,String str)
//    {  
//        try  
//        {  
//            response.setCharacterEncoding("UTF-8");  
//            response.getWriter().write(str);  
//        }  
//        catch (Exception e)  
//        {  
//        }  
//    }  

}
