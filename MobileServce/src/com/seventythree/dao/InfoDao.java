package com.seventythree.dao;

import org.springframework.stereotype.Component;

import com.seventythree.model.InfoModel;

/**
 * @author sinosoft_wan
 *	在类名或者接口名上添加@Component 注释
 */
@Component
public interface InfoDao {
		
	public InfoModel selectById(String id);
	public boolean insertInfoModel(InfoModel info);
}
