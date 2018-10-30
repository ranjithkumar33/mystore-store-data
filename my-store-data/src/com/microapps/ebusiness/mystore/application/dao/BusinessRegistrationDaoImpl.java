package com.microapps.ebusiness.mystore.application.dao;

import com.microapps.ebusiness.mystore.application.dao.exception.RecordNotFoundException;
import com.microapps.ebusiness.mystore.application.entity.Business;
import com.microapps.ebusiness.mystore.application.entity.BusinessUser;

public class BusinessRegistrationDaoImpl extends BaseDaoImpl<Business> implements RegistrationDao {

	@Override
	public Business saveBusiness(Business b) {
		return saveOrUpdate(b);
	}

	@Override
	public Business findBusiness() throws RecordNotFoundException {
		return find("select b from Business b", Business.class, null);
	}

	@Override
	public BusinessUser saveBusinessUser(BusinessUser bu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessUser findBusinessUser(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
