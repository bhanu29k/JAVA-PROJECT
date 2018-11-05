/**
 * 
 */
package com.niit.ocs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.dao.DoctorDao;
import com.niit.ocs.util.impl.DBUtilImpl;


public class DoctorDaoImpl implements DoctorDao {

	/* (non-Javadoc)
	 * @see com.niit.ocs.dao.DoctorDao#createDoctor(com.niit.ocs.bean.DoctorBean)
	 */
	
	static Connection cnn;
	static Statement stmt;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	
	
	public String createDoctor(DoctorBean doctorBean) {
		

		try {
		cnn=DBUtilImpl.getDBConnection("jdbc");
		String query="insert into ocs_tbl_doctor(doctorid,doctorname,dateofbirth,dateofjoining,gender,qualification,specialization,yearsofexperience,street,location,city,state,pincode,contactnumber,emailid) "+" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		pstmt=cnn.prepareStatement(query);
		pstmt.setString(1,doctorBean.getDoctorID());
		pstmt.setString(2,doctorBean.getDoctorName());
		pstmt.setString(3,doctorBean.getDateOfBirth());
		pstmt.setString(4,doctorBean.getDateOfJoining());
		pstmt.setString(5,doctorBean.getGender());
		pstmt.setString(6,doctorBean.getQualification());
		pstmt.setString(7,doctorBean.getSpecialization());
		pstmt.setString(8,doctorBean.getYearsOfExperience());
		pstmt.setString(9,doctorBean.getStreet());
		pstmt.setString(10,doctorBean.getLocation());
		pstmt.setString(11,doctorBean.getCity());	
		
		pstmt.setString(12,doctorBean.getState());
		pstmt.setString(13,doctorBean.getPincode());
		pstmt.setString(14,doctorBean.getContactNumber());
		pstmt.setString(15,doctorBean.getEmailID ());
		
		pstmt.execute();
		return "success";
		
		}
		catch(SQLException s)
		   {
			   System.out.println("SQL Exception in DoctorDaoImpl  create doctor"+s);
			   return "FAIL";
		   }

	}



	public DoctorBean findByID(String str) {
		try {
			
			// Class.forName("com.mysql.cj.jdbc.Driver");

		      //System.out.println("Connecting to database...");
		      //cnn = DriverManager.getConnection("jdbc:mysql://localhost/ocs","root","root");
		  //  cnn=connectWithDatabase.getConnection("jdbc");
			cnn=DBUtilImpl.getDBConnection("jdbc");
			stmt=cnn.createStatement();
		      rs=stmt.executeQuery("select  * from ocs_tbl_doctor  where doctorid='"+str+"'");
		      if(rs.next())
				{	
					 String doctorID=rs.getString(1);
					 String doctorName=rs.getString(2);
					 String dateOfBirth=rs.getString(3);
					 String dateOfJoining=rs.getString(4);
					 String gender=rs.getString(5);  
					 String qualification=rs.getString(6);  
					 String specialization=rs.getString(7);  
					 String yearsOfExperience=rs.getString(8);
					 String street=rs.getString(9);
					 String location=rs.getString(10); 
					 String city=rs.getString(11);
					 String state=rs.getString(12);  
					 String pincode=rs.getString(13);  
					 String contactNumber=rs.getString(14);  
					 String emailID=rs.getString(15);
					
					
					return (new DoctorBean(doctorID,doctorName,dateOfBirth,dateOfJoining,gender,qualification,specialization,yearsOfExperience,street,location,city,state,pincode,contactNumber,emailID));
					
				}
				//else return null;
		      
		}
		
		   catch(SQLException s)
		   {
			   System.out.println("Exception in Doctor dao findbyid"+s);
			  // return null;
		   }
		return null;

	}



	public boolean updateDoctor(DoctorBean db) {
		
		try {
			cnn=DBUtilImpl.getDBConnection("jdbc");
			stmt=cnn.createStatement();
			stmt.executeUpdate("update ocs_tbl_doctor set doctorname='"+db.getDoctorName()+"', dateofbirth='"+db.getDateOfBirth()+"', dateofjoining='"+db.getDateOfJoining()+"', gender='"+db.getGender()+"', qualification='"+db.getQualification()+"', specialization='"+db.getSpecialization()+"', yearsofexperience='"+db.getYearsOfExperience()+"', street='"+db.getStreet()+"', location='"+db.getLocation()+"', city='"+db.getCity()+"', state='"+db.getState()+"', pincode='"+db.getPincode()+"', contactnumber='"+db.getContactNumber()+"', emailid='"+db.getEmailID()+"' where doctorid='"+db.getDoctorID()+"'");
		}
		catch(SQLException s)
		{
			System.out.println("Exception in Doctor dao update "+s);
			return false;
		}
		
		return true;
	}



	@Override
	public ArrayList<DoctorBean> findAll() {

		
		try {
			ArrayList<DoctorBean> doctor=new ArrayList<DoctorBean>();
			cnn=DBUtilImpl.getDBConnection("jdbc");
			pstmt=cnn.prepareStatement("select * from ocs_tbl_doctor");
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				DoctorBean doctorBean=new DoctorBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15));
				doctor.add(doctorBean);
			}
			if(rs.first())
			{
				return doctor;
			}
		}
		catch(SQLException s)
		{
			System.out.println("Exception in doctor Dao find all"+s);
			
		}
		return null;
	}



	@Override
	public int deleteDoctor(ArrayList<String> al) {
		try {
			cnn=DBUtilImpl.getDBConnection("jdbc");
			for(String i:al)
			{
				pstmt=cnn.prepareStatement("delete from ocs_tbl_doctor where doctorid='"+i+"'");
				pstmt.execute();
			}
			return 1;
		}   
		catch(SQLException s){
			System.out.println("Exception in doctor Dao delete "+s);
			return 0;
		}
		
	}

}
