package com.niit.ocs.bean;

import java.time.LocalDate;

import com.niit.ocs.service.impl.DoctorBeanServiceImpl;


public class DoctorBean {

	DoctorBeanServiceImpl doctorBeanService=new DoctorBeanServiceImpl();
	private String doctorID;
	private String doctorName;
	private String dateOfBirth;
	private String dateOfJoining;
	private String gender;  
	private String qualification;  
	private String specialization;  
	private String yearsOfExperience;
	private String street;
	private String location; 
	/**
	 * @param doctorBeanService
	 * @param doctorID
	 * @param doctorName
	 * @param dateOfBirth
	 * @param dateOfJoining
	 * @param gender
	 * @param qualification
	 * @param specialization
	 * @param yearsOfExperience
	 * @param street
	 * @param location
	 * @param city
	 * @param state
	 * @param pincode
	 * @param contactNumber
	 * @param emailID
	 */
	
	
	public DoctorBean( String doctorID, String doctorName, String dateOfBirth,
			String dateOfJoining, String gender, String qualification, String specialization, String yearsOfExperience,
			String street, String location, String city, String state, String pincode, String contactNumber,
			String emailID) {
		super();
		
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.gender = gender;
		this.qualification = qualification;
		this.specialization = specialization;
		this.yearsOfExperience = yearsOfExperience;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.contactNumber = contactNumber;
		this.emailID = emailID;
	}
	private String city;
	private String state;  
	private String pincode;  
	private String contactNumber;  
	private String emailID;
	/**
	 * @return the doctorID
	 */
	public String getDoctorID() {
		return doctorID;
	}
	/**
	 * @param doctorID the doctorID to set
	 */
	public void setDoctorID() {
		
		
		this.doctorID = doctorBeanService.generateUserID(doctorName);
	}
	/**
	 * @return the doctorName
	 */
	public String getDoctorName() {
		return doctorName;
	}
	/**
	 * @param doctorName the doctorName to set
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the dateOfJoining
	 */
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}
	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	/**
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}
	/**
	 * @param specialization the specialization to set
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	/**
	 * @return the yearsOfExperience
	 */
	public String getYearsOfExperience() {
		return yearsOfExperience;
	}
	/**
	 * @param yearsOfExperience the yearsOfExperience to set
	 */
	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * 
	 */
	public DoctorBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}
	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	/**
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}
	/**
	 * @param emailID the emailID to set
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	
	
	
}
