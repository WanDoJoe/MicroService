package com.seventythree.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.seventythree.dao.InfoDao;
import com.seventythree.dao.impl.InfoDaoImpl;
import com.seventythree.model.InfoModel;
import com.seventythree.service.InfoService;


/*在类名或者接口上添加@Service注释
 * 引用的dao层 参数上添加@Autowired 可添加多个
*/
@Service
public class InfoServiceImpl implements InfoService{
	@Autowired
//	@Qualifier
	private InfoDao infoDao;
	@Autowired
	private InfoDaoImpl infoimp;
	@Override
	public InfoModel selectById(String id) {
		return infoDao.selectById(id);
	}

	@Override
	public boolean  insertInfoModel(InfoModel info) {
		return infoDao.insertInfoModel(info);
	}
	
	public boolean updateInfoModel(InfoModel info){
		return infoimp.updateInfoModel(info);
	}
}
