package com.niit.ocs.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.niit.ocs.bean.PatientBean;
import com.niit.ocs.bean.ProfileBean;
import com.niit.ocs.dao.PatientDao;
import com.niit.ocs.util.impl.DBUtilImpl;

public class PatientDaoImpl implements PatientDao{
	static Connection cnn;
	static Statement stmt;
	static PreparedStatement pstmt;
	static ResultSet rs;

	public String createPatient(PatientBean patientBean) {
		
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
				   System.out.println("SQL Exception in patientDaoImpl  create patient"+s);
				   return "FAIL";
			   }

	}

}
