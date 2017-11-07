package com.chofman.helloselenium.config;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class PersistenceFactory {
	
	private static PersistenceFactory instance;
	private Map<PersistenceConfigs, SessionFactory> sessionFactoryMap;

	private PersistenceFactory() {
		sessionFactoryMap = new HashMap<PersistenceConfigs, SessionFactory>();
	}
	
	public static PersistenceFactory getInstance() {
		if (instance == null) {
			instance = new PersistenceFactory();
		}
		return instance;
	}
	
	private void generateSessionFactory(PersistenceConfigs config){
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure(config.getValue()).build();

		sessionFactoryMap.put(config, configuration.buildSessionFactory(serviceRegistry));
	}

	public SessionFactory getSessionFactory(PersistenceConfigs config) {
		if(sessionFactoryMap == null || !sessionFactoryMap.containsKey(config)){
			generateSessionFactory(config);
		}
		Logger log = Logger.getLogger("org.hibernate");
	    log.setLevel(Level.OFF);
		return sessionFactoryMap.get(config);
	}
	
	public void close(){
		for(Map.Entry<PersistenceConfigs, SessionFactory> entry : sessionFactoryMap.entrySet()){
			entry.getValue().close();//closes session
			sessionFactoryMap.remove(entry.getKey());//removes session from map
		}
		instance = null;
	}
}
