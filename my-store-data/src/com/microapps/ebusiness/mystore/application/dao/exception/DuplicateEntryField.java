package com.microapps.ebusiness.mystore.application.dao.exception;

public enum DuplicateEntryField {
	
	mobile(3), cardNumber(2);
	
	DuplicateEntryField(int key){
		this.key=key;
	}
	
	private int key;
	
	
	
	public int getKey() {
		return key;
	}



	public static DuplicateEntryField findFieldByKey(int key) {
		for(DuplicateEntryField at : values()) {
			if(key == at.getKey()) {
				return at;
			}
		}
		return null;
	}
	

}
