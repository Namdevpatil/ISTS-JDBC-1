package com.javaJDBCConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example2
{
	
	//database credentials
	private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/product_db";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "DeV@1990";
	

	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			//step-1: create driver object/load the driver
			Class.forName(DATABASE_DRIVER);
			
			//connection object
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
			String query = "insert into product(product_id, product_name, product_price) values(101, 'white board marker', 45.55)";
			
			//query statement object
			Statement statement = connection.createStatement();
			
			//run the query
			int status = statement.executeUpdate(query);
			
			if(status > 0)
			{
				System.out.println("data stored in database table...!");
			}
			else
			{
				System.out.println("data not stored in database table...!");
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			connection.close();
		}

	}

}
