package com.niit.ocs.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.bean.PatientBean;
import com.niit.ocs.dao.PatientDao;
import com.niit.ocs.dao.impl.PatientDaoImpl;
import com.niit.ocs.service.PatientService;
import com.niit.ocs.service.ReporterService;

public class PatientServiceImpl implements PatientService {
	static Logger loggr=Logger.getLogger(PatientServiceImpl.class);
	PatientDao patientDao;
	ReporterService reporterService;
	PatientService patientService;
	//PatientService patientService;
	
	
	/**
	 * 
	 */
	public PatientServiceImpl() {
		super();
		patientDao=new PatientDaoImpl();
		reporterService=new ReporterServiceImpl();
		
		
	}
	
	

	/**
	 * @param patientDao
	 * @param patientService
	 */
	public PatientServiceImpl(PatientDao patientDao, PatientService patientService) {
		super();
		this.patientDao = patientDao;
		this.patientService = patientService;
	}



	/**
	 * @param patientDao
	 */
	public PatientServiceImpl(PatientDao patientDao) {
		super();
		this.patientDao = patientDao;
	}



	@Override
	public boolean  checkValidName(String name)
	{
		loggr.info("checkValidName is working");
	if(Pattern.matches("[A-Z][a-z]{0,20}",name))
	{
		return true;
	}
	return false;
	 
}

	
public boolean  checkValidPincode(String pincode)
{
	loggr.info("checkValidPincode is working");
	if(Pattern.matches("[1-9][0-9]{5}",pincode))
	{
		return true;
	}
	return false;
	 
}

	
public boolean  checkValidMobileNo(String mobileNo)
{
	loggr.info("checkValidMobileNo is working");
	if(Pattern.matches("[6-9][0-9]{9}",mobileNo))
	{
		return true;
	}
	return false;
	 
}

	
public boolean  checkValidEmailID(String emailID)
{
	loggr.info("checkValidEmailID is working");
	if(Pattern.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$",emailID))
	{
		return true;
	}
	return false;
	 
}

	
public boolean checkValidPassword(String password)
{
	loggr.info("checkValidPassword is working");
	if(Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",password))
	{
		return true;
	}
	return false;
}

	
public boolean checkValidDateOfBirth(String dob)
{
	
	if(Pattern.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",dob))
	{
		return true;
	}
	return false;
}

@Override
public boolean checkValidAppointmentDate(String date) {
	
	if(Pattern.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((19|2[0-9])[0-9]{2})$",date))
	{
		return true;
	}
	return false;
	
}

	
public String generateUserID(String firstName)
{
	loggr.info("generateUserID is working");
	 int x = (int)(Math.random()*((9999-1000)+1))+1000;
	 String str=Integer.toString(x);
	char a[]= {firstName.charAt(0),firstName.charAt(1),str.charAt(0),str.charAt(1),str.charAt(2),str.charAt(3)};
	String Id=new String(a);
	
	//System.out.println(Id);
	return Id;
}


@Override
public String addAilmentDetails(PatientBean patientBean) {
	loggr.info("addAilmentDetails is working");
	String result=patientDao.createPatient(patientBean);
	return result; 
}

@Override
public ArrayList<PatientBean> viewAllAilmentDetails() {
	loggr.info("viewAllAilmentDetails is working");
	return patientDao.findAll();
	
}


@Override
public PatientBean viewAilmentDetails(String patientID) {
	loggr.info("viewAilmentDetails is working");
	return patientDao.findByID(patientID);
}

@Override
public boolean modifyAilmentDetails(PatientBean patientBean) {
	loggr.info("modifyAilmentDetails is working");
	return patientDao.updatePatient(patientBean);
	
}

@Override
public ArrayList<DoctorBean> viewListOfDoctors(String special, LocalDate dateAppoint) {
	loggr.info("viewListOfDoctors working");
	return patientDao.findDoctors(special,dateAppoint);
	
}


@Override
public String requestForAppointment(String did, LocalDate dateAppoint,String pId) {
	/*Scanner sc=new Scanner(System.in);
	ArrayList<DoctorBean> arrList=new ArrayList<DoctorBean>();
	System.out.println("enter the specialization you want");
	String special=sc.nextLine();
	arrList=viewListOfDoctors(special,dateAppoint);
	if(arrList!=null && arrList.size()>=2)
	*/
	loggr.info("requestForAppointment is working");
	if(patientService.viewAvailableDoctor(did,dateAppoint)!=null)
	return patientDao.createRequest(did,dateAppoint,pId);
	return "FAIL";
/*	else if(arrList!=null && arrList.size()<2)
		return "PENDING";
	else return "FAIL";
	*/
}

@Override
public DoctorBean viewAvailableDoctor(String did, LocalDate dateAppoint) {
	loggr.info("viewAvailableDoctor is working");
	return patientDao.findAvaiableDoctor(did,dateAppoint);
	
}


}
