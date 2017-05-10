package com.seventythree.dao;

import java.util.List;

import com.seventythree.model.UserModel;

public interface UserDao {
		public UserModel selectByNameAdnPwd(String userName,String password);
		
		public UserModel selectById(int id);
		
		
		public void updateUserModel(UserModel u);
		public void insertUserModel(UserModel u);
		public void deleteUserModel(UserModel u);
}
