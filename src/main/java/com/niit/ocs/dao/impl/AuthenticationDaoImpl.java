package com.niit.ocs.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.dao.AuthenticationDao;
import com.niit.ocs.dao.CredentialsBeanDao;
import com.niit.ocs.service.impl.DoctorBeanServiceImpl;
import com.niit.ocs.util.impl.DBUtilImpl;

public class AuthenticationDaoImpl implements AuthenticationDao {
	static Logger loggr=Logger.getLogger(AuthenticationDaoImpl.class);
	static Connection cnn;
	static Statement stmt;
	static Statement stmt1;
	static ResultSet rs;
	static ResultSet rs1;
	@Override
	public boolean authenticateDb(CredentialsBean credentialsBean) {
		loggr.info("authenticateDb is working");
		try
		{
			cnn=DBUtilImpl.getDBConnection("jdbc");
			String a=credentialsBean.getUserID();
			String b=credentialsBean.getPassword();
			stmt=cnn.createStatement();
			stmt1=cnn.createStatement();
			//rs=stmt.executeQuery("select * from ocs_tbl_user_credentials where USERID= '" + a+"'and PASSWORD= '"+b+"' ");
			rs=stmt.executeQuery("select * from ocs_tbl_user_credentials where userid='"+a+"'");
			rs1=stmt1.executeQuery("select * from ocs_tbl_user_credentials where password='"+b+"'");
		//	System.out.println("Hii");
			
			if(rs.next())
			{
				if(rs1.next())
					{ 
					return true;
					}
				else 
					{
					return false;
					}
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
		loggr.info("authorizeDb is working");
	CredentialsBeanDao credentialsBeanDao=new CredentialsBeanDaoImpl();
		try
		{
			cnn=DBUtilImpl.getDBConnection("jdbc");
			CredentialsBean credentialsBean;
			credentialsBean=credentialsBeanDao.findByID(userId);
			String b=credentialsBean.getPassword();
	
			stmt1=cnn.createStatement();		
			rs1=stmt1.executeQuery("select * from ocs_tbl_user_credentials where password='"+b+"'");
			if(rs1.next())
				return rs1.getString("USERTYPE");
			
		}
		catch(SQLException s)
		   {
			   System.out.println("SQL Exception in authorize"+s);
			  
		   }
		 return "FAIL";
	}

	@Override
	public boolean changeLoginStatusDb(CredentialsBean user, int loginStatus) {
		loggr.info("changeLoginStatusDb is working");
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


