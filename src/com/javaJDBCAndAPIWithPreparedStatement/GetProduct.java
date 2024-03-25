package com.javaJDBCAndAPIWithPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetProduct
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
			
			//String query = "insert into product(product_id, product_name, product_price) values('"+product5.getProductId()+"', '"+product5.getProductName()+"', '"+product5.getProductPrice()+"')";
			
			String query = "select product_id, product_name, product_price from product where product_id = ?";
			
			
			//query statement object
			//Statement statement = connection.createStatement();
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
						
			preparedStatement.setInt(1, product.getProductId());
			
			//run the query
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				double price = resultSet.getDouble(3);
				
				Product getProductObject = new Product(id, name, price); 
				
				System.out.println(getProductObject.toString());
				
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
