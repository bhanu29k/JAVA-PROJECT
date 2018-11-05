package com.niit.ocs.service.impl;

import java.util.regex.Pattern;

import com.niit.ocs.bean.PatientBean;
import com.niit.ocs.dao.PatientDao;
import com.niit.ocs.dao.impl.PatientDaoImpl;
import com.niit.ocs.service.PatientService;

public class PatientServiceImpl implements PatientService {
	
	PatientDao patientDao;
	
	
	
	
	/**
	 * 
	 */
	public PatientServiceImpl() {
		super();
		patientDao=new PatientDaoImpl();
	}


	public boolean  checkValidName(String name)
	{
	if(Pattern.matches("[A-Z][a-z]{0,20}",name))
	{
		return true;
	}
	return false;
	 
}

	
public boolean  checkValidPincode(String pincode)
{
	if(Pattern.matches("[1-9][0-9]{5}",pincode))
	{
		return true;
	}
	return false;
	 
}

	
public boolean  checkValidMobileNo(String mobileNo)
{
	if(Pattern.matches("[6-9][0-9]{9}",mobileNo))
	{
		return true;
	}
	return false;
	 
}

	
public boolean  checkValidEmailID(String emailID)
{
	if(Pattern.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$",emailID))
	{
		return true;
	}
	return false;
	 
}

	
public boolean checkValidPassword(String password)
{
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


	
public String generateUserID(String firstName)
{
	 int x = (int)(Math.random()*((9999-1000)+1))+1000;
	 String str=Integer.toString(x);
	char a[]= {firstName.charAt(0),firstName.charAt(1),str.charAt(0),str.charAt(1),str.charAt(2),str.charAt(3)};
	String Id=new String(a);
	
	//System.out.println(Id);
	return Id;
}


@Override
public String addAilmentDetails(PatientBean patientBean) {
	patientDao.createPatient(patientBean);
	return null; 
}

}
