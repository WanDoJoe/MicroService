package com.seventythree.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seventythree.dao.InfoDao;
import com.seventythree.mapper.InfoMapper;
import com.seventythree.model.InfoModel;

@Component
public class InfoDaoImpl implements InfoDao{
	@Autowired
	private InfoMapper infoMapper; 
	
	@Override
	public InfoModel selectById(String id) {
		InfoModel model=infoMapper.selectById(Integer.valueOf(id));
		return model;
	}

	@Override
	public boolean insertInfoModel(InfoModel info) {
		infoMapper.insertInfoModel(info);
		return false;
	}

}
