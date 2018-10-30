package com.microapps.ebusiness.mystore.application.dao;

import java.util.List;

import com.microapps.ebusiness.mystore.application.entity.ItemGroup;

public interface ItemGroupDao {
	
	List<ItemGroup> saveAll(List<ItemGroup> cl);
	
	List<ItemGroup> findAllItemGroups();
	
	ItemGroup saveItemGroup(ItemGroup itemGroup);

}
