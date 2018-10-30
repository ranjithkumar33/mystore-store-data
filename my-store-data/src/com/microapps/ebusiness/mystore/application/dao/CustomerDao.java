package com.microapps.ebusiness.mystore.application.dao;

import java.util.List;

import com.microapps.ebusiness.mystore.application.dao.exception.DuplicateEntryException;
import com.microapps.ebusiness.mystore.application.dao.exception.RecordNotFoundException;
import com.microapps.ebusiness.mystore.application.entity.Customer;

public interface CustomerDao {
	
	void saveAllCustomers(List<Customer> cl);
	
	Customer saveCustomer(Customer c)throws DuplicateEntryException;
	
	Customer findCustomerById(int id) throws RecordNotFoundException;
	
	Customer searchCustomerByMobile(String mob)throws RecordNotFoundException;
	
	Customer searchCustomerByCard(String card)throws RecordNotFoundException;
	
	List<Customer> findAllCustomers();

}
