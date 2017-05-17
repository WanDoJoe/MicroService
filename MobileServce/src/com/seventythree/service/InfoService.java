package com.seventythree.service;

import org.springframework.stereotype.Service;

import com.seventythree.model.InfoModel;


/*
 *  在类名或者接口名上添加注释 @Service
*/
@Service
public interface InfoService {
	public InfoModel selectById(String id);
	public boolean  insertInfoModel(InfoModel info);
}
