/**
 * 
 */
package com.niit.ocs.service.impl;

import java.util.ArrayList;

import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.dao.DoctorDao;
import com.niit.ocs.dao.impl.DoctorDaoImpl;
import com.niit.ocs.service.Administrator;


/**
 * @author Training
 *
 */
public class AdministratorImpl implements Administrator {
DoctorDao doctorDao;
	
	
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



	public String addDoctor(DoctorBean doctorBean) {
					
	if(doctorDao.createDoctor(doctorBean)=="success")
	{
		return "SUCCESS";
	}
	else return "FAIL";
		 
	}

	
	public boolean modifyDoctor(DoctorBean doctorBean) {
		
		if(doctorDao.updateDoctor(doctorBean))
		{
			return true;
		}
		else 
		return false;
	}



	@Override
	public ArrayList<DoctorBean> viewAllDoctors() {
		
		return doctorDao.findAll();
	}



	@Override
	public int removeDoctor(String id) {
		ArrayList<String> al=new ArrayList<String>();
		String ids[]=id.split(" ");
		for(String i:ids)
		{
			al.add(i);
		}
		doctorDao.deleteDoctor(al);
		return 0;
	}

}
