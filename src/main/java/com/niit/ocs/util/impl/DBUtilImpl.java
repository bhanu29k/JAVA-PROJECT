package com.niit.ocs.util.impl;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.niit.ocs.util.Authentication;
import com.niit.ocs.util.DBUtil;
//import java.sql.Statement;



public class DBUtilImpl implements DBUtil {
	static Logger loggr=Logger.getLogger(DBUtilImpl.class);
	static Connection cnn;
	
	
	static final String USER = "root";
	   static final String PASS = "root";
		final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		final static String DB_URL = "jdbc:mysql://localhost/ocs";
		
	public static Connection getDBConnection(String driverType) {
		
		//loggr.info("getDBConnection working");
		try {
		
			 Class.forName(JDBC_DRIVER);

		   //   System.out.println("Connecting to database...");
		      cnn = DriverManager.getConnection(DB_URL,USER,PASS);
		      return cnn;
		}
		catch(ClassNotFoundException e)
		   {
			   System.out.println("Class1 not found"+e);
			   return null;
		   }
		   catch(SQLException s)
		   {
			   System.out.println("SQL Exception1"+s);
			   return null;
		   }
		
	}
}
