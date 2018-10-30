package com.microapps.ebusiness.mystore.application.dao;

import java.util.List;
import java.util.Map;

import com.microapps.ebusiness.mystore.application.dao.exception.RecordNotFoundException;

public interface BaseDao<T> {
	
	T saveOrUpdate(T t);
	
	T find(Class<T> claaz, long id)throws RecordNotFoundException;
	
	List<T> findAll(Class<T> claaz, String query, Map<String, Object> params);
	
	T find(String query, Class<T> claaz, Map<String, Object> params)throws RecordNotFoundException;
	
}
