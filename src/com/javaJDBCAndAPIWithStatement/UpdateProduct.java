package com.javaJDBCAndAPIWithStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateProduct
{
	
	
	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			//database connection
			connection = DatabaseConnection.getDatabaseConnection();			
			
			Product product = new Product(101, "black board marker", 100.34);
						
			
			String query = "update product set product_name = '"+product.getProductName()+"', product_price = '"+product.getProductPrice()+"' where product_id = "+product.getProductId();
						
			//query statement object
			Statement statement = connection.createStatement();
			
			int status = statement.executeUpdate(query);
			
			if(status > 0)
			{
				System.out.println(status +" Product object is updated in database table");
			}
			else
			{
				System.out.println("Product object is not updated in database table");
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
