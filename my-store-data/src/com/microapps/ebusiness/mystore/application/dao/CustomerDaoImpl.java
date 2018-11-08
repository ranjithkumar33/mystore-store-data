package com.microapps.ebusiness.mystore.application.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;

import com.microapps.ebusiness.mystore.application.dao.exception.DuplicateEntryException;
import com.microapps.ebusiness.mystore.application.dao.exception.DuplicateEntryField;
import com.microapps.ebusiness.mystore.application.dao.exception.RecordNotFoundException;
import com.microapps.ebusiness.mystore.application.entity.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

	@Override
	public Customer saveCustomer(Customer c)throws DuplicateEntryException {
		try {
			return saveOrUpdate(c);
		} catch (RuntimeException e) {
			handleException(e);
		}
		return null;
	}

	private void handleException(RuntimeException e) throws DuplicateEntryException{
		for(Throwable t = e.getCause(); t != null; t = t.getCause()) {
			//Handle duplicates
			if(t instanceof ConstraintViolationException) {
				if(t.getCause().getMessage().contains("Duplicate entry")) {
					String key = t.getCause().getMessage().substring(t.getCause().getMessage().length() - 1);
					throw new DuplicateEntryException(t.getCause().getMessage(), Integer.parseInt(key));
				}else if(t.getCause().getMessage().contains("Unique index")) {
					if(t.getCause().getMessage().contains("MOBILE")) {
						throw new DuplicateEntryException(t.getCause().getMessage(), DuplicateEntryField.mobile.getKey());
					}else if(t.getCause().getMessage().contains("CARDNUM")) {
						throw new DuplicateEntryException(t.getCause().getMessage(), DuplicateEntryField.cardNumber.getKey());
					}
				}
			}
		}
	}

	@Override
	public Customer findCustomerById(int id) throws RecordNotFoundException {
		return find(Customer.class, id);
	}

	@Override
	public Customer searchCustomerByMobile(String mobile) throws RecordNotFoundException {
		Map<String, Object> params = new HashMap<>();
		params.put("mobile", mobile);
		List<Customer> list = findAll(Customer.class, "SELECT c FROM Customer c WHERE c.mobile =:mobile", params);
		if(list != null && !list.isEmpty()) {
			return list.get(0);
		}else {
			throw new RecordNotFoundException("No customer found");
		}
	}

	@Override
	public Customer searchCustomerByCard(String card) throws RecordNotFoundException {
		Map<String, Object> params = new HashMap<>();
		params.put("cardNumber", card);
		List<Customer> list = findAll(Customer.class, "SELECT c FROM Customer c WHERE c.cardNumber =:cardNumber", params);
		if(list != null) {
			return list.get(0);
		}else {
			throw new RecordNotFoundException("No customer found");
		}
	}

	@Override
	public List<Customer> findAllCustomers() {
		return findAll(Customer.class, "SELECT new com.microapps.ebusiness.mystore.application.entity.Customer(c.id, c.name, c.createdOn, SUM(a.amount), c.gender, c.status) from Customer c LEFT JOIN c.activities a on a.customer.id=c.id and a.name = 'New sale' GROUP BY c.id ", null);
	}

	@Override
	public void saveAllCustomers(List<Customer> cl) {
		cl.forEach(c -> {
			saveOrUpdate(c);
		});
	}

}
