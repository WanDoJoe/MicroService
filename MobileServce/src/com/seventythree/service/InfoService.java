package com.seventythree.service;

import org.springframework.stereotype.Service;

import com.seventythree.model.InfoModel;

@Service
public interface InfoService {
	public InfoModel selectById(String id);
	public boolean  insertInfoModel(InfoModel info);
}
