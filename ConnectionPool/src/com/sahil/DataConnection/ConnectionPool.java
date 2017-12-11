package com.sahil.DataConnection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class ConnectionPool
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Connection con;
		Statement st;
		ResultSet rs;
		
		System.out.println("database connection");
		for (int i = 0; i <10; i++) 
		{
			try {
				//1.Load the driver
				Driver d = new com.mysql.jdbc.Driver();
				DriverManager.registerDriver(d);

				//2.Get the connection 
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsapp_db", "root", "root");
				
				//3.Issue sql query
				st  = (Statement) con.createStatement();
				rs=st.executeQuery("select * from student_info");

				//4.Process the result returned by sql query
				while(rs.next())
				{
					int value = rs.getInt("regno");
					System.out.println("Reg No. : is : "+value);
				}
				System.out.println(con);
				//5.Close all jdbc object
				if(con!=null)
				{
					con.close();
					System.out.println("connection closed success");
				}
				if(rs!=null)
				{
					System.out.println("resultSet closed success");
					rs.close();
				}
				if(st!=null)
				{
					System.out.println("Statement closed success");
					st.close();
				}
				System.out.println(rs);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of for
	}
}	
