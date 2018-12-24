package org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	  public static Connection getConnection() throws SQLException{
		  Connection con = null;
	      	try{
	      		Class.forName("com.mysql.jdbc.Driver");
	      		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KANRIDAITYOU","root","");
	      		System.out.println("DBConnected!!");
	      		return con;
	      	}catch(ClassNotFoundException e){
	      		throw new IllegalMonitorStateException();
	        } 
	  }
}
