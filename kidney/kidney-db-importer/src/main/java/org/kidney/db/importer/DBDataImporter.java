package org.kidney.db.importer;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.figureit.kidney.core.data.DBConnection;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 *
 */
public class DBDataImporter {
	/** Logger. */
	private static final Logger log = LoggerFactory.getLogger(DBDataImporter.class);

	private DB database;
	
	public static void main( String[] args ) {
		log.debug("Starting DBDataParser process.");
		DBDataImporter parser = new DBDataImporter();
		parser.parse();
		log.debug("Starting DBDataParser process.");
	}

	private void parse() {
		DBCollection collection = database.getCollection("test");
		DBCursor find = collection.find();
		
		while (find.hasNext()){
			DBObject next = find.next();
			Map map = next.toMap();
			System.out.println(map);
		}
		
	}

	DBDataImporter(){
		DBConnection connection = new DBConnection();
		database = connection.getDatabase();
	}

}
