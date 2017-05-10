package com.seventythree.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seventythree.dao.UserDao;
import com.seventythree.mapper.UserMapper;
import com.seventythree.model.UserModel;

@Component
public class UserDaoImpl{}
//UserDaoImpl implements UserDao{
//	@Autowired
//	private UserMapper userMapper; 
//
//	@Override
//	public UserModel selectByNameAdnPwd(String userName, String password) {
//		UserModel u=userMapper.selectByNameAdnPwd(userName, password);
//		return u;
//	}
//
//	@Override
//	public UserModel selectById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void updateUserModel(UserModel u) {
//		userMapper.updateUserModel(u);
//	}
//
//	@Override
//	public void insertUserModel(UserModel u) {
//		userMapper.insertUserModel(u);
//	}
//
//	@Override
//	public void deleteUserModel(UserModel u) {
//		userMapper.deleteUserModel(u);
//	}
//	
//}
