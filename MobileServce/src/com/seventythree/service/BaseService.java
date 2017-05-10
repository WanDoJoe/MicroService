package com.seventythree.service;

import java.util.List;

public interface BaseService<T> {
	public boolean insert(T t);
	public T selectT(List<String> l);
	public List<T> selectTs(List<String> l);
}
