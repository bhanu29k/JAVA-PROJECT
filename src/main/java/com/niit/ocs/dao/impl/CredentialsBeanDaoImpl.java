package com.niit.ocs.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.niit.ocs.bean.CredentialsBean;

import com.niit.ocs.dao.CredentialsBeanDao;
import com.niit.ocs.util.impl.DBUtilImpl;

public class CredentialsBeanDaoImpl implements CredentialsBeanDao {
	static Logger loggr=Logger.getLogger(CredentialsBeanDaoImpl.class);
	static Connection cnn;
	static Statement stmt;
	static ResultSet rs;
	static PreparedStatement pstmt;
	CredentialsBean credentialsBean=new CredentialsBean(null,null);
	//DBUtil dbUtil=new DBUtilImpl();
	//ConnectWithDatabaseDao connectWithDatabase=new  ConnectWithDatabaseDaoImpl(); 
	
	public CredentialsBean findByID(String str) {
		loggr.info("findByID is working");
		try {
			
			// Class.forName("com.mysql.cj.jdbc.Driver");

		      //System.out.println("Connecting to database...");
		      //cnn = DriverManager.getConnection("jdbc:mysql://localhost/ocs","root","root");
		  //  cnn=connectWithDatabase.getConnection("jdbc");
			cnn=DBUtilImpl.getDBConnection("jdbc");
			stmt=cnn.createStatement();
		      rs=stmt.executeQuery("select  * from ocs_tbl_user_credentials  where userid='"+str+"'");
		      if(rs.next())
				{
					String userID=rs.getString(1);
					String password=rs.getString(2);
					return (new CredentialsBean(userID,password));
					
				}
				//else return null;
		      
		}
		
		   catch(SQLException s)
		   {
			   System.out.println("SQL Exception1"+s);
			  // return null;
		   }
		
		
		return null;
	}
	
	public boolean updateCredentialBeanDao(CredentialsBean credentialsBean) {
		loggr.info("updateCredentialBeanDao is working");
		try {
			cnn=DBUtilImpl.getDBConnection("jdbc");
			stmt=cnn.createStatement();
			stmt.executeUpdate("update ocs_tbl_user_credentials set password='"+credentialsBean.getPassword()+"'where userid='"+credentialsBean.getUserID()+"'");
		}
		catch(SQLException s)
		{
			System.out.println("Exception in Credential bean Dao update credential"+s);
			return false;
		}
		
		
		return true;
	}
	
	
		
		

}
	


