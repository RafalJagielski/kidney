package com.figureit.kidney.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum KidneyConfiguration {

	CONFIG();
	
	private static final Logger log = LoggerFactory.getLogger(KidneyConfiguration.class);
	private static final  String FILE_NAME = "configuration.properties";
	private static final Properties configuration;
	
	private static String dbAddress;
	private static String dbName;

	
	private KidneyConfiguration() {
		//intentionally left blank
	}
	
	static {
		configuration = new Properties();
		try {
			configuration.load(new FileInputStream(FILE_NAME));
		} catch (IOException e) {
			log.error("Can't load configuration file " + FILE_NAME + " .");
		}
		init();
	}

	private static void init(){
		dbAddress = configuration.getProperty("database");
		dbName = configuration.getProperty("dbname");
	}
	
	public String getDbAddress() {
		return dbAddress;
	}

	public String getDbName() {
		return dbName;
	}
}
