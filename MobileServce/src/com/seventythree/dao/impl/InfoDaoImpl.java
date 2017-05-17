package com.seventythree.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seventythree.dao.InfoDao;
import com.seventythree.mapper.InfoMapper;
import com.seventythree.model.InfoModel;
/*
 * 在类名或者接口名上添加@Component 注释
 * 在应用的mapper接口参数上添加  @Autowired
*/

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
		if(null==info){
			return false;
		}
		try {
			System.out.println(info.toString());
			infoMapper.insertInfoModel(info);
			return true;
		} catch (Exception e) {
			System.out.println("line=44 ----InfoDaoImpl insertInfoModel "+e.toString());
			return false;
		}finally {
			
		}
		
	}
	
	public boolean updateInfoModel(InfoModel info){
		infoMapper.updateInfoModel(info);
		
		return false;
	}
}
