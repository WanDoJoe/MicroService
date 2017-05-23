package com.seventythree.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.seventythree.model.UserModel;

@Component
public interface UserDao {
		public UserModel selectByNameAdnPwd(String userName,String password);
		
//		public UserModel selectById(int id);
		
		public List<UserModel> selectListUser(int start,int count);
		public boolean updateUserModel(UserModel u);
		public boolean insertUserModel(UserModel u);
//		public void deleteUserModel(UserModel u);
}
