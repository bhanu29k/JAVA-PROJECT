package com.niit.ocs.bean;

import java.time.LocalDate;

public class PatientBean {
private String patientID;
private LocalDate appointmentDate;
private String ailmentType;
private String ailmentDetails;
private String diagnosishistory;
private String userID;
/**
 * @param patientID
 * @param appointmentDate
 * @param ailmentType
 * @param ailmentDetails
 * @param diagnosishistory
 */
public PatientBean(String patientID,String userID, LocalDate appointmentDate, String ailmentType, String ailmentDetails,
		String diagnosishistory) {
	super();
	this.userID=userID;
	this.patientID = patientID;
	this.appointmentDate = appointmentDate;
	this.ailmentType = ailmentType;
	this.ailmentDetails = ailmentDetails;
	this.diagnosishistory = diagnosishistory;
}
/**
 * 
 */
public PatientBean() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * @return the patientID
 */
public String getPatientID() {
	return patientID;
}
/**
 * @param patientID the patientID to set
 */
public void setPatientID(String patientID) {
	this.patientID = patientID;
}
/**
 * @return the userID
 */
public String getUserID() {
	return userID;
}
/**
 * @param userID the userID to set
 */
public void setUserID(String userID) {
	this.userID = userID;
}
/**
 * @return the appointmentDate
 */
public LocalDate getAppointmentDate() {
	return appointmentDate;
}
/**
 * @param appointmentDate the appointmentDate to set
 */
public void setAppointmentDate(LocalDate appointmentDate) {
	this.appointmentDate = appointmentDate;
}
/**
 * @return the ailmentType
 */
public String getAilmentType() {
	return ailmentType;
}
/**
 * @param ailmentType the ailmentType to set
 */
public void setAilmentType(String ailmentType) {
	this.ailmentType = ailmentType;
}
/**
 * @return the ailmentDetails
 */
public String getAilmentDetails() {
	return ailmentDetails;
}
/**
 * @param ailmentDetails the ailmentDetails to set
 */
public void setAilmentDetails(String ailmentDetails) {
	this.ailmentDetails = ailmentDetails;
}
/**
 * @return the diagnosishistory
 */
public String getDiagnosishistory() {
	return diagnosishistory;
}
/**
 * @param diagnosishistory the diagnosishistory to set
 */
public void setDiagnosishistory(String diagnosishistory) {
	this.diagnosishistory = diagnosishistory;
}




}
