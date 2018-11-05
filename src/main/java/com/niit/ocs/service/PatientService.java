package com.niit.ocs.service;

import java.util.regex.Pattern;

import com.niit.ocs.bean.PatientBean;

public interface PatientService {
	

public boolean  checkValidName(String name);

public boolean  checkValidPincode(String pincode);

public boolean  checkValidMobileNo(String mobileNo);

public boolean  checkValidEmailID(String emailID);

public boolean checkValidPassword(String password);

public boolean checkValidDateOfBirth(String dob);

public String generateUserID(String firstName);

public String addAilmentDetails(PatientBean patientBean);


}
