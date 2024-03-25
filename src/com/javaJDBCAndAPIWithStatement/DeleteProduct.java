package com.javaJDBCAndAPIWithStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteProduct
{
	
	
	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			//database connection
			connection = DatabaseConnection.getDatabaseConnection();			
			
			Product product = new Product();
			product.setProductId(110);
						
			
			String query = "delete from product where product_id = "+product.getProductId();
						
			//query statement object
			Statement statement = connection.createStatement();
			
			int status = statement.executeUpdate(query);
			
			if(status > 0)
			{
				System.out.println(status +" Product object is deleted from database table");
			}
			else
			{
				System.out.println("Product object is not deleted from database table");
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
