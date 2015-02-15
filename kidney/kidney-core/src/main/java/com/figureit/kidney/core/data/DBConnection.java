package com.figureit.kidney.core.data;

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.figureit.kidney.core.KidneyConfiguration;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class DBConnection {
	
	private static final Logger log = LoggerFactory.getLogger(DBConnection.class);
	
	private static MongoClient mongoClient;
	
	private static KidneyConfiguration configuration = KidneyConfiguration.CONFIG;
	
	static {
		try {
			 mongoClient = new MongoClient(
					 configuration.getDbAddress());
		} catch (UnknownHostException e) {
			log.error("Cannot connect to database.");
		}
	}
	
	public DBConnection() {
	}
	
	public DB getDatabase() {
		return mongoClient.getDB(configuration.getDbName());
	}
}
	
