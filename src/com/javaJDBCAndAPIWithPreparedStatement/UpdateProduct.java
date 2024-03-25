package com.javaJDBCAndAPIWithPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProduct
{
	
	
	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			//database connection
			connection = DatabaseConnection.getDatabaseConnection();			
			
			Product product = new Product(101, "Water botle", 200.34);
						
			
			String query = "update product set product_name = ?, product_price = ? where product_id = ?";
						
			//query statement object
			//Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setDouble(2, product.getProductPrice());
			
			preparedStatement.setInt(3, product.getProductId());
			
			int status = preparedStatement.executeUpdate();
			
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
