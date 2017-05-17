package com.seventythree.mapper;

import com.seventythree.model.InfoModel;

public interface InfoMapper {
	public InfoModel selectById(int id);
	public void  insertInfoModel(InfoModel info);
	public void updateInfoModel(InfoModel info);

}
