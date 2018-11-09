/**
 * 
 */
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

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.bean.LeaveBean;
import com.niit.ocs.bean.PatientBean;
import com.niit.ocs.dao.ReporterDao;
import com.niit.ocs.util.impl.DBUtilImpl;

/**
 * @author Training
 *
 */
public class ReporterDaoImpl implements ReporterDao {
	
	static Logger loggr=Logger.getLogger(ReporterDaoImpl.class);
	static Connection cnn;
	static Statement stmt;
	static PreparedStatement pstmt;
	static ResultSet rs;
	

	@Override
	public CredentialsBean findById(String id) {
		loggr.info("findById is working");
try {
			cnn=DBUtilImpl.getDBConnection("jdbc");
			stmt=cnn.createStatement();
		      rs=stmt.executeQuery("select  * from ocs_tbl_user_credentials  where userid='"+id+"'");
		      if(rs.next())
				{	
					 return (new CredentialsBean());
				}
		      
				//else return null;
		      
		}
		
		   catch(SQLException s)
		   {
			   System.out.println("Exception in reporter dao findbyid"+s);
			  // return null;
		   }
		return null;


	}

	@Override
	public String createLeave(LeaveBean leaveBean) {
		loggr.info("createLeave is working");
		try {
			cnn=DBUtilImpl.getDBConnection("jdbc");
			String query="insert into ocs_tbl_leave(leaveid,doctorid,leave_from,leave_to,reason,status) "+" values(?,?,?,?,?,?)";
			pstmt=cnn.prepareStatement(query);
			pstmt.setString(1,leaveBean.getLeaveId());
			pstmt.setString(2,leaveBean.getDoctorId());
			pstmt.setDate(3,Date.valueOf(leaveBean.getLeaveFrom()));
			pstmt.setDate(4,Date.valueOf(leaveBean.getLeaveTo()));
			pstmt.setString(5,leaveBean.getReason());
			pstmt.setInt(6,leaveBean.getStatus());
			pstmt.execute();
			return "SUCCESS";
			
			}
			catch(SQLException s)
			   {
				   System.out.println("SQL Exception in reporterDao create"+s);
				   return "FAIL";
			   }


	}

	@Override
	public ArrayList<DoctorBean> findDoctorByDate(LocalDate availDate) {
		loggr.info("findDoctorByDate is working");
		try {
			ArrayList<DoctorBean> doctor=new ArrayList<DoctorBean>();
			cnn=DBUtilImpl.getDBConnection("jdbc");
			pstmt=cnn.prepareStatement("select ocs_tbl_doctor.* from ocs_tbl_doctor left join  ocs_tbl_leave on  ocs_tbl_leave.doctorid=ocs_tbl_doctor.doctorid where  leave_to is null or cast('"+availDate+"' as date) not  between leave_from and leave_to");
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

}
