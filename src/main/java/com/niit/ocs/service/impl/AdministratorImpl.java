/**
 * 
 */
package com.niit.ocs.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.dao.DoctorDao;
import com.niit.ocs.dao.impl.DoctorDaoImpl;
import com.niit.ocs.service.Administrator;
import com.niit.ocs.util.Authentication;


/**
 * @author Training
 *
 */
public class AdministratorImpl implements Administrator {
DoctorDao doctorDao;
	
static Logger loggr=Logger.getLogger(AdministratorImpl.class);
	/**
 * @param doctorDao
 */
public AdministratorImpl(DoctorDao doctorDao) {
	super();
	this.doctorDao = doctorDao;
}



	/**
	 * 
	 */
	public AdministratorImpl() {
		super();
		doctorDao=new DoctorDaoImpl();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String addDoctor(DoctorBean doctorBean) {
					
		loggr.info("addDoctor is working");
	if(doctorDao.createDoctor(doctorBean)=="success")
	{
		return "SUCCESS";
	}
	else return "FAIL";
		 
	}

	@Override
	public boolean modifyDoctor(DoctorBean doctorBean) {
		loggr.info("modifyDoctor is working");
		if(doctorDao.updateDoctor(doctorBean))
		{
			return true;
		}
		else 
		return false;
	}



	@Override
	public ArrayList<DoctorBean> viewAllDoctors() {
		loggr.info("viewAllDoctor is working");
		return doctorDao.findAll();
	}



	@Override
	public int removeDoctor(String id) {
		loggr.info("removeDoctor is working");
		ArrayList<String> al=new ArrayList<String>();
		String ids[]=id.split(" ");
		for(String i:ids)
		{
			al.add(i);
		}
		return doctorDao.deleteDoctor(al);
		
	}



	@Override
	public ArrayList<DoctorBean> suggestDoctors(String pid, LocalDate appointDate) {
		loggr.info("suggestDoctors is working");
		return doctorDao.findByPatientIdAndAppointDate(pid,appointDate);
		
	}

}
