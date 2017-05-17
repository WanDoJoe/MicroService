package com.seventythree.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seventythree.dao.UserDao;
import com.seventythree.model.UserModel;


@Service
public class UserService  {
	@Autowired
	UserDao dao;
	
	public boolean insert(UserModel u) {
		System.out.println(u.toString());
		return 	dao.insertUserModel(u);
	}
	public boolean update(UserModel u) {
		return dao.updateUserModel(u);
	}
	

	public UserModel selectT(String usernme,String password) {
		return dao.selectByNameAdnPwd(usernme, password);
	}

	public List<UserModel> selectTs(List<String> l) {
		
		return null;
	}

}
