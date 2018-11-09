package com.niit.ocs.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.bean.PatientBean;
import com.niit.ocs.dao.PatientDao;
import com.niit.ocs.dao.impl.DoctorDaoImpl;
import com.niit.ocs.dao.impl.PatientDaoImpl;
import com.niit.ocs.service.impl.AdministratorImpl;
import com.niit.ocs.service.impl.PatientServiceImpl;

public class PatientServiceImplTest {

	PatientDao patientDao;
	PatientBean patientBean;
	PatientService patientService=new PatientServiceImpl();
	DoctorBean doctorBean;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckValidName() {
		String name="Bhanu";
		boolean result=patientService.checkValidName(name);
		assertTrue(result);
		
		name="bhanu";
		result=patientService.checkValidName(name);
		assertFalse(result);
	}

	@Test
	public void testCheckValidPincode() {
		String pincode="023454";
		boolean result=patientService.checkValidPincode(pincode);
		assertFalse(result);
		
		pincode="123454";
		result=patientService.checkValidPincode(pincode);
		assertTrue(result);
	}

	@Test
	public void testCheckValidMobileNo() {
		String mobileNo="8374292033";
		boolean result=patientService.checkValidMobileNo(mobileNo);
		assertTrue(result);
		
		mobileNo="4374292033";
		result=patientService.checkValidMobileNo(mobileNo);
		assertFalse(result);
	}

	@Test
	public void testCheckValidEmailID() {
		String emailID="bhanu29k@gmail.com";
		boolean result=patientService.checkValidEmailID(emailID);
		assertTrue(result);
		
		emailID="Bhanu29k@gmail.com";
		result=patientService.checkValidEmailID(emailID);
		assertFalse(result);
	}

	@Test
	public void testCheckValidPassword() {
		String password="Bhanu@123";
		boolean result=patientService.checkValidPassword(password);
		assertTrue(result);
		
		password="bhanu@123";
		result=patientService.checkValidPassword(password);
		assertFalse(result);
	}

	@Test
	public void testCheckValidDateOfBirth() {
		String dateOfBirth="1956-06-25";
		boolean result=patientService.checkValidDateOfBirth(dateOfBirth);
		assertTrue(result); 
		
		dateOfBirth="1956-14-25";
		result=patientService.checkValidDateOfBirth(dateOfBirth);
		assertFalse(result); 
	}

	@Test
	public void testCheckValidAppointmentDate()
	{
		String appointDate="12/12/2018";
		boolean result=patientService.checkValidAppointmentDate(appointDate);
		assertTrue(result); 
		
		appointDate="12/23/2019";
		result=patientService.checkValidAppointmentDate(appointDate);
		assertFalse(result); 
	}
	
	
	@Test
	public void testGenerateUserID() {
		String name="Mohan";
		String result=patientService.generateUserID(name);
		assertEquals(result.length(),6);
	}

	@Test 
	public void testAddAilmentDetails()
	{
		patientDao=mock(PatientDaoImpl.class);
		patientBean=new PatientBean("p1","72053",LocalDate.now(),"Cardiologoist","pain","taking medicine");
		when(patientDao.createPatient(patientBean)).thenReturn("SUCCESS");
		patientService=new PatientServiceImpl(patientDao);
		assertEquals(patientService.addAilmentDetails(patientBean),"SUCCESS");
		
	}
	
	@Test 
	public void testViewAllAilmentDetails()
	{
		patientDao=mock(PatientDaoImpl.class);
		ArrayList<PatientBean> expectedFromFindAll=new ArrayList<PatientBean>();
		//doctorBean=new DoctorBean("1590","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		patientBean=new PatientBean("p1","72053",LocalDate.now(),"Cardiologoist","pain","taking medicine");
		expectedFromFindAll.add(patientBean);
		when(patientDao.findAll()).thenReturn(expectedFromFindAll);
		patientService=new PatientServiceImpl(patientDao);
		ArrayList<PatientBean> result = patientService.viewAllAilmentDetails();
		ArrayList<PatientBean> expectedFromViewAllDoctors=new ArrayList<PatientBean>();
		expectedFromViewAllDoctors.add(patientBean);
		assertEquals(result,expectedFromViewAllDoctors);
		
	}
	
	@Test
	public void testViewAilmentDetails()
	{
		patientDao=mock(PatientDaoImpl.class);
		patientBean=new PatientBean("p1","72053",LocalDate.now(),"Cardiologoist","pain","taking medicine");
		when(patientDao.findByID(patientBean.getPatientID())).thenReturn(patientBean);
		patientService=new PatientServiceImpl(patientDao);
		assertEquals(patientService.viewAilmentDetails(patientBean.getPatientID()),patientBean);
	}
	
	@Test
	public void testModifyAilmentDetails()
	{
		patientDao=mock(PatientDaoImpl.class);
		patientBean=new PatientBean("p1","72053",LocalDate.now(),"Cardiologoist","pain","taking medicine");
		when(patientDao.updatePatient(patientBean)).thenReturn(true);
		patientService=new PatientServiceImpl(patientDao);
		assertEquals(patientService.modifyAilmentDetails(patientBean),true);
		
	}
	
	@Test
	public void testViewListOfDoctors()
	{
		ArrayList<DoctorBean> expectedFromFindAll=new ArrayList<DoctorBean>();
		doctorBean=new DoctorBean("1590","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		//patientBean=new PatientBean("p1","72053",LocalDate.now(),"Cardiologoist","pain","taking medicine");
		expectedFromFindAll.add(doctorBean);
		patientDao=mock(PatientDaoImpl.class);
		when(patientDao.findDoctors("Cardiologist",LocalDate.now())).thenReturn(expectedFromFindAll);
		patientService=new PatientServiceImpl(patientDao);
		assertEquals(patientService.viewListOfDoctors("Cardiologist", LocalDate.now()),expectedFromFindAll);
	}
	
	@Test
	public void testRequestForAppointment()
	{
		patientDao=mock(PatientDaoImpl.class);
		patientService=mock(PatientServiceImpl.class);
		when(patientDao.createRequest("ra1234",LocalDate.now(),"p1")).thenReturn("CONFIRMED");
		doctorBean=new DoctorBean("1590","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		when(patientService.viewAvailableDoctor("ra1234",LocalDate.now())).thenReturn(doctorBean);
		patientService=new PatientServiceImpl(patientDao,patientService);
		assertEquals(patientService.requestForAppointment("ra1234",LocalDate.now(), "p1"),"CONFIRMED");
		
		patientDao=mock(PatientDaoImpl.class);
		patientService=mock(PatientServiceImpl.class);
		when(patientDao.createRequest("r1234",LocalDate.now(),"p1")).thenReturn("FAIL");
		doctorBean=new DoctorBean("1590","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		when(patientService.viewAvailableDoctor("ra1234",LocalDate.now())).thenReturn(doctorBean);
		patientService=new PatientServiceImpl(patientDao,patientService);
		assertEquals(patientService.requestForAppointment("r1234",LocalDate.now(), "p1"),"FAIL");
	}
	
	@Test
	public void testViewAvailableDoctor()
	{
		patientDao=mock(PatientDaoImpl.class);
		doctorBean=new DoctorBean("1590","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		when(patientDao.findAvaiableDoctor("ra1234",LocalDate.now())).thenReturn(doctorBean);
		patientService=new PatientServiceImpl(patientDao);
		assertEquals(patientService.viewAvailableDoctor("ra1234",LocalDate.now()),doctorBean);
	}
	
}
