package com.seventythree.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.seventythree.dao.InfoDao;
import com.seventythree.dao.impl.InfoDaoImpl;
import com.seventythree.model.InfoModel;
import com.seventythree.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService{
	@Autowired
//	@Qualifier
	private InfoDao infoDao;
	@Override
	public InfoModel selectById(String id) {
		return infoDao.selectById(id);
	}

	@Override
	public boolean  insertInfoModel(InfoModel info) {
		return infoDao.insertInfoModel(info);
	}

}
