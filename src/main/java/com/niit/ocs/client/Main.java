package com.niit.ocs.client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.bean.PatientBean;
import com.niit.ocs.bean.ProfileBean;
import com.niit.ocs.dao.DoctorDao;
import com.niit.ocs.dao.impl.DoctorDaoImpl;
import com.niit.ocs.service.Administrator;
import com.niit.ocs.service.impl.AdministratorImpl;
import com.niit.ocs.service.impl.DoctorBeanServiceImpl;
import com.niit.ocs.service.impl.PatientServiceImpl;
import com.niit.ocs.util.User;
import com.niit.ocs.util.impl.UserImpl;

public class Main {
	
	
	public static void main(String[] args) {
		User UserObj=new UserImpl();
		PatientServiceImpl patientService=new PatientServiceImpl();
		CredentialsBean credentialsBean=new CredentialsBean(null,null);
		ProfileBean profileBean=new ProfileBean();
		DoctorBean  doctorBean=new DoctorBean();
		DoctorBeanServiceImpl doctorBeanService=new DoctorBeanServiceImpl();
		DoctorDao doctorDao=new DoctorDaoImpl();
		Administrator administrator=new AdministratorImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Are you an Admin/Reporter/Patient(Enter A for Admin, R for Reporter, P for Patient)");
		char askUser=sc.next().charAt(0);  
		if(askUser=='A')
		{
			
			
			System.out.println("Enter User Id");
			sc.nextLine();
			credentialsBean.setUserID(sc.nextLine());
			
			System.out.println("Enter password");
			credentialsBean.setPassword(sc.nextLine());
			
			//System.out.println(credentialsBean.getUserID());
			String str=UserObj.login(credentialsBean);
			
			if(str.equals("A") || str.equals("R") || str.equals("P"))
			System.out.println("\nSuccessfully Login. type of user is: "+str);
			
			else System.out.println(str);
			// PASSWORD CHANGE-----------------------------------------------------------------------------------
			
			
			if(str.equals("A"))
			{
			System.out.println("\nDo you want to change your password? enter Y for yes and N for no");
			char askForPasswordChange=sc.next().charAt(0);
			sc.nextLine();
			if(askForPasswordChange=='Y')
			{
				
				
				boolean run=true;
				
				while(run)
				{	
					System.out.println("Enter new password (Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character) ");
					String password=sc.nextLine();
					
				if(patientService.checkValidPassword(password))
				{
					run=false;
					credentialsBean.setPassword(password);
				}
				else
				{
					System.out.println("wrong format, please enter password again");
					run=true;
				}
				
				}
				
				System.out.println(UserObj.changePassword(credentialsBean,credentialsBean.getPassword()));
			}
			
			
			
			}
			
			
			// ADD DOCTOR---------------------------------------------------------------------------------
			
			
			if(str.equals("A")) {
				System.out.println("want  to add doctor? Enter Y for yes and N for no");
				char askAdmin=sc.next().charAt(0);
				if(askAdmin=='Y')
				{
					
					sc.nextLine();
		
					boolean run=true;
					while(run)
					{	
						System.out.println("Enter doctor name (minimum 1 character maximum 20 character starting with capital letter and contains only alphanumeric characters)");
						String nameTemp=sc.nextLine();
						
					if(doctorBeanService.checkValidName(nameTemp))
					{
						run=false;
						doctorBean.setDoctorName(nameTemp);
					}
					else
					{
						System.out.println("wrong format, please enter doctor name again");
						run=true;
					}
					
					}
					
					
					doctorBean.setDoctorID();
					
					
					run=true;
					
					while(run)
					{	
						System.out.println("Enter DOB (format is YYYY-MM-DD)");
						String dob=sc.nextLine();
						
					if(doctorBeanService.checkValidDateOfBirth(dob))
					{
						run=false;
						doctorBean.setDateOfBirth(dob);
					}
					else
					{
						System.out.println("wrong format, please enter DOB again");
						run=true;
					}
					
					}
					
					
					
					run=true;
					
					while(run)
					{	
						System.out.println("Enter date of joining (format is YYYY-MM-DD)");
						String doj=sc.nextLine();
						
					if(doctorBeanService.checkValidDateOfJoining(doj))
					{
						run=false;
						doctorBean.setDateOfJoining(doj);
					}
					else
					{
						System.out.println("wrong format, please enter DOJ again");
						run=true;
					}
					
					}
					
					
					
					
					System.out.println("Enter gender (Male/Female) ");
					doctorBean.setGender(sc.nextLine());
					        
					System.out.println("Enter qualification");
					doctorBean.setQualification(sc.nextLine());
					
					System.out.println("Enter specialization ");
					doctorBean.setSpecialization(sc.nextLine());
					
					System.out.println("Enter years of experience ");
					doctorBean.setYearsOfExperience(sc.nextLine());
					
					System.out.println("Enter Street ");
					doctorBean.setStreet(sc.nextLine());
					
					System.out.println("Enter location ");
					doctorBean.setLocation(sc.nextLine());
					
					System.out.println("Enter city ");
					doctorBean.setCity(sc.nextLine());
					
					System.out.println("Enter state ");
					doctorBean.setState(sc.nextLine());
					
					run=true;
					while(run)
					{	
						System.out.println("Enter Pincode (6 digits long)");
						String pincode=sc.nextLine();
						
					if(doctorBeanService.checkValidPincode(pincode))
					{
						run=false;
						doctorBean.setPincode(pincode);
					}
					else
					{
						System.out.println("wrong format, please enter pincode again");
						run=true;
					}
					}

					run=true;
					while(run)
					{	
						System.out.println("Enter Mobile No (10 digits long and starting with (6-9))");
						String mobileNo=sc.nextLine();
						
					if(doctorBeanService.checkValidMobileNo(mobileNo))
					{
						run=false;
						doctorBean.setContactNumber(mobileNo);
					}
					else
					{
						System.out.println("wrong format, please enter mobile no again");
						run=true;
					}
					}
					
				
					run=true;
					while(run)
					{	
						System.out.println("Enter Email Id ");
						String emailID=sc.nextLine();
						
					if(doctorBeanService.checkValidEmailID(emailID))
					{
						run=false;
						doctorBean.setEmailID(emailID);
					}
					else
					{
						System.out.println("wrong format, please enter Email ID again");
						run=true;
					}
					
					}

					// ADD DOCTOR
					
					System.out.println(administrator.addDoctor(doctorBean));
				
				}
				
			}
			
			
			// MODIFY DOCTOR------------------------------------------------------------------------------------
			
			
			if(str.equals("A")) {
				boolean op=true;
				while(op)
				{
				System.out.println("want  to Modify doctor? Enter Y for yes and N for no");
				char askAdmin=sc.next().charAt(0);
				if(askAdmin=='Y')
				{
					sc.nextLine();
					System.out.println("enter the doctor id which you want to modify");
					String did=sc.nextLine();
					DoctorBean d=new DoctorBean();
					d=doctorDao.findByID(did);
					
					if(d!=null)
					{
					  System.out.println("what do you want to modify (Enter 1 for name, 2 for dob, 3 for doj, 4 for gender, 5 for qualification, 6 for specialization, 7 for years of experience, 8 for street, 9 for location, 10 for city, 11 for state, 12 for pincode, 13 for contact number, 14 for emailid )");
					   int askForModify=sc.nextInt();
					   sc.nextLine();
					   switch(askForModify)
					   {
					   case 1:
						   
							
							boolean run=true;
							while(run)
							{	
								System.out.println("Enter doctor name (minimum 1 character maximum 20 character starting with capital letter and contains only alphanumeric characters)");
								String nameTemp=sc.nextLine();
								
							if(doctorBeanService.checkValidName(nameTemp))
							{
								run=false;
								d.setDoctorName(nameTemp);
							}
							else
							{
								System.out.println("wrong format, please enter doctor name again");
								run=true;
							}
							
							}
							break;
					   case 2:
						   
						   run=true;
							
							while(run)
							{	
								System.out.println("Enter DOB (format is YYYY-MM-DD)");
								String dob=sc.nextLine();
								
							if(doctorBeanService.checkValidDateOfBirth(dob))
							{
								run=false;
								d.setDateOfBirth(dob);
							}
							else
							{
								System.out.println("wrong format, please enter DOB again");
								run=true;
							}
							
							}
							break;
					   case 3:
						   
						   run=true;
							
							while(run)
							{	
								System.out.println("Enter date of joining (format is YYYY-MM-DD)");
								String doj=sc.nextLine();
								
							if(doctorBeanService.checkValidDateOfJoining(doj))
							{
								run=false;
								d.setDateOfJoining(doj);
							}
							else
							{
								System.out.println("wrong format, please enter DOJ again");
								run=true;
							}
							
							}
						break;
						
					   case 4:
						   System.out.println("Enter gender (Male/Female) ");
							d.setGender(sc.nextLine());
							break;
							
					   case  5:
							System.out.println("Enter qualification");
							d.setQualification(sc.nextLine());
							break;
						
					   case 6:
						   System.out.println("Enter specialization ");
							d.setSpecialization(sc.nextLine());
							break;
							
					   case 7:
						   System.out.println("Enter years of experience ");
							d.setYearsOfExperience(sc.nextLine());
							break;
							
					   case 8:
						   System.out.println("Enter Street ");
							d.setStreet(sc.nextLine());
							break;
							
					   case 9:
							System.out.println("Enter location ");
							d.setLocation(sc.nextLine());
							break;
							
					   case 10:
						   System.out.println("Enter city ");
							d.setCity(sc.nextLine());
							break;
							
					   case 11:
						   System.out.println("Enter state ");
							d.setState(sc.nextLine());
							break;
						
					   case 12:
						   run=true;
							while(run)
							{	
								System.out.println("Enter Pincode (6 digits long)");
								String pincode=sc.nextLine();
								
							if(doctorBeanService.checkValidPincode(pincode))
							{
								run=false;
								d.setPincode(pincode);
							}
							else
							{
								System.out.println("wrong format, please enter pincode again");
								run=true;
							}
							}
							break;
							
					   case 13:
						   run=true;
							while(run)
							{	
								System.out.println("Enter Mobile No (10 digits long and starting with (6-9))");
								String mobileNo=sc.nextLine();
								
							if(doctorBeanService.checkValidMobileNo(mobileNo))
							{
								run=false;
								d.setContactNumber(mobileNo);
							}
							else
							{
								System.out.println("wrong format, please enter mobile no again");
								run=true;
							}
							}
						break;
						
					   case  14:

							run=true;
							while(run)
							{	
								System.out.println("Enter Email Id ");
								String emailID=sc.nextLine();
								
							if(doctorBeanService.checkValidEmailID(emailID))
							{
								run=false;
								d.setEmailID(emailID);
							}
							else
							{
								System.out.println("wrong format, please enter Email ID again");
								run=true;
							}
							
							}
							break;
						   
						default:
							System.out.println("please enter correct details");
							break;
						  
						   
					   } 
					   
									
					// MODIFY DOCTOR
					   
						
						 administrator.modifyDoctor(d);
					   
					   
					//System.out.println(administrator.addDoctor(doctorBean));
				
				}
				
					else System.out.println("enter correct Doctor ID");	
				}
				System.out.println("Do you want to do more operation enter Y for yes, else any key for No");
				char ask=sc.next().charAt(0);
				if(ask=='Y')
				{
					
					op=true;
				}
				else 
					op=false;
				}
				
				
			}
			
			
			// VIEW ALL DOCTORS
			
			if(str.equals("A"))
			{
				System.out.println("do you want to see all doctors Y/N");
				char askAdmin=sc.next().charAt(0);
				if(askAdmin=='Y')
				{
					ArrayList<DoctorBean> arrlst=administrator.viewAllDoctors();
					for(DoctorBean i:arrlst)
					{
						System.out.println(i.getDoctorID()+" "+i.getDoctorName()+" "+i.getDateOfBirth()+" "+i.getDateOfJoining()+" "+i.getGender()+" "+i.getQualification()+" "+i.getSpecialization()+" "+i.getYearsOfExperience()+" "+i.getStreet()+" "+i.getLocation()+" "+i.getCity()+" "+i.getState()+" "+i.getPincode()+" "+i.getContactNumber()+" "+i.getEmailID());
						System.out.println("\n");
					}
				}
				
			}
			
			 
			// DELETE DOCTOR
			
			if(str.equals("A"))
			{
				System.out.println("do you want to delete doctors Y/N");
				char askAdmin=sc.next().charAt(0); 
				if(askAdmin=='Y')
				{
					sc.nextLine();
					System.out.println("enter the doctor ids you want to delete");
					String id=sc.nextLine();
					int res=administrator.removeDoctor(id);
					
				}
			}
			
			
			
			// LOG OUT-------------------------------------------------------------------------------------------
			
			if(str.equals("A"))
			{
			System.out.println("want  to logout? Enter Y for yes and N for no");
			char askAdmin=sc.next().charAt(0);
			if(askAdmin=='Y')
			{
			if(UserObj.logout(credentialsBean.getUserID()))
			{
				System.out.println("successfully logout");
			}
			else System.out.println("problem with logout");
			}
			}
			
			
			
		}
		else if(askUser=='R')
		{
			
			
			System.out.println("Enter User Id");
			credentialsBean.setUserID(sc.nextLine());
			
			System.out.println("Enter password");
			credentialsBean.setPassword(sc.nextLine());
			
		}
		else if(askUser=='P')
		{
			System.out.println("Are you an existing user(Enter Y for yes And N for no)");
			char askPatient=sc.next().charAt(0);
			if(askPatient=='Y')
			{
				  
				System.out.println("Enter User Id");
				sc.nextLine();
				credentialsBean.setUserID(sc.nextLine());
				
				System.out.println("Enter password");
				credentialsBean.setPassword(sc.nextLine());
				
				String str=UserObj.login(credentialsBean);
				System.out.println(str);
				
				if(str.equals("A") || str.equals("P") || str.equals("R"))
				{
				System.out.println("Do you want to change your password? enter Y for yes and N for no");
				char askForPasswordChange=sc.next().charAt(0);
				sc.nextLine();
				if(askForPasswordChange=='Y')
				{
					
					
					boolean run=true;
					
					while(run)
					{	
						System.out.println("Enter new password (Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character) ");
						String password=sc.nextLine();
						
					if(patientService.checkValidPassword(password))
					{
						run=false;
						credentialsBean.setPassword(password);
					}
					else
					{
						System.out.println("wrong format, please enter password again");
						run=true;
					}
					
					}
					
					System.out.println(UserObj.changePassword(credentialsBean,credentialsBean.getPassword()));
				}
				}
				
				// ADD AILMENT DETAILS
				System.out.println("want to add ailment details Y/N");
				char askPatientForAilment=sc.next().charAt(0);
				if(askPatientForAilment=='Y')
				{
					sc.nextLine();
					System.out.println("enter user id");
					String uId=sc.nextLine();
					System.out.println("enter patient id");
					String pId=sc.nextLine();
					System.out.println("\n");
					System.out.println("enter appointment date  dd/mm/yyyy");
					String appointmentDate=sc.nextLine();
					String date[]=appointmentDate.split("/");
					LocalDate dateAppoint=LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
					System.out.println("\n");
					System.out.println("enter ailment type");
					String ailmentType=sc.nextLine();
					System.out.println("\n");
					System.out.println("enter ailment details");
					String ailmentDetails=sc.nextLine();
					System.out.println("\n");
					System.out.println("enter diagnosisHistory");
					String diagnosisHistory=sc.nextLine();
					
					PatientBean patientBean=new PatientBean(uId,pId,dateAppoint,ailmentType,ailmentDetails,diagnosisHistory);
					patientService.addAilmentDetails(patientBean);
					
					
				}
				
				
				// LOGOUT
				
				if(str.equals("P") )
				{
				System.out.println("want  to logout? Enter Y for yes and N for no");
				char askPatientForLogOut=sc.next().charAt(0);
				if(askPatientForLogOut=='Y')
				{
				if(UserObj.logout(credentialsBean.getUserID()))
				{
					System.out.println("successfully logout");
				}
				else System.out.println("problem with logout");
				}
				}
					
			//	System.out.println(credentialsBean.getUserID());
				
			//	System.out.println(credentialsBean.getPassword());
				
				
				
			}
			else {     //REGISTRATION
				
				System.out.println("SIGN UP FORM");
				
				
				//Enter first name during sign up
				
				sc.nextLine();
				
				
				boolean run=true;
				while(run)
				{	
					System.out.println("Enter first name (minimum 1 character maximum 20 character starting with capital letter and contains only alphanumeric characters)");
					String eFirstNameTemp=sc.nextLine();
					
				if(patientService.checkValidName(eFirstNameTemp))
				{
					run=false;
					profileBean.setFirstName(eFirstNameTemp);
				}
				else
				{
					System.out.println("wrong format, please enter first name again");
					run=true;
				}
				
				}
				
				
				profileBean.setUserID();
				
				run=true;
				
				while(run)
				{	
					System.out.println("Enter last name (minimum 1 character maximum 20 character starting with capital letter and contains only alphanumeric characters)");
					String eLastNameTemp=sc.nextLine();
					
				if(patientService.checkValidName(eLastNameTemp))
				{
					run=false;
					profileBean.setLastName(eLastNameTemp);
				}
				else
				{
					System.out.println("wrong format, please enter last name again");
					run=true;
				}
				
				}
				
				run=true;
				
				while(run)
				{	
					System.out.println("Enter DOB (format is YYYY-MM-DD)");
					String dob=sc.nextLine();
					
				if(patientService.checkValidDateOfBirth(dob))
				{
					run=false;
					profileBean.setDateOfBirth(dob);
				}
				else
				{
					System.out.println("wrong format, please enter DOB again");
					run=true;
				}
				
				}
				
				
				System.out.println("Enter gender (Male/Female) ");
				profileBean.setGender(sc.nextLine());
				        
				System.out.println("Enter street ");
				profileBean.setStreet(sc.nextLine());
				
				System.out.println("Enter location ");
				profileBean.setLocation(sc.nextLine());
				
				System.out.println("Enter city ");
				profileBean.setCity(sc.nextLine());
				
				System.out.println("Enter state ");
				profileBean.setState(sc.nextLine());
				 run=true;
				while(run)
				{	
					System.out.println("Enter Pincode (6 digits long)");
					String pincode=sc.nextLine();
					
				if(patientService.checkValidPincode(pincode))
				{
					run=false;
					profileBean.setPincode(pincode);
				}
				else
				{
					System.out.println("wrong format, please enter pincode again");
					run=true;
				}
				
				}

				run=true;
				
				while(run)
				{	
					System.out.println("Enter Mobile No (10 digits long and starting with (6-9))");
					String mobileNo=sc.nextLine();
					
				if(patientService.checkValidMobileNo(mobileNo))
				{
					run=false;
					profileBean.setMobileNo(mobileNo);
				}
				else
				{
					System.out.println("wrong format, please enter mobile no again");
					run=true;
				}
				
				}
				
			
				run=true;
				
				while(run)
				{	
					System.out.println("Enter Email Id ");
					String emailID=sc.nextLine();
					
				if(patientService.checkValidEmailID(emailID))
				{
					run=false;
					profileBean.setEmailID(emailID);
				}
				else
				{
					System.out.println("wrong format, please enter Email ID again");
					run=true;
				}
				
				}
				
				run=true;
				
				while(run)
				{	
					System.out.println("Enter password (Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character) ");
					String password=sc.nextLine();
					
				if(patientService.checkValidPassword(password))
				{
					run=false;
					profileBean.setPassword(password);
				}
				else
				{
					System.out.println("wrong format, please enter password again");
					run=true;
				}
				}
				
				System.out.println(UserObj.register(profileBean));
				
				
			}
			
		}
		
	}

}
