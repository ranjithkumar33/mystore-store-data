package com.microapps.ebusiness.mystore.application.dao;

import com.microapps.ebusiness.mystore.application.dao.exception.RecordNotFoundException;
import com.microapps.ebusiness.mystore.application.entity.AppSettings;

public interface SettingsDao {
	
	AppSettings saveSettings(AppSettings s);
	
	AppSettings findSettings()throws RecordNotFoundException;

}
