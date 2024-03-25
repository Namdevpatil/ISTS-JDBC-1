package com.javaJDBCAndAPIWithPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			product.setProductId(220);						
			
			String query = "delete from product where product_id = ?";
						
			//query statement object
			//Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, product.getProductId());
			
			int status = preparedStatement.executeUpdate();
			
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
