package com.microapps.ebusiness.mystore.application.dao;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class SystemDaoImpl {
	 private static final Logger LOGGER = Logger.getLogger(SystemDaoImpl.class.getName());
	
	protected EntityManagerFactory getSessionFactory() {
		return PersistanceUtil.getInstance().getPersistance();
	}
	
	static{
		 
		  backupDir = System.getProperty("user.home")+"\\my-store\\backup";
	}
	
	private static final String backupDir;
	
	public void backup() throws IOException {
		LOGGER.log(Level.INFO, "Backup location > "+backupDir);
		File f = new File(backupDir);
		f.mkdirs();
		String fileName = new SimpleDateFormat("dd-MM-yyyy-HHmmss").format(new Date());
		EntityManager entityManager = getSessionFactory().createEntityManager();
		entityManager.getTransaction().begin();
		String q = "BACKUP TO '"+backupDir+"\\"+fileName+".zip'";
		Query qr = entityManager.createNativeQuery(q);
		qr.executeUpdate();
		entityManager.getTransaction().commit();
	    entityManager.close();
	}

}
