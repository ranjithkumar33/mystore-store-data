package com.microapps.ebusiness.mystore.application.dao;

import com.microapps.ebusiness.mystore.application.dao.exception.RecordNotFoundException;
import com.microapps.ebusiness.mystore.application.entity.AppSettings;

public class SettingsDaoImpl extends BaseDaoImpl<AppSettings> implements SettingsDao{

	@Override
	public AppSettings saveSettings(AppSettings s) {
		return saveOrUpdate(s);
	}

	@Override
	public AppSettings findSettings() throws RecordNotFoundException {
		return find("select s from AppSettings s", AppSettings.class, null);
	}

}
