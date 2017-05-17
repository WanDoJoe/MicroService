package com.seventythree.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

@Controller
public class BaseController {
	private static Map<String ,JSONObject> returnJsonParamsObjectMap;
	private static Gson gson=null;
	
	public static Gson returnGson(){
//		synchronized (BaseController.class) {
			if(gson==null){
				gson=new Gson();
			}
//		}
		return gson;
		
	}
	
	/**
	 * 返回数据给前台，仅字符串。
	 * @param response
	 * @param str
	 */
	protected void outStr(HttpServletResponse response, String str) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(str);
		} catch (Exception e) {
		}
	}
	
	public static JSONObject getRequestParams(HttpServletRequest request,String params){
		return requestJsonUtil(request.getParameter(params));
	}
	
	public static Map<String,JSONObject> getRequestParamsReturnMap(HttpServletRequest request,String params){
		requestJsonUtil(request.getParameter(params));
		return returnJsonParamsObject();
	}
	/**
	 * 处理返回参数json
	 */
	public static JSONObject requestJsonUtil(String params) {
		try{
		JSONObject paramsJson=new JSONObject(params);
		JSONObject dataJson=paramsJson.getJSONObject("params");
		JSONObject sysinfo=paramsJson.getJSONObject("sysinfo");
		returnJsonParamsObjectMap=new HashMap<String, JSONObject>();
		returnJsonParamsObjectMap.put("dataparams", dataJson);
		returnJsonParamsObjectMap.put("systparams", sysinfo);
			return dataJson;
		}catch(JSONException ejson){
			System.out.println(ejson.getLocalizedMessage());
		}
		
		return null;
	}
	/**
	 * 返回参数中的json对象 以map形式
	 * key分别是dataparams和systparams
	 * @param mapJsonOb
	 * @return
	 */
	public static Map<String,JSONObject> returnJsonParamsObject(){
		return returnJsonParamsObjectMap;
	}
	
	
	
//	@Autowired
//	protected HttpServletRequest request= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

//	protected HttpServletResponse response;

//	protected HttpSession session;
////	private HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();   
//
//	public HttpServletRequest getRequest() {
//		return request;
//	}
//
//	public void setRequest(HttpServletRequest request) {
//		this.request = request;
//	}
//
//	public HttpServletResponse getResponse() {
//		return response;
//	}
//
//	public void setResponse(HttpServletResponse response) {
//		this.response = response;
//	}
//
//	public HttpSession getSession() {
//		return session;
//	}
//
//	public void setSession(HttpSession session) {
//		this.session = session;
//	}
	
	
}
