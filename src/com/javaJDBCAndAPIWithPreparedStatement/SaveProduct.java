package com.javaJDBCAndAPIWithPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveProduct
{
	
	
	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			//database connection
			connection = DatabaseConnection.getDatabaseConnection();
			
			//Product objects
			Product product = new Product(220, "HP Mouse", 830.44);			
			
			String query = "insert into product(product_id, product_name, product_price) values(?, ?, ?)";
			
			//query statement object
			//Statement statement = connection.createStatement();
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setDouble(3, product.getProductPrice());
			
			//run the query
			int status = preparedStatement.executeUpdate();
			
			if(status > 0)
			{
				System.out.println(status+ " product object stored in database table...!");
			}
			else
			{
				System.out.println("unble to store product object in database table...!");
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
