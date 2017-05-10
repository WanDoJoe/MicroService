package com.seventythree.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seventythree.model.InfoModel;
import com.seventythree.service.InfoService;
import com.seventythree.service.imp.InfoServiceImpl;

@Controller
public class InfoController extends BaseController{
	@Autowired
	InfoServiceImpl infoService;
	
	
	

	@RequestMapping(value="/findinfo")
	public void findInfo(String id,HttpServletResponse response
			,HttpServletRequest request) throws Exception{
		
		/**
		 * 获取前台传入数据
		 */
		String pass = request.getParameter("pass");
		String idstr = request.getParameter("ids");
		System.out.println(pass);
		System.out.println(idstr);
		/**
		 * 查询数据库
		 */
		InfoModel infoDB= infoService.selectById("1");
		System.out.println(infoDB.getId()+"=="+infoDB.getName());
		
		InfoModel infoDBinsert=new InfoModel();
		infoDBinsert.setName("namesssss");
		infoService.insertInfoModel(infoDBinsert);
		
		/**
		 * 往前台发送数据的两种方式
		 */
		/**
		 * 利用response 发送
		 */
		JSONObject ob=new JSONObject();
		ob.put("name", "jsonName");
		ob.put("id", "1");
		outStr(response,ob.toString());
		
		
		/**
		 * 使用springmvc 的ModelAndView   方法需要return   ModelAndView
		 */
		ModelAndView modelAndView=new ModelAndView();

		List list=new ArrayList<String>();
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		
		List listOb=new ArrayList<Object>();
		
		InfoModel model=new InfoModel();
		model.setId(1);
		model.setName("modelName");
		
		listOb.add(model);
		listOb.add(model);
		
		Map<String,Map<String,Object>> map=new HashMap<String, Map<String,Object>>();
		Map<String,Object> mapData=new HashMap<String,Object>();
		mapData.put("name", "jsonName");
		mapData.put("id", "12");
		mapData.put("list", list);
		mapData.put("model", model);
		mapData.put("listOb", listOb);
		
		map.put("datastr", mapData);
//		modelAndView.addObject("data",ob.toString());
		modelAndView.addAllObjects(map);
//		return modelAndView;
		
	}
	
	protected void outStr(HttpServletResponse response,String str)
    {  
        try  
        {  
            response.setCharacterEncoding("UTF-8");  
            response.getWriter().write(str);  
        }  
        catch (Exception e)  
        {  
        }  
    }  

}
