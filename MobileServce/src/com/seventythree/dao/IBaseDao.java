package com.seventythree.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao<T> {
	
	public List<T> findById(int id);
	public List<T> findByCoum(Map<String, String> map);
	
	
	public void insterT(T t);
	public void deleteT(T t);
	public void updataT(T t);
	 
	
}
