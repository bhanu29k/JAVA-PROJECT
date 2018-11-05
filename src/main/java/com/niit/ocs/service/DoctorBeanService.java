/**
 * 
 */
package com.niit.ocs.service;

import java.util.regex.Pattern;

/**
 * @author Training
 *
 */
public interface DoctorBeanService {


		public boolean checkValidName(String name);
		public boolean  checkValidPincode(String pincode);

		public boolean  checkValidMobileNo(String mobileNo);

		public boolean  checkValidEmailID(String emailI);

		public boolean checkValidDateOfBirth(String dob);

		
		public boolean checkValidDateOfJoining(String doj);
		
		public String generateUserID(String firstName);
	
}
