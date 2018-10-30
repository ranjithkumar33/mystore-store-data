package com.microapps.ebusiness.mystore.application.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.microapps.ebusiness.mystore.application.dao.exception.RecordNotFoundException;

public class BaseDaoImpl<T> implements BaseDao<T>{
	

	protected EntityManagerFactory getSessionFactory() {
		return PersistanceUtil.getInstance().getPersistance();
	}
	
	@Override
	public T saveOrUpdate(T t) {
		EntityManager entityManager = getSessionFactory().createEntityManager();
		entityManager.getTransaction().begin();
	    t = entityManager.merge(t);
		entityManager.getTransaction().commit();
		entityManager.close();
		return t;
	}

	@Override
	public T find(Class<T> claaz, long id)throws RecordNotFoundException {
		EntityManager entityManager = getSessionFactory().createEntityManager();
		entityManager.getTransaction().begin();
	    T t = entityManager.find(claaz, id);
	    entityManager.getTransaction().commit();
	    entityManager.close();
		return t;
	}
	
	@Override
	public T find(String query, Class<T> claaz, Map<String, Object> params) throws RecordNotFoundException {
		EntityManager entityManager = getSessionFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Query q = entityManager.createQuery(query, claaz);
		if(params != null) {
			for(Map.Entry<String, Object> entry : params.entrySet()) {
				q.setParameter(entry.getKey(), entry.getValue());
			}
		}
		@SuppressWarnings("unchecked")
		List<T> result = q.getResultList();
		entityManager.getTransaction().commit();
	    entityManager.close();
	    if(result != null && !result.isEmpty()) {
	    	return result.get(0);
	    }else {
	    	 throw new RecordNotFoundException("No record found");	
	    }
		
	}
	
	@Override
	public List<T> findAll(Class<T> claaz, String query, Map<String, Object> params) {
		EntityManager entityManager = getSessionFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Query q = entityManager.createQuery(query, claaz);
		if(params != null) {
			for(Map.Entry<String, Object> entry : params.entrySet()) {
				q.setParameter(entry.getKey(), entry.getValue());
			}
		}
		@SuppressWarnings("unchecked")
		List<T> result = q.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}
	
}
