package com.javaJDBCAndAPIWithStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
			//Product product1 = new Product(102, "Mobile", 89030.45);
			//Product product2 = new Product(104, "Television", 45900.45);
			//Product product3 = new Product(105, "Laptop", 56030.43);
			//Product product4 = new Product(107, "Smart Watch", 8030.46);
			Product product5 = new Product(110, "Wifi router", 3030.44);
			
			
			String query = "insert into product(product_id, product_name, product_price) values('"+product5.getProductId()+"', '"+product5.getProductName()+"', '"+product5.getProductPrice()+"')";
			
			//query statement object
			Statement statement = connection.createStatement();
			
			//run the query
			int status = statement.executeUpdate(query);
			
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
