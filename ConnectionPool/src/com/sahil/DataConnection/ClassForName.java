package com.sahil.DataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class ClassForName {
	public static void main(String[] args) throws SQLException {
		
	for (int i = 0; i < 5; i++) {
		try 
		{
			//1.Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.Get the Connection
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsapp_db", "root", "root");
	
			//3.Issue SQL Query
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs =(ResultSet)stmt.executeQuery("select * from student_info");
			
			//4.process the result return by SQL Query
			while (rs.next())
			{
				int RegistrationNumber= rs.getInt("regno");
				String FirstName  = rs.getString("firstName");
				System.out.println("Registration Number  :"+RegistrationNumber);
				System.out.println("First Name : "+FirstName);
			}
			System.out.println(con+":"+i);
			con.close();
		  } 
			catch (Exception e) {
				e.printStackTrace();
		}
	  }
	}
}
