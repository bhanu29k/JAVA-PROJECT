package com.niit.ocs.client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.bean.LeaveBean;
import com.niit.ocs.bean.PatientBean;
import com.niit.ocs.bean.ProfileBean;
import com.niit.ocs.dao.DoctorDao;
import com.niit.ocs.dao.impl.DoctorDaoImpl;
import com.niit.ocs.service.Administrator;
import com.niit.ocs.service.ReporterService;
import com.niit.ocs.service.impl.AdministratorImpl;
import com.niit.ocs.service.impl.DoctorBeanServiceImpl;
import com.niit.ocs.service.impl.PatientServiceImpl;
import com.niit.ocs.service.impl.ReporterServiceImpl;
import com.niit.ocs.util.User;
import com.niit.ocs.util.impl.UserImpl;


public class Main {
		
	static Logger loggr=Logger.getLogger(Main.class);
	public static void main(String[] args) {
		loggr.info("Check whether main file working");
		User UserObj=new UserImpl();
		PatientServiceImpl patientService=new PatientServiceImpl();
		CredentialsBean credentialsBean=new CredentialsBean(null,null);
		ProfileBean profileBean=new ProfileBean();
		DoctorBean  doctorBean=new DoctorBean();
		DoctorBeanServiceImpl doctorBeanService=new DoctorBeanServiceImpl();
		LeaveBean leaveBean=new LeaveBean();
		DoctorDao doctorDao=new DoctorDaoImpl();	
		Administrator administrator=new AdministratorImpl();
		ReporterService reporterService=new ReporterServiceImpl();
		String mainId="";
		Scanner sc=new Scanner(System.in);
		
		boolean askType=true;
		while(askType)
		{
		System.out.println("Are you an Admin/Reporter/Patient(Enter A for Admin, R for Reporter, P for Patient)");
		char askUser=sc.next().charAt(0);  
		if(askUser=='A')
		{
			
			System.out.println("Enter User Id");
			sc.nextLine();
			String loginId;
			loginId=sc.nextLine();
			credentialsBean.setUserID(loginId);
			
			System.out.println("Enter password");
			String loginPassword;
			loginPassword=sc.nextLine();
			credentialsBean.setPassword(loginPassword);
			
			
			//System.out.println(credentialsBean.getUserID());
			String str=UserObj.login(credentialsBean);
			if(str.equals("A"))
			{
				mainId=loginId;
			}
			
			if(str.equals("A") || str.equals("R") || str.equals("P"))
			System.out.println("\nSuccessfully Login. type of user is: "+str);
			
			else System.out.println(str);
			boolean askForAdminFunctionality=true;
		
			if(str.equals("A"))
		     while(askForAdminFunctionality)
		     {
				System.out.println("what do you want to do---- \nEnter 1 for Password change\nEnter 2 for Add Doctor\nEnter 3 for Modify doctor\nEnter 4 for View All Doctors\nEnter 5 for Remove Doctor\nEnter 6 for Suggest Doctors to patient\nEnter 7 for log out");
				int choice=sc.nextInt();
				
				switch(choice)
				{
			// PASSWORD CHANGE-----------------------------------------------------------------------------------
				case 1: if(str.equals("A"))
			{
			//System.out.println("\nDo you want to change your password? enter Y for yes and N for no");
			//char askForPasswordChange=sc.next().charAt(0);
			sc.nextLine();
			//if(askForPasswordChange=='Y')
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
			break;
			
			// ADD DOCTOR---------------------------------------------------------------------------------
			
				case 2:
			//if(str.equals("A"))
			{
			//	System.out.println("want  to add doctor? Enter Y for yes and N for no");
				//char askAdmin=sc.next().charAt(0);
			//	if(askAdmin=='Y')
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
			break;
			
			// MODIFY DOCTOR------------------------------------------------------------------------------------
			
				case 3:
			//if(str.equals("A"))
			{
				boolean op=true;
				while(op)  
				{
				//System.out.println("want  to Modify doctor? Enter Y for yes and N for no");
				//char askAdmin=sc.next().charAt(0);
				//if(askAdmin=='Y')
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
			break;
				case 4:
			// VIEW ALL DOCTORS
		//	if(str.equals("A"))
			{
			//	System.out.println("do you want to see all doctors Y/N");
				//char askAdmin=sc.next().charAt(0);
				//if(askAdmin=='Y')
				{
					ArrayList<DoctorBean> arrlst=administrator.viewAllDoctors();
					for(DoctorBean i:arrlst)
					{
						System.out.println(i.getDoctorID()+" "+i.getDoctorName()+" "+i.getDateOfBirth()+" "+i.getDateOfJoining()+" "+i.getGender()+" "+i.getQualification()+" "+i.getSpecialization()+" "+i.getYearsOfExperience()+" "+i.getStreet()+" "+i.getLocation()+" "+i.getCity()+" "+i.getState()+" "+i.getPincode()+" "+i.getContactNumber()+" "+i.getEmailID());
						System.out.println("\n");
					}
				}
				
			}
			break;
			 
				case 5:
			// DELETE DOCTOR
			
		//	if(str.equals("A"))
			{
			//	System.out.println("do you want to delete doctors Y/N");
				//char askAdmin=sc.next().charAt(0); 
				//if(askAdmin=='Y')
				{
					sc.nextLine();
					System.out.println("enter the doctor ids you want to delete");
					String id=sc.nextLine();
					int res=administrator.removeDoctor(id);
					
				}
			}
			break;
			// SUGGEST DOCTORS
				case 6:
			//if(str.equals("A"))
			{
				//System.out.println("do you want to suggest doctors for patient");
				//char askAdmin=sc.next().charAt(0); 
				//if(askAdmin=='Y')
				{
					sc.nextLine();
					
					boolean op=true;
					while(op)
					{
					System.out.println("Enter the patient id");
					String pid=sc.nextLine();
					LocalDate appointDate=LocalDate.now();
					if(patientService.viewAilmentDetails(pid)!=null)
					{
						
					   boolean run=true;
						while(run)
						{	
							System.out.println("Enter date of appointment dd/mm/yyyy)");
							String appointDateTemp=sc.nextLine();
							
						if(patientService.checkValidAppointmentDate(appointDateTemp))
						{
							run=false;
							String date[]=appointDateTemp.split("/");
							appointDate=LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
						}
						else
						{
							System.out.println("wrong format, please enter appointment date again");
							run=true;
						}
						
						}
						op=false;
						ArrayList<DoctorBean> arrList=new ArrayList<DoctorBean>();
						arrList=administrator.suggestDoctors(pid,appointDate);
						for(DoctorBean i:arrList)
						{
							System.out.println(i.getDoctorID()+" "+i.getDoctorName()+" "+i.getDateOfBirth()+" "+i.getDateOfJoining()+" "+i.getGender()+" "+i.getQualification()+" "+i.getSpecialization()+" "+i.getYearsOfExperience()+" "+i.getStreet()+" "+i.getLocation()+" "+i.getCity()+" "+i.getState()+" "+i.getPincode()+" "+i.getContactNumber()+" "+i.getEmailID());
							System.out.println("\n");
						}
						
					}
					else
					{
						System.out.println("patient id does not exists please enter new patient id");
						op=true;
					}
					}
					
					
				}
				
			}
			break;
			
			
			// LOG OUT-------------------------------------------------------------------------------------------
				case 7:
		//	if(str.equals("A"))
			{
			//System.out.println("want  to logout? Enter Y for yes and N for no");
			//char askAdmin=sc.next().charAt(0);
			//if(askAdmin=='Y')
			{
			if(UserObj.logout(credentialsBean.getUserID()))
			{
				askForAdminFunctionality=false;
				System.out.println("successfully logout");
				
			}
			else System.out.println("problem with logout");
			
			}
			}
			break;
			
				default: System.out.println("wrong choice please choose again");
				break;
				}
		     }
			askType=false;
		     }
		
		else if(askUser=='R')
		{
			sc.nextLine();
			
			System.out.println("Enter User Id");
			
			String loginId;
			loginId=sc.nextLine();
			credentialsBean.setUserID(loginId);
			
			System.out.println("Enter password");
			String loginPassword;
			loginPassword=sc.nextLine();
			credentialsBean.setPassword(loginPassword);
			String str=UserObj.login(credentialsBean);
			if(str.equals("R"))
			{
				mainId=loginId;
			}
			System.out.println(str);
			boolean askForReporterFunctionality=true;
			if(str.equals("R"))
			while(askForReporterFunctionality)
			{
				System.out.println("what do you want to do\nEnter 1 to Apply leave for doctor\nEnter 2 to view all available doctor on selected date\nEnter 3 for log out");
				int choice=sc.nextInt();
				
				switch(choice)
				{
				case 1:
		//	if(str.equals("R"))
			{
			//	System.out.println("Do you want to apply leave for Doctor Y or N");
				//char askForDoctorLeave=sc.next().charAt(0);
				//if(askForDoctorLeave=='Y')
				{
					sc.nextLine();
					
					boolean run=true;
					while(run)
					{	
						System.out.println("Enter Reported Id)");
						String idTemp=sc.nextLine();
						
					if(reporterService.checkValidReporterId(idTemp))
					{
						run=false;
						leaveBean.setReporterId(idTemp);
					}
					else
					{
						System.out.println("wrong format, please enter reporter id again");
						run=true;
					}
					
					}
					
					
					run=true;
					while(run)
					{	
						System.out.println("Enter Reported Name)");
						String nameTemp=sc.nextLine();
						
					if(reporterService.checkValidReporterName(nameTemp))
					{
						run=false;
						leaveBean.setReporterName(nameTemp);
					}
					else
					{
						System.out.println("wrong format, please enter reporter name again");
						run=true;
					}
					
					}
					
					
					leaveBean.setLeaveId();
					
					run=true;
					while(run)
					{	
						System.out.println("Enter Doctor Id)");
						String dIdTemp=sc.nextLine();
						
					if(reporterService.checkValidDoctorId(dIdTemp))
					{
						run=false;
						leaveBean.setDoctorId(dIdTemp);
					}
					else
					{
						System.out.println("wrong format, please enter doctor id again");
						run=true;
					}
					
					}
					
					
					run=true;
					while(run)
					{	
						System.out.println("Enter date of leave starting from dd/mm/yyyy)");
						String startDateTemp=sc.nextLine();
						
					if(reporterService.checkValidLeaveFrom(startDateTemp))
					{
						run=false;
						String date[]=startDateTemp.split("/");
						LocalDate startDate=LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
						leaveBean.setLeaveFrom(startDate);
					}
					else
					{
						System.out.println("wrong format, please enter starting date again");
						run=true;
					}
					
					}
				
					run=true;
					while(run)
					{	
						System.out.println("Enter date of leave ending dd/mm/yyyy)");
						String endDateTemp=sc.nextLine();
						
					if(reporterService.checkValidLeaveTo(endDateTemp))
					{
						run=false;
						String date[]=endDateTemp.split("/");
						LocalDate endDate=LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
						leaveBean.setLeaveTo(endDate);
					}
					else
					{
						System.out.println("wrong format, please enter end date again");
						run=true;
					}
					}
					System.out.println("Enter the reason you want leave for");
					String reason=sc.nextLine();
					leaveBean.setReason(reason);
					leaveBean.setStatus(0);	
					System.out.println(reporterService.addLeave(leaveBean));
					
				}
			}
			break;
			// view all  available doctors
				case 2:
			//if(str.equals("R"))
			{
				//sc.nextLine();
				//System.out.println("Do you want to see all available doctor on selected date (Y or N)");
				//char askReporterForDoctors=sc.next().charAt(0);
				//if(askReporterForDoctors=='Y')
				{
					sc.nextLine();
					System.out.println("enter the date");
					String selectedDate=sc.nextLine();
					String date[]=selectedDate.split("/");
					LocalDate availDate=LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
					ArrayList<DoctorBean> arrList=new ArrayList<>();
					arrList=reporterService.viewAllAvailableDoctors(availDate);
					for(DoctorBean i:arrList)
					{
						System.out.println(i.getDoctorID()+" "+i.getDoctorName()+" "+i.getDateOfBirth()+" "+i.getDateOfJoining()+" "+i.getGender()+" "+i.getQualification()+" "+i.getSpecialization()+" "+i.getYearsOfExperience()+" "+i.getStreet()+" "+i.getLocation()+" "+i.getCity()+" "+i.getState()+" "+i.getPincode()+" "+i.getContactNumber()+" "+i.getEmailID());
						System.out.println("\n");
					}
				}
			}
			break;
				case 3:
					if(UserObj.logout(credentialsBean.getUserID()))
					{
						askForReporterFunctionality=false;
						System.out.println("successfully logout");
						
					}
					else System.out.println("problem with logout");
					break;
			default:
				{
				System.out.println("you have selected wrong option please choose again");
				break;
			}	
				}
				
		}
		
			askType=false;
			
		}
		else if(askUser=='P')
		{
			boolean askExistence=true;
			while(askExistence)
			{
				System.out.println("Are you an existing user\n Enter 1 for login\n Enter 2 for registration");
				int choice=sc.nextInt();
				switch(choice)
				{
				
			//System.out.println("Are you an existing user(Enter Y for yes And N for no)");
			//char askPatient=sc.next().charAt(0);
			//if(askPatient=='Y')
				case 1:
				{
				sc.nextLine();
				System.out.println("Enter User Id");
				String loginId;
				loginId=sc.nextLine();
				credentialsBean.setUserID(loginId);
				System.out.println("Enter password");
				String loginPassword;
				loginPassword=sc.nextLine();
				credentialsBean.setPassword(loginPassword);
				String str=UserObj.login(credentialsBean);
				if(str.equals("P"))
				{
					mainId=loginId;
				}
				System.out.println(str);
				boolean askForPatientFunctionality=true;
				if(str.equals("P"))
				while(askForPatientFunctionality)
				{
					System.out.println("what do you want to do\nEnter 1 for password change\nEnter 2 to add ailment details\nEnter 3 to view all ailment details\nEnter 4 to modify ailment details\nEnter 5 to view ailment details\n Enter 6 to view list of doctors\nEnter 7 to request for appointment \nEnter 8 for log out");
					int choiceOfPatient=sc.nextInt();
					
					switch(choiceOfPatient)
					{
					case 1:
		//		if(str.equals("A") || str.equals("P") || str.equals("R"))
				{
			//	System.out.println("Do you want to change your password? enter Y for yes and N for no");
				//char askForPasswordChange=sc.next().charAt(0);
				sc.nextLine();
				//if(askForPasswordChange=='Y')
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
				break;
				// ADD AILMENT DETAILS
					case 2:
				//if(str.equals("A") || str.equals("P") || str.equals("R"))
				{
				//System.out.println("want to add ailment details Y/N");
			//	char askPatientForAilment=sc.next().charAt(0);
				//if(askPatientForAilment=='Y')
				{
					sc.nextLine();
				//	System.out.println("enter user id");
					String uId=mainId;
					//System.out.println("enter patient id");
					String pId=reporterService.generateLeaveId();
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
					
					PatientBean patientBean=new PatientBean(pId,uId,dateAppoint,ailmentType,ailmentDetails,diagnosisHistory);
					System.out.println(patientService.addAilmentDetails(patientBean));
					
					
				}
				}
				break;
				// VIEW All AILMENT DETAILS
					case 3:
				//System.out.println("want to see All ailment details? Enter Y for yes and N for no");
				//char askPatientForSeeAilment=sc.next().charAt(0);
				//if(askPatientForSeeAilment=='Y')
				{
					sc.nextLine();
					patientService.viewAllAilmentDetails();
					ArrayList<PatientBean> arrlst=new ArrayList<PatientBean>();
					arrlst=patientService.viewAllAilmentDetails();
					for(PatientBean i:arrlst)
					{
						System.out.println(i.getPatientID()+" "+i.getUserID()+" "+i.getAppointmentDate()+" "+i.getAilmentType()+" "+i.getAilmentDetails()+" "+i.getDiagnosishistory());
						System.out.println("\n");
					}
					
					
				}
				break;
				
				
				
				// Modify AILMENT DETAILS
				
				
					case 4:
				//System.out.println("want  to Modify ailment details? Enter Y for yes and N for no");
				//char askPatientForModifyAilment=sc.next().charAt(0);
				//if(askPatientForModifyAilment=='Y')
				{
					sc.nextLine();
					System.out.println("enter the patient id which you want to modify");
					String pid=sc.nextLine();
					PatientBean patientBean=new PatientBean();
					patientBean=patientService.viewAilmentDetails(pid);
					
					//System.out.println(patientBean.getPatientID()+" "+patientBean.getUserID());
					
					if(patientBean!=null)
					{
					  System.out.println("what do you want to modify (Enter 1 for appointment date, 2 for ailment type, 3 for ailment details, 4 for diagnosis history)");
					   int askForModify=sc.nextInt();
					   sc.nextLine();
					   switch(askForModify)
					   {
					   case 1:
						   System.out.println("enter appointment date  dd/mm/yyyy");
							String appointmentDate=sc.nextLine();
							String date[]=appointmentDate.split("/");
							LocalDate dateAppoint=LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
							patientBean.setAppointmentDate(dateAppoint);
							System.out.println("\n");
							break;
					   case 2:
						    System.out.println("enter ailment type");
							String ailmentType=sc.nextLine();
							patientBean.setAilmentType(ailmentType);
							System.out.println("\n");
							break;
					   case 3:
						   System.out.println("enter ailment details");
							String ailmentDetails=sc.nextLine();
							patientBean.setAilmentDetails(ailmentDetails);
							System.out.println("\n");
							break;
					   case 4:
						    System.out.println("enter diagnosisHistory");
							String diagnosisHistory=sc.nextLine();
							patientBean.setDiagnosishistory(diagnosisHistory);
							System.out.println("\n");
						  	break;				   
					   default:
							System.out.println("please enter correct details");
							break; 
					   }
					   boolean result=patientService.modifyAilmentDetails(patientBean);
					   System.out.println(result);
					}
				}
					break;   
				
				// VIEW AILMENT DETAILS BY ID
					case 5:
				//if(str.equals("P"))
				{
					//System.out.println("want  to see ailment details? Enter Y for yes and N for no");
					//char askPatientForAilmentDetails=sc.next().charAt(0);
					//if(askPatientForAilmentDetails=='Y')
					{
						sc.nextLine();
						System.out.println("enter the patient id which you want to see");
						String pid=sc.nextLine();
						PatientBean patientBean=new PatientBean();
						patientBean=patientService.viewAilmentDetails(pid);
						System.out.println(patientBean.getPatientID()+" "+patientBean.getUserID()+" "+patientBean.getAppointmentDate()+" "+patientBean.getAilmentType()+" "+patientBean.getAilmentDetails()+" "+patientBean.getDiagnosishistory());
					}
				}
				break;
				
				// View List of doctors
					case 6:
				//if(str.equals("P"))
				{
					//System.out.println("want  to see specialiazed doctors available on specific date? Enter Y for yes and N for no");
					//char askPatientForDoctorList=sc.next().charAt(0);
					//if(askPatientForDoctorList=='Y')
					{
						sc.nextLine();
						System.out.println("enter the speciliazation of doctor you want");
						String special=sc.nextLine();
						System.out.println("enter the appointment date  dd/mm/yyyy");
						String appointmentDate=sc.nextLine();
						String date[]=appointmentDate.split("/");
						LocalDate dateAppoint=LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
						ArrayList<DoctorBean> arrList=new ArrayList<DoctorBean>();
						arrList=patientService.viewListOfDoctors(special,dateAppoint);
						for(DoctorBean i:arrList)
						{
							System.out.println(i.getDoctorID()+" "+i.getDoctorName()+" "+i.getDateOfBirth()+" "+i.getDateOfJoining()+" "+i.getGender()+" "+i.getQualification()+" "+i.getSpecialization()+" "+i.getYearsOfExperience()+" "+i.getStreet()+" "+i.getLocation()+" "+i.getCity()+" "+i.getState()+" "+i.getPincode()+" "+i.getContactNumber()+" "+i.getEmailID());
							System.out.println("\n");
						}
						
					}
				}
				break;
				
				// REQUEST FOR APPOINTMENT
					case 7:
				//if(str.equals("P"))
				{
					//System.out.println("Do you want to do request for appointment Y/N");
					//char askPatientForAppointment=sc.next().charAt(0);
					//if(askPatientForAppointment=='Y')
					{
						sc.nextLine();
						String Did;
						boolean op=true;
						while(op)
						{
						System.out.println("Enter doctor id");
						Did=sc.nextLine();
						if(doctorDao.findByID(Did)!=null);
						{
							System.out.println("Enter appointment date (dd/mm/yyyy)");
							String appointmentDate=sc.nextLine();
							String date[]=appointmentDate.split("/");
							LocalDate dateAppoint=LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
								System.out.println("enter the patient id");
								String pId;
								pId=sc.nextLine();
								String result=patientService.requestForAppointment(Did,dateAppoint,pId);
								if(result=="CONFIRMED")
								{
									op=false;
								System.out.println("your appointment is confirmed");
								}
								else if(result=="PENDING")
									System.out.println("Please try again after some time");
								else if(result=="FAIL")
								{
									System.out.println("Sorry for inconvenience Your booking is failed due to unavailability of doctor");
									System.out.println("do you want to book your appointment with another doctor Y/N");
									if(sc.nextLine()=="Y")
									{
										op=true;									}
									}
								else op=false;
							
						}
						}
						
					}
				}
				break;
				
				
				
				// LOGOUT
					case 8:
				//if(str.equals("P") )
				{
				//System.out.println("want  to logout? Enter Y for yes and N for no");
				//char askPatientForLogOut=sc.next().charAt(0);
				//if(askPatientForLogOut=='Y')
				{
				if(UserObj.logout(credentialsBean.getUserID()))
				{
					askForPatientFunctionality=false;
					askExistence=false;
					System.out.println("successfully logout");
				}
				else System.out.println("problem with logout");
				}
				}
					
			//	System.out.println(credentialsBean.getUserID());
				
			//	System.out.println(credentialsBean.getPassword());
				}
					}
				
			}
				break;
				case 2:
			{     //REGISTRATION
				
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
				askExistence=false;
			}
			break;
			default: System.out.println("You have selected wrong option");
			break;
		}
			}
			askType=false;
		}
		else
			{
			System.out.println("You choose wrong option please select Again");
			askType=true;
			}
		}
}
}