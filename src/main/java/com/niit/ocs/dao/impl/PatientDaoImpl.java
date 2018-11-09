package com.niit.ocs.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.bean.PatientBean;
import com.niit.ocs.bean.ProfileBean;
import com.niit.ocs.dao.PatientDao;
import com.niit.ocs.util.impl.DBUtilImpl;

import jdk.internal.jline.internal.Log;

public class PatientDaoImpl implements PatientDao{
	static Logger loggr=Logger.getLogger(PatientDaoImpl.class);
	static Connection cnn;
	static Statement stmt;
	static PreparedStatement pstmt;
	static ResultSet rs;

	public String createPatient(PatientBean patientBean) {
		loggr.info("createPatient is working");
		try {
			cnn=DBUtilImpl.getDBConnection("jdbc");
			String query="insert into ocs_tbl_patient(patientid,userid,appointment_date,ailment_type,ailment_details,diagnosis_history) "+" values(?,?,?,?,?,?)";
			pstmt=cnn.prepareStatement(query);
			pstmt.setString(2,patientBean.getUserID());
			pstmt.setString(1,patientBean.getPatientID());
			pstmt.setDate(3,Date.valueOf(patientBean.getAppointmentDate()));
			pstmt.setString(4,patientBean.getAilmentType());
			pstmt.setString(5,patientBean.getAilmentDetails());
			pstmt.setString(6,patientBean.getDiagnosishistory());
			pstmt.execute();
			return "SUCCESS";
			
			}
			catch(SQLException s)
			   {
				   System.out.println("SQL Exception in patientDaoImpl  create patient "+s);
				   return "FAIL";
			   }

	}

	@Override
	public ArrayList<PatientBean> findAll() {
		loggr.info("findAll is working");
		try {
			
			ArrayList<PatientBean> patient=new ArrayList<PatientBean>();
			cnn=DBUtilImpl.getDBConnection("jdbc");
			pstmt=cnn.prepareStatement("select * from ocs_tbl_patient");
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				PatientBean patientBean=new PatientBean(rs.getString(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5),rs.getString(6));
				patient.add(patientBean);
				//System.out.println("hello");
			}
			if(rs.first())
			{
				return patient;
			}
		}
		catch(SQLException s)
		{
			System.out.println("Exception in patient Dao find all"+s);
			
		}
		return null;
	}

	@Override
	public PatientBean findByID(String patientID) {
		loggr.info("findByID is working");
try {
			
			// Class.forName("com.mysql.cj.jdbc.Driver");

		      //System.out.println("Connecting to database...");
		      //cnn = DriverManager.getConnection("jdbc:mysql://localhost/ocs","root","root");
		  //  cnn=connectWithDatabase.getConnection("jdbc");
			cnn=DBUtilImpl.getDBConnection("jdbc");
			stmt=cnn.createStatement();
		      rs=stmt.executeQuery("select  * from ocs_tbl_patient  where patientid='"+patientID+"'");
		      if(rs.next())
				{	
					 String patientId=rs.getString(1);
					 String userId=rs.getString(2);
					 Date appointmentDate=rs.getDate(3);
					 String ailmentType=rs.getString(4);
					 String ailmentDetails=rs.getString(5);  
					 String diagnosisHistory=rs.getString(6);  
					 return (new PatientBean(patientId,userId,appointmentDate.toLocalDate(),ailmentType,ailmentDetails,diagnosisHistory));
				}
		      
				//else return null;
		      
		}
		
		   catch(SQLException s)
		   {
			   System.out.println("Exception in patient dao findbyid"+s);
			  // return null;
		   }
		return null;


	}

	@Override
	public boolean updatePatient(PatientBean patientBean) {
		loggr.info("updatePatient is working");
		try {
			cnn=DBUtilImpl.getDBConnection("jdbc");
			stmt=cnn.createStatement();
			//System.out.println(patientBean.getPatientID());
			int i=stmt.executeUpdate("update ocs_tbl_patient set appointment_date='"+patientBean.getAppointmentDate()+"', ailment_type='"+patientBean.getAilmentType()+"', ailment_details='"+patientBean.getAilmentDetails()+"', diagnosis_history='"+patientBean.getDiagnosishistory()+"' where patientid='"+patientBean.getPatientID()+"'");
			//System.out.println("update ocs_tbl_patient set appointment_date='"+patientBean.getAppointmentDate()+"', ailment_type='"+patientBean.getAilmentType()+"', ailment_details='"+patientBean.getAilmentDetails()+"', diagnosis_history='"+patientBean.getDiagnosishistory()+"' where patientid='"+patientBean.getPatientID()+"'");
			//System.out.println("hi"+i);
			return true;
		}
		catch(SQLException s)
		{
			System.out.println("Exception in Doctor dao update "+s);
			return false;
		}
		
		
	}

	@Override
	public ArrayList<DoctorBean> findDoctors(String special, LocalDate dateAppoint) {
		loggr.info("findDoctors is working");
		try {
			ArrayList<DoctorBean> doctor=new ArrayList<DoctorBean>();
			cnn=DBUtilImpl.getDBConnection("jdbc");
			pstmt=cnn.prepareStatement("select ocs_tbl_doctor.* from ocs_tbl_doctor left join  ocs_tbl_leave on  ocs_tbl_leave.doctorid=ocs_tbl_doctor.doctorid where (leave_to is null or cast('"+dateAppoint+"' as date) not  between leave_from and leave_to) and specialization='"+special+"'");
			//System.out.println("select ocs_tbl_doctor.* from ocs_tbl_doctor left join  ocs_tbl_leave on  ocs_tbl_leave.doctorid=ocs_tbl_doctor.doctorid where (leave_to is null or cast('"+dateAppoint+"' as date) not  between leave_from and leave_to) and specialization='"+special+"'");
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
			System.out.println("Exception in reporter Dao find doctorBY date"+s);
			
			
		}
		return null;
	}

	@Override
	public String createRequest(String did, LocalDate dateAppoint, String pId) {
		loggr.info("createRequest is working");
		try {
			cnn=DBUtilImpl.getDBConnection("jdbc");
			String query="insert into ocs_tbl_appointments(doctorid,patientid,appointment_date) "+" values(?,?,?)";
			pstmt=cnn.prepareStatement(query);
		//	pstmt.setString(1,FLOOR(rand()));
			pstmt.setString(1,did);
			pstmt.setString(2,pId);
			pstmt.setDate(3,Date.valueOf(dateAppoint));
		
			pstmt.execute();
			return "CONFIRMED";
			
			}
			catch(SQLException s)
			   {
				   System.out.println("SQL Exception in patientDaoImpl  create request"+s);
				   return "FAIL";
			   }

	}

	@Override
	public DoctorBean findAvaiableDoctor(String did, LocalDate dateAppoint) {
		loggr.info("findAvailableDoctor is working");
		try {
			DoctorBean doctorBean;
			cnn=DBUtilImpl.getDBConnection("jdbc");
			pstmt=cnn.prepareStatement("select ocs_tbl_doctor.* from ocs_tbl_doctor left join  ocs_tbl_leave on  ocs_tbl_leave.doctorid=ocs_tbl_doctor.doctorid where (leave_to is null or cast('"+dateAppoint+"' as date) not  between leave_from and leave_to) and ocs_tbl_doctor.doctorid='"+did+"'");
			rs=pstmt.executeQuery();
			if(rs.next())
			{
			 doctorBean=new DoctorBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15));
				return doctorBean;
			}
			
		}
		catch(SQLException s)
		{
			System.out.println("Exception in patient Dao findAvailable doctor"+s);
			
			
		}
		return null;

	}
	
	

}
