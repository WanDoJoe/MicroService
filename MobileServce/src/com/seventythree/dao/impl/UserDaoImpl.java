package com.seventythree.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seventythree.dao.UserDao;
import com.seventythree.mapper.UserMapper;
import com.seventythree.model.UserModel;

@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserMapper userMapper; 

	@Override
	public UserModel selectByNameAdnPwd(String u_name, String u_password) {
		UserModel u=userMapper.selectByNameAndPwd(u_name, u_password);
		return u;
	}

//	@Override
//	public UserModel selectById(int id) {
//		return null;
//	}

	@Override
	public boolean updateUserModel(UserModel u) {
		System.out.println(u.toString());
		
//		if(null==u){
//			System.out.println("updateUserModel 对象 为空");
//			return false;
//		}
		
		try{
		userMapper.updateUserModel(u);
		return true;
		}catch(Exception e){
			System.out.println("----UserDaoImpl updateUserModel "+e.toString());
			return false;
		}
	}

	@Override
	public boolean insertUserModel(UserModel u) {
		if(null==u){
			System.out.println("插入对象 为空");
			return false;
		}
		System.out.println(u.toString());
		try{
			userMapper.insertUserModel(u);
			return true;
		}catch(Exception e){
			System.out.println("----UserDaoImpl insertUserModel "+e.toString());
			return false;
		}
			
		
	}

//	@Override
//	public void deleteUserModel(UserModel u) {
////		userMapper.deleteUserModel(u);
//	}
	
}
