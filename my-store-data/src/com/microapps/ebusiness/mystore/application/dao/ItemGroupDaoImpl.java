package com.microapps.ebusiness.mystore.application.dao;

import java.util.List;

import com.microapps.ebusiness.mystore.application.entity.ItemGroup;

public class ItemGroupDaoImpl extends BaseDaoImpl<ItemGroup> implements ItemGroupDao{

	@Override
	public List<ItemGroup> saveAll(List<ItemGroup> cl) {
		cl.forEach(item -> {
			saveOrUpdate(item);
		});
		return findAllItemGroups();
	}

	@Override
	public List<ItemGroup> findAllItemGroups() {
		return findAll(ItemGroup.class, "select i from ItemGroup i ORDER BY i.name ASC", null);
	}

	@Override
	public ItemGroup saveItemGroup(ItemGroup itemGroup) {
		return saveOrUpdate(itemGroup);
	}

}
