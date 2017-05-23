package com.seventythree.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.seventythree.model.UserModel;
import com.seventythree.service.imp.UserService;


@Controller
public class UserController extends BaseController{
	@Autowired
	UserService userService;
	String message="";
	String resule="";

	@RequestMapping(value="/login")
	public void login(HttpServletResponse response
			,HttpServletRequest request) throws Exception{
		try {
			JSONObject objectJson=getRequestParams(request, "params");
			System.out.println(objectJson.toString());
			
			UserModel u=userService.selectT(objectJson.optString("username"), objectJson.optString("password"));
		if(u==null){
			message="用户名或密码错误！";
			resule="failed";
			outStr(response,"",message,resule);
			return;
		}
		message="登录成功";
		resule="success";
		String jsonU= returnGson().toJson(u);//使用Gson制作出bean的json
		System.out.println(jsonU);
//		outStr(response, object.toString());
		outStr(response,new JSONObject(jsonU),message,resule);
		
		} catch (Exception e) {
			message="登录异常";
			resule="failed";
			outStr(response,"",message,resule);
			e.printStackTrace();
		}
		
	}
	Thread myThread;
	Runnable myRunnable;
	int flag=0;
	@RequestMapping(value="/addUser")
	public void addUser(HttpServletResponse response
			,HttpServletRequest request)  throws Exception{
//		JSONObject data=getRequestParams(request, "jsondata");
//		data.get("");
//		long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
//		System.out.println("开始 "+startMili);
		
//		for (int i = 1; i <= 1; i++) {
			try {
//				flag=i;
//				myThread = new Thread(myRunnable);
//				myThread.start();
				UserModel user=new UserModel();
//				user.setId(1);
				user.setU_name("admin_12");
				user.setU_password("12345567");
				user.setAddress("aaaaaaaa");
				user.setBirthday("00000000");
				user.setDate("11111");
				user.setGender("");
				user.setIcon("");

				user.setPhone("123123123");
				user.setSelfintroduction("");
				if(userService.selectT(user.getU_name(), user.getU_password())!=null){
					message="用户已存在";
					resule="false";
					System.out.println("用户已存在");
//					try {
//						myThread.join();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}else
					if(userService.insert(user)){
					System.out.println("成功插入一条数据");
					message="注册成功";
					resule="success";
//					try {
//						myThread.join();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}else{
					message="注册失败";
					resule="false";
					System.out.println("插入失败插入失败");
//					try {
//						myThread.join();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}finally {
//				myThread.join();
			}
			
//		}
//				Thread.sleep(1000);
				
//				long endMili=System.currentTimeMillis();
//				System.out.println("结束 s"+endMili);
//				System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
				
		myRunnable=new Runnable() {
			
			@Override
			public void run() {
				UserModel user=new UserModel();
//				user.setId(1);
				user.setU_name("admin_12"+flag);
				user.setU_password("12345567");
				user.setAddress("aaaaaaaa");
				user.setBirthday("00000000");
				user.setDate("11111");
				user.setGender("");
				user.setIcon("");

				user.setPhone("123123123");
				user.setSelfintroduction("");
				if(userService.selectT(user.getU_name(), user.getU_password())!=null){
					message="用户已存在";
					resule="false";
					System.out.println("用户已存在");
//					try {
//						myThread.join();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}else
					if(userService.insert(user)){
					System.out.println("成功插入一条数据");
					message="注册成功";
					resule="success";
//					try {
//						myThread.join();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}else{
					message="注册失败";
					resule="false";
					System.out.println("插入失败插入失败");
//					try {
//						myThread.join();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			}
		};
		
	}
	@RequestMapping(value="/updateUser")
	public void update(HttpServletResponse response
			,HttpServletRequest request) throws Exception{
		UserModel user=new UserModel();
		user.setId(1);
		user.setAddress("dasdasfasasd");
		
		userService.update(user);
		
	}
	
	@RequestMapping(value="/finduserpage")
	public void finduserpage(HttpServletResponse response
			,HttpServletRequest request) throws Exception{
//		try {
			int start=Integer.valueOf(request.getParameter("start"));
			int count=Integer.valueOf(request.getParameter("count"));
			System.out.println(start+"=="+count);
			List<UserModel> listU=userService.selectPage(start, count);
//			String jsonU= returnGson().toJson(listU);
//			System.out.println(jsonU);
			JSONArray a = null;
			a=new JSONArray();
			for (int i = 0; i < listU.size(); i++) {
				
				String jsonU= returnGson().toJson(listU.get(i));
				JSONObject obList=new JSONObject(jsonU);
				a.put(obList);
			}
			
			JSONObject ob=new JSONObject();
			ob.put("list",a);
			
			message="成功";
			resule="success";
			outStr(response,ob,message,resule);
//		} catch (Exception e) {
//			System.out.println(e.getLocalizedMessage());
//			message="失败";
//			resule="fail";
//			outStr(response,"",message,resule);
//		}finally {
//			
//		}
		
		
//		for (int i = 0; i < listU.size(); i++) {
//			System.out.println(i+"-"+listU.get(i).getU_name());
//		}
		
	}
}
