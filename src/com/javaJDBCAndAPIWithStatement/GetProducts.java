package com.javaJDBCAndAPIWithStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetProducts
{
	
	
	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			//database connection
			connection = DatabaseConnection.getDatabaseConnection();
			
			
			//String query = "insert into product(product_id, product_name, product_price) values('"+product5.getProductId()+"', '"+product5.getProductName()+"', '"+product5.getProductPrice()+"')";
			
			String query = "select product_id, product_name, product_price from product";
			
			
			//query statement object
			Statement statement = connection.createStatement();
			
			//run the query
			ResultSet resultSet = statement.executeQuery(query);
			
			List<Product> products = new ArrayList<Product>();
			
			while(resultSet.next())
			{
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				double price = resultSet.getDouble(3);
				
				Product getProductObject = new Product(id, name, price); 
				
				products.add(getProductObject);
				
				//System.out.println(getProductObject.toString());
				
			}
			
			System.out.println(products);
			
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
