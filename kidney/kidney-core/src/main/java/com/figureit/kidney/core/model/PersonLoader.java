package com.figureit.kidney.core.model;
import com.figureit.kidney.core.data.DBConnection;
import com.mongodb.DB;
import com.mongodb.DBCursor;


public class PersonLoader {

	private DB database;

	public PersonLoader(){
		DBConnection conn = new DBConnection();
		database = conn.getDatabase();
	}

	public static void main(String[] args){
		PersonLoader loader = new PersonLoader();
		loader.loadData();
	}

	void loadData() {
		DBCursor cursor = database.getCollection("cd").find();
		while(cursor.hasNext()) {
		    System.out.println(cursor.next());
		}
	}

}
