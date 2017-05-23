package com.seventythree.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Controller
public class BaseController {
	private static Map<String ,JSONObject> returnJsonParamsObjectMap;
	private static Gson gson=null;
	private static String Content_type_html="text/html;charset=UTF-8";
	private static String Content_type_json="text/json;charset=UTF-8";
	
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
	protected void outStr(HttpServletResponse response, String str,String message,String resule) {
		try {
			response.setHeader("Content-type", Content_type_json);
			response.setCharacterEncoding("UTF-8");
			JSONObject data=new JSONObject();
			data.put("data", str);
			data.put("message",message);
			data.put("resule", resule);
			response.getWriter().write(data.toString());
		} catch (Exception e) {
		}
	}
	protected void outStr(HttpServletResponse response, JSONObject str,String message,String resule) {
		try {
//			Type type = new TypeToken<TestGeneric<String>>(){}.getType();
			response.setHeader("Content-type",Content_type_json);
			response.setCharacterEncoding("UTF-8");
			JSONObject data=new JSONObject();
			System.out.println(str.toString());
			data.put("data",str);// returnGson().toJson(str, Object.class));
			data.put("message",message);
			data.put("resule", resule);
			response.getWriter().write(data.toString());
		} catch (Exception e) {
		}
	}
	protected void outStr(HttpServletResponse response, String str) {
		try {
			response.setCharacterEncoding("UTF-8");
			JSONObject data=new JSONObject();
			data.put("data", str);
			response.getWriter().write(str);
		} catch (Exception e) {
		}
	}
	
	/**
	 * 获取前台传过来的参数
	 * @param request
	 * @param params
	 * @return JSONObject
	 */
	public static JSONObject getRequestParams(HttpServletRequest request,String params){
		return requestJsonUtil(request.getParameter(params));
	}
	/**
	 *  获取前台传过来的参数
	 * @param request
	 * @param params
	 * @return Map<String,JSONObject> 
	 */
	public static Map<String,JSONObject> getRequestParamsReturnMap(HttpServletRequest request,String params){
		requestJsonUtil(request.getParameter(params));
		return returnJsonParamsObject();
	}
	/**
	 * 解析前台参数并处理以json形式返回参数的value
	 */
	public static JSONObject requestJsonUtil(String params) {
		try{
			System.out.println("requestJsonUtil params"+params);
		JSONObject paramsJson=new JSONObject(params);
		JSONObject dataJson=paramsJson.getJSONObject("params");
		JSONObject sysinfo=paramsJson.getJSONObject("sysinfo");
		System.out.println("dataJson params"+dataJson.toString());
		System.out.println("sysinfo "+sysinfo.toString());
		
		
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
