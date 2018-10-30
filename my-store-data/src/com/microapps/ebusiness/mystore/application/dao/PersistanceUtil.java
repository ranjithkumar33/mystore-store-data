package com.microapps.ebusiness.mystore.application.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class PersistanceUtil {
	
	private PersistanceUtil() {
		
	}
	
	private static PersistanceUtil instance;
	
	private EntityManagerFactory sessionFactory;
	
	public final void setPersistance() {
		if(sessionFactory == null) sessionFactory=Persistence.createEntityManagerFactory("my-store-db");
	}
	
	public final EntityManagerFactory getPersistance() {
		return sessionFactory;
		
	}

	public static PersistanceUtil getInstance() {
		
		if(instance == null) instance = new PersistanceUtil();
		
		return instance;
	}


}
