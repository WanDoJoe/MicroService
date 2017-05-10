package com.seventythree.dao;

import org.springframework.stereotype.Component;

import com.seventythree.model.InfoModel;

@Component
public interface InfoDao {
		
	public InfoModel selectById(String id);
	public boolean insertInfoModel(InfoModel info);
}
