 package com.niit.ocs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.niit.ocs.bean.ProfileBean;
import com.niit.ocs.dao.ProfileDao;
import com.niit.ocs.util.impl.DBUtilImpl;

public class ProfileDaoImpl implements ProfileDao {
	static Logger loggr=Logger.getLogger(ProfileDaoImpl.class);
	static Connection cnn;
	static Statement stmt;
	static ResultSet rs;
	static PreparedStatement pstmt;
	static PreparedStatement pstmt1;
	@Override
	public String createProfile(ProfileBean profileBean) {
		loggr.info("createProfile is working");
		try
		{
			cnn=DBUtilImpl.getDBConnection("jdbc");
		//	String a=credentialsBean.getUserID();
			//String b=credentialsBean.getPassword();
			String query="insert into ocs_tbl_user_profile(userid,firstname,lastname,dateofbirth,gender,street,location,city,state,pincode,mobileno,emailid) "+" values(?,?,?,?,?,?,?,?,?,?,?,?)";
			String query1="insert into ocs_tbl_user_credentials(userid,password,usertype) "+" values(?,?,?)";
			pstmt=cnn.prepareStatement(query);
			pstmt1=cnn.prepareStatement(query1);
			pstmt.setString(1,profileBean.getUserID());
			pstmt.setString(2,profileBean.getFirstName());
			pstmt.setString(3,profileBean.getLastName());
			pstmt.setString(4,profileBean.getDateOfBirth());
			pstmt.setString(5,profileBean.getGender());
			pstmt.setString(6,profileBean.getStreet());
			pstmt.setString(7,profileBean.getLocation());
			pstmt.setString(8,profileBean.getCity());		
			pstmt.setString(9,profileBean.getState());
			pstmt.setString(10,profileBean.getPincode());
			pstmt.setString(11,profileBean.getMobileNo());
			pstmt.setString(12,profileBean.getEmailID ());
			
			pstmt1.setString(1,profileBean.getUserID());
			pstmt1.setString(2,profileBean.getPassword());
			pstmt1.setString(3, "P");
			
			pstmt.execute();
			pstmt1.execute();
			return profileBean.getUserID() ;
		}
		catch(SQLException s)
		   {
			   System.out.println("SQL Exception3"+s);
			   return "fail";
			   		   }
			
		
	}

}
