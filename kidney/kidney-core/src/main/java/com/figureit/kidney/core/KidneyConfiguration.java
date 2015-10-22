package com.figureit.kidney.core;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum KidneyConfiguration implements DBConfiguration {

	CONFIG();

	private static final Logger log = LoggerFactory.getLogger(KidneyConfiguration.class);
	private static final String FILE_NAME = "configuration";
	private static String dbAddress;
	private static String dbName;

	private KidneyConfiguration() {
		//intentionally left blank
	}

	static {
		ResourceBundle config = null;
		config = ResourceBundle.getBundle(FILE_NAME);
		init(config);
	}

	private static void init(ResourceBundle config){
		log.info("Configuration initializing.");
		dbAddress = config.getString("database");
		dbName = config.getString("dbname");
		log.info("Configuration initialized.");
	}

	public String getDbAddress() {
		return dbAddress;
	}

	public String getDbName() {
		return dbName;
	}
}
