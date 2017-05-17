package com.seventythree.mapper;

import java.util.List;

import com.seventythree.model.UserModel;


public interface UserMapper {
	public UserModel selectByNameAndPwd(String u_name,String u_password);
//	public UserModel selectById(int id);
	public void updateUserModel(UserModel u);
	public void insertUserModel(UserModel u);
//	public void deleteUserModel(UserModel u);
}
