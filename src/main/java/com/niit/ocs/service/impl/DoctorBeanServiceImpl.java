/**
 * 
 */
package com.niit.ocs.service.impl;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.niit.ocs.service.DoctorBeanService;

/**
 * @author Training
 *
 */
public class DoctorBeanServiceImpl implements DoctorBeanService {
	static Logger loggr=Logger.getLogger(DoctorBeanServiceImpl.class);
	
	public boolean checkValidName(String name)
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

	
	public boolean checkValidDateOfBirth(String dob)
	{
		loggr.info("checkValidDateOfBirth is working");
		if(Pattern.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",dob))
		{
			return true;
		}
		return false;
	}

	
	public boolean checkValidDateOfJoining(String doj)
	{
		loggr.info("checkValidDateOfJoining is working");
		if(Pattern.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",doj))
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

	
}
