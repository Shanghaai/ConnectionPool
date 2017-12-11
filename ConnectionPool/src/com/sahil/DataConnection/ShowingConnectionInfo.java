package com.sahil.DataConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ShowingConnectionInfo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		java.util.Date d1  =new java.util.Date();
		for (int i = 0; i <10; i++) 
		{
			try {
				//1.Load the Driver
				Class.forName("com.mysql.jdbc.Driver");
				//2.Get the Connection
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsapp_db", "root", "root");
				System.out.println(con+" : "+i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		java.util.Date d2  =new java.util.Date();
		System.out.println("start time : "+d1);
		System.out.println("start time : "+d2);
		
		
		
	}

}
