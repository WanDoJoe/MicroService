package com.seventythree.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seventythree.model.UserModel;
import com.seventythree.service.imp.UserService;

public class UserController {

//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public ModelAndView Login(@Value(value = "") UserModel user){
//		UserService service=new UserService();
//		service.insert(user);
//        ModelAndView mav=new ModelAndView();
////        mav.setViewName("index");
//        mav.getModel().put("", "");
//        mav.addObject("user",user);
//        return mav;
//	}
//	
//	
//	@RequestMapping("/index")  
//    public String getIndex(){     
//        return "index";  
//    }
}
