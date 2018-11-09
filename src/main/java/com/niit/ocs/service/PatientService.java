package com.niit.ocs.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.niit.ocs.bean.DoctorBean;
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

public ArrayList<PatientBean> viewAllAilmentDetails();

public PatientBean viewAilmentDetails(String patientID);

public boolean modifyAilmentDetails(PatientBean patientBean);
public ArrayList<DoctorBean> viewListOfDoctors(String special, LocalDate dateAppoint);
public DoctorBean viewAvailableDoctor(String did, LocalDate dateAppoint);
String requestForAppointment(String did, LocalDate dateAppoint, String pId);

boolean checkValidAppointmentDate(String date);

}
