package com.chofman.helloselenium.config;

public enum PersistenceConfigs {
	TestLocalSystemData("hibernate.cfg.testlocal-systemdata.xml");
		
	String value;
		
	private PersistenceConfigs(String type){
		value = type;
	}
		
	public String getValue(){
		return value;
	}

}
