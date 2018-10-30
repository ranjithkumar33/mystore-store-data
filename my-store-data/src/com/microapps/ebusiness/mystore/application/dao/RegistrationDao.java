package com.microapps.ebusiness.mystore.application.dao;

import com.microapps.ebusiness.mystore.application.dao.exception.DuplicateEntryException;
import com.microapps.ebusiness.mystore.application.dao.exception.RecordNotFoundException;
import com.microapps.ebusiness.mystore.application.entity.Business;
import com.microapps.ebusiness.mystore.application.entity.BusinessUser;

public interface RegistrationDao {
	
	Business saveBusiness(Business b);
	
	Business findBusiness()throws RecordNotFoundException;
	
	BusinessUser saveBusinessUser(BusinessUser bu)throws DuplicateEntryException;
	
	BusinessUser findBusinessUser(String userName, String password)throws RecordNotFoundException;
	
}
