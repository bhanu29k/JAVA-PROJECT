/**
 * 
 */
package com.niit.ocs.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.bean.LeaveBean;

/**
 * @author Training
 *
 */
public interface ReporterService {
	public boolean  checkValidReporterId(String id);
	public boolean  checkValidReporterName(String name);
	public boolean  checkValidDoctorId(String name);
	public boolean  checkValidLeaveFrom(String date);
	public boolean  checkValidLeaveTo(String date);
	public String generateLeaveId();
	public String addLeave(LeaveBean leaveBean);
	public ArrayList<DoctorBean> viewAllAvailableDoctors(LocalDate availDate);
	
	
	
	
	
	
}
