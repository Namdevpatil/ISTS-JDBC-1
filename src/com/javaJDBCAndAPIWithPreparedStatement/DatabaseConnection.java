package com.javaJDBCAndAPIWithPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{

	//database credentials
	private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/product_db";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "DeV@1990";

	public static Connection getDatabaseConnection()throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			//step-1: create driver object/load the driver
			Class.forName(DATABASE_DRIVER);
			
			//connection object
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
						
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return connection;		
		
	}

}
