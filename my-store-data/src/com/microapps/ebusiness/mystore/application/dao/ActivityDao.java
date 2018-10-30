package com.microapps.ebusiness.mystore.application.dao;

import java.util.List;

import com.microapps.ebusiness.mystore.application.entity.Activity;

public interface ActivityDao {
	
	 Activity saveActivity(Activity a);
	 
	 List<Activity> findActivitiesByCustomer(int customerId);
	 
	 List<Activity> findMonthlyActivities();

}
