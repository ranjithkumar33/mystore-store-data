package com.microapps.ebusiness.mystore.application.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;

import com.microapps.ebusiness.mystore.application.dao.exception.DuplicateEntryException;
import com.microapps.ebusiness.mystore.application.dao.exception.RecordNotFoundException;
import com.microapps.ebusiness.mystore.application.entity.Business;
import com.microapps.ebusiness.mystore.application.entity.BusinessUser;

public class UserRegistrationDaoImpl extends BaseDaoImpl<BusinessUser> implements RegistrationDao {

	@Override
	public Business saveBusiness(Business b) {
		return null;
	}

	@Override
	public Business findBusiness() {
		return null;
	}

	@Override
	public BusinessUser saveBusinessUser(BusinessUser bu) throws DuplicateEntryException {
		try {
			return saveOrUpdate(bu);
		} catch (RuntimeException e) {
			handleException(e);
		}
		return null;
	}

	private void handleException(Exception e) throws DuplicateEntryException {
		for(Throwable t = e.getCause(); t != null; t = t.getCause()) {
			//Handle duplicates
			if(t instanceof ConstraintViolationException) {
				if(t.getCause().getMessage().contains("Duplicate entry")) {
					throw new DuplicateEntryException("Duplicate username!", 0);
				}else if(t.getCause().getMessage().contains("Unique index")) {
					throw new DuplicateEntryException("Duplicate username!", 0);
				}
			}
		}
	}

	@Override
	public BusinessUser findBusinessUser(String userName, String password) throws RecordNotFoundException {
		Map<String, Object> param = new HashMap<>();
		param.put("userName", userName);
		param.put("password", password);
		return find("select u from BusinessUser u where u.userName=:userName and u.password=:password", BusinessUser.class, param);
	}

}
