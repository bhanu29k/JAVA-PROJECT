/**
 * 
 */
package com.niit.ocs.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.bean.LeaveBean;
import com.niit.ocs.dao.DoctorDao;
import com.niit.ocs.dao.ReporterDao;
import com.niit.ocs.dao.impl.DoctorDaoImpl;
import com.niit.ocs.dao.impl.ReporterDaoImpl;
import com.niit.ocs.service.ReporterService;

/**
 * @author Training
 *
 */
public class ReporterServiceImpl implements ReporterService {
	static Logger loggr=Logger.getLogger(ReporterServiceImpl.class);
	ReporterDao reporterDao;
	DoctorDao doctorDao;
	
	
	
	/**
	 * @param reporterDao
	 */
	public ReporterServiceImpl(ReporterDao reporterDao) {
		super();
		this.reporterDao = reporterDao;
	}

	/**
	 * @param doctorDao
	 */
	public ReporterServiceImpl(DoctorDao doctorDao) {
		super();
		this.doctorDao = doctorDao;
	}

	/**
	 * 
	 */
	public ReporterServiceImpl() {
		super();
		reporterDao=new ReporterDaoImpl();
		doctorDao=new DoctorDaoImpl();
		}

	@Override
	public boolean checkValidReporterId(String id) {
		loggr.info("checkValidReporterId is working");
		if(reporterDao.findById(id)!=null)
			return true;
		return false;
	} 

	@Override
	public boolean checkValidReporterName(String name) {
		loggr.info("checkValidReporterName is working");
		if(Pattern.matches("[A-Z][a-z]{0,20}",name))
		{
			return true;
		}
		return false;
		
	}

	@Override
	public boolean checkValidDoctorId(String name) {
		loggr.info("checkValidDoctorId is working");
		if(doctorDao.findByID(name)!=null)
			return true;
		return false;
	}

	@Override
	public boolean checkValidLeaveFrom(String date) {
		loggr.info("checkValidLeaveFrom is working");
		if(Pattern.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((19|2[0-9])[0-9]{2})$",date))
		{
			return true;
		}
		return false;
		
	}

	@Override
	public boolean checkValidLeaveTo(String date) {
		loggr.info("checkValidLeaveTo is working");
		if(Pattern.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((19|2[0-9])[0-9]{2})$",date))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String generateLeaveId()
	{
		loggr.info("generateLeaveId is working");
		 int x = (int)(Math.random()*((9999-1000)+1))+1000;
		 String str=Integer.toString(x);
		char a[]= {str.charAt(0),str.charAt(1),str.charAt(2),str.charAt(3)};
		String Id=new String(a);
		
		//System.out.println(Id);
		return Id;
	}

	@Override
	public String addLeave(LeaveBean leaveBean) {
		loggr.info("addLeave is working");
		return reporterDao.createLeave(leaveBean);
	}

	@Override
	public ArrayList<DoctorBean> viewAllAvailableDoctors(LocalDate availDate) {
		loggr.info("viewAllAvailableDoctors is working");
		return reporterDao.findDoctorByDate(availDate);
	}
	

}
