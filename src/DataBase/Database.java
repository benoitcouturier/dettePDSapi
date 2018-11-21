package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

		 private static final String URL = "jdbc:mysql://localhost:3306/databaseSql";// mysql 3306 postgre 5432 
		 private static final String USER = "app";
		 private static final String PASSWORD = "1234";
		 private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		 
		 static {
			 try {
				 Class.forName(DRIVER_NAME).newInstance();
				 System.out.println("* Driver loaded.");
			 }
			 catch (ClassNotFoundException e) {
				 System.err.println("* ERROR: Driver " + DRIVER_NAME + "not found");
			 }
			 catch (InstantiationException e) {
				 System.err.println("* ERROR: Impossible to create aninstance of " + DRIVER_NAME);
				 System.err.println(e.getMessage());
			 }
			 catch (IllegalAccessException e) {
				 System.err.println("* ERROR: Impossible to create aninstance of " + DRIVER_NAME);
				 System.err.println(e.getMessage());
			 }
		 }
		 
		public static Connection getConnection() throws SQLException {
			 return DriverManager.getConnection(URL, USER, PASSWORD);
		}
		 
	}


