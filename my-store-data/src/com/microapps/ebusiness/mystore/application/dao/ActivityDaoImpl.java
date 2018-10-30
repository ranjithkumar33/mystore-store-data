package com.microapps.ebusiness.mystore.application.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.microapps.ebusiness.mystore.application.entity.Activity;

public class ActivityDaoImpl extends BaseDaoImpl<Activity> implements ActivityDao{

	private static final Logger LOGGER = Logger.getLogger(ActivityDaoImpl.class.getName());

	@Override
	public Activity saveActivity(Activity a) {
		return saveOrUpdate(a);
	}

	@Override
	public List<Activity> findActivitiesByCustomer(int customerId) {
		Map<String, Object> params = new HashMap<>();
		params.put("customerId", customerId);
		return findAll(Activity.class, "SELECT a FROM Activity a WHERE a.customer.id = :customerId ORDER BY a.createdOn DESC", params);
	}

	@Override
	public List<Activity> findMonthlyActivities() {
		return findAll(Activity.class, "SELECT new Activity(SUM(a.amount), a.createdOn) FROM Activity a WHERE a.name = 'New sale' GROUP BY a.createdOn", null);
	}
	 
}
