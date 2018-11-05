package com.niit.ocs.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.dao.AuthenticationDao;
import com.niit.ocs.dao.CredentialsBeanDao;
import com.niit.ocs.util.impl.DBUtilImpl;

public class AuthenticationDaoImpl implements AuthenticationDao {
	static Connection cnn;
	static Statement stmt;
	static Statement stmt1;
	static ResultSet rs;
	static ResultSet rs1;
	@Override
	public boolean authenticateDb(CredentialsBean credentialsBean) {
		
		try
		{
			cnn=DBUtilImpl.getDBConnection("jdbc");
			String a=credentialsBean.getUserID();
			//String b=credentialsBean.getPassword();
			stmt=cnn.createStatement();
			//stmt1=cnn.createStatement();
			//rs=stmt.executeQuery("select * from ocs_tbl_user_credentials where USERID= '" + a+"'and PASSWORD= '"+b+"' ");
			rs=stmt.executeQuery("select * from ocs_tbl_user_credentials where userid='"+a+"'");
			//rs1=stmt1.executeQuery("select * from ocs_tbl_user_credentials where password='"+b+"'");
		//	System.out.println("Hii");
			
			if(rs.next())
			{
				return true;
				
				/*
				if(rs1.next())
				
					{ 
					return true;
					}
				else 
					{
					System.out.println("Invalid credentials");
					return false;
					}
					*/
			}
			else
				{
				return false;
				}
		}
		catch(SQLException s)
		   {
			   System.out.println("SQL Exception in authenticate"+s);
			   return false;
		   }

	}

	@Override
	public String authorizeDb(String userId) {
		CredentialsBeanDao credentialsBeanDao=new CredentialsBeanDaoImpl();
		try
		
		{
			cnn=DBUtilImpl.getDBConnection("jdbc");
			CredentialsBean credentialsBean;
			credentialsBean=credentialsBeanDao.findByID(userId);
			String b=credentialsBean.getPassword();
			System.out.println(b);
			stmt1=cnn.createStatement();
			//cnn=DBUtilImpl.getDBConnection("jdbc");
			//stmt=cnn.createStatement();
			
			rs1=stmt1.executeQuery("select * from ocs_tbl_user_credentials where password='"+b+"'");
			
		//	if(rs1.getString("PASSWORD")==b)
			if(rs1.next())
			{
				return rs1.getString("USERTYPE");
			}
			else return "FAIL";
		}
		catch(SQLException s)
		   {
			   System.out.println("SQL Exception in authorize"+s);
			   return "FAIL";
		   }
		 
	}

	@Override
	public boolean changeLoginStatusDb(CredentialsBean user, int loginStatus) {

		if(loginStatus==0)
		{
			try
			{
				cnn=DBUtilImpl.getDBConnection("jdbc");
				stmt=cnn.createStatement();
			stmt.executeUpdate("update ocs_tbl_user_credentials set LOGINSTATUS=1 where USERID='"+user.getUserID()+"'");
		return true;
			}
			catch(SQLException s)
			   {
				   System.out.println("SQL Exception in change login status"+s);
				   return false;
			   }
		}
		else {
			try
			{
				//cnn=DBUtilImpl.getDBConnection("jdbc");
				//stmt=cnn.createStatement();
				stmt.executeUpdate("update ocs_tbl_user_credentials set LOGINSTATUS=0 where USERID='"+user.getUserID()+"'");
		return true;
			}
			catch(SQLException s)
			   {
				   System.out.println("SQL Exception in change  login status"+s);
				   return false;
			   }
		}
	}

	}


