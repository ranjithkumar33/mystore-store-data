package com.microapps.ebusiness.mystore.application.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class PersistanceUtil {
	
	private PersistanceUtil() {
		
	}
	
	private static PersistanceUtil instance;
	
	private EntityManagerFactory sessionFactory;
	
	public final void setPersistance(String persistanceUnit) {
		if(sessionFactory == null) sessionFactory= Persistence.createEntityManagerFactory(persistanceUnit);
	}
	
	public final EntityManagerFactory getPersistance() {
		return sessionFactory;
		
	}

	public static PersistanceUtil getInstance() {
		
		if(instance == null) instance = new PersistanceUtil();
		
		return instance;
	}


}
