package com.niit.ocs.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.niit.ocs.service.impl.PatientServiceImpl;

public class PatientServiceImplTest {

	PatientService patientService=new PatientServiceImpl();
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
	}

	@Test
	public void testCheckValidPincode() {
		String pincode="023454";
		boolean result=patientService.checkValidPincode(pincode);
		assertFalse(result);
	}

	@Test
	public void testCheckValidMobileNo() {
		String mobileNo="8374292033";
		boolean result=patientService.checkValidMobileNo(mobileNo);
		assertTrue(result);
	}

	@Test
	public void testCheckValidEmailID() {
		String emailID="bhanu29k@gmail.com";
		boolean result=patientService.checkValidEmailID(emailID);
		assertTrue(result);
	}

	@Test
	public void testCheckValidPassword() {
		String password="Bhanu@123";
		boolean result=patientService.checkValidPassword(password);
		assertTrue(result);
	}

	@Test
	public void testCheckValidDateOfBirth() {
		String dateOfBirth="1956-06-25";
		boolean result=patientService.checkValidDateOfBirth(dateOfBirth);
		assertTrue(result); 
	}

	@Test
	public void testGenerateUserID() {
		String name="Mohan";
		String result=patientService.generateUserID(name);
		assertEquals(result.length(),6);
	}

}
