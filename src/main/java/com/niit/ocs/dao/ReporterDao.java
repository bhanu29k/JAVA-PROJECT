/**
 * 
 */
package com.niit.ocs.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.bean.LeaveBean;

/**
 * @author Training
 *
 */
public interface ReporterDao {

	public CredentialsBean findById(String id);

	public String createLeave(LeaveBean leaveBean);

	public ArrayList<DoctorBean> findDoctorByDate(LocalDate availDate);

}
