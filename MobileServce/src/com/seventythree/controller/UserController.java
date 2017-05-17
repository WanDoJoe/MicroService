package com.seventythree.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.seventythree.model.UserModel;
import com.seventythree.service.imp.UserService;

@Controller
public class UserController extends BaseController{
	@Autowired
	UserService userService;
	

	@RequestMapping(value="/login")
	public void login(HttpServletResponse response
			,HttpServletRequest request) throws Exception{
		try {
			String pas=request.getParameter("pass");
			System.out.println(pas);
		} catch (Exception e) {
		}
		
		
		UserModel u=userService.selectT("admin", "admin");
		String jsonU= returnGson().toJson(u);//使用Gson制作出bean的json
		System.out.println(jsonU);
//		outStr(response, object.toString());
		outStr(response,jsonU);
	}
	@RequestMapping(value="/addUser")
	public void addUser(HttpServletResponse response
			,HttpServletRequest request)  throws Exception{
		JSONObject data=getRequestParams(request, "jsondata");
		data.get("");
		
		
		UserModel user=new UserModel();
//		user.setId(1);
		user.setU_name("admin_1");
		user.setU_password("admin");
		user.setAddress("aaaaaaaa");
		/*user.setBirthday("");
		user.setDate("");
		user.setGender("");
		user.setIcon("");
		user.setOhtername("");
		user.setPhone("");
		user.setSelfintroduction("");*/
		if(userService.insert(user)){
			System.out.println("成功插入一条数据");
		}else{
			System.out.println("插入失败插入失败");
		}
	}
	@RequestMapping(value="/updateUser")
	public void update(HttpServletResponse response
			,HttpServletRequest request) throws Exception{
		UserModel user=new UserModel();
		user.setId(1);
		user.setAddress("dasdasfasasd");
		
		userService.update(user);
		
	}
}
