package com.figureit.kidney.core;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum KidneyConfiguration implements DBConfiguration {

	CONFIG();

	private static final Logger log = LoggerFactory.getLogger(KidneyConfiguration.class);
	private static final String FILE_NAME = "configuration.properties";
	private static String dbAddress;
	private static String dbName;

	private KidneyConfiguration() {
		//intentionally left blank
	}

	static {
		PropertiesConfiguration config = null;
		try {
			config = new PropertiesConfiguration(FILE_NAME);
		} catch (ConfigurationException e) {
			log.error("error",e);
		}
		init(config);
	}

	private static void init(PropertiesConfiguration config){
		log.info("Configuration initializing.");
		dbAddress = (String) config.getProperty("database");
		dbName = (String) config.getProperty("dbname");
		log.info("Configuration initialized.");
	}

	public String getDbAddress() {
		return dbAddress;
	}

	public String getDbName() {
		return dbName;
	}
}
