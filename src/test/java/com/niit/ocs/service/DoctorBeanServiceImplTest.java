package com.niit.ocs.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.niit.ocs.service.impl.DoctorBeanServiceImpl;

public class DoctorBeanServiceImplTest {

	DoctorBeanService doctorBeanService=new DoctorBeanServiceImpl();
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
		boolean result=doctorBeanService.checkValidName(name);
		assertTrue(result);
		
		name="bhanu";
		result=doctorBeanService.checkValidName(name);
		assertFalse(result);
		
		
	}

	@Test
	public void testCheckValidPincode() {
		String pincode="023454";
		boolean result=doctorBeanService.checkValidPincode(pincode);
		assertFalse(result);
		
		pincode="123454";
		result=doctorBeanService.checkValidPincode(pincode);
		assertTrue(result);
		
	}

	@Test
	public void testCheckValidMobileNo() {
		String mobileNo="8374292033";
		boolean result=doctorBeanService.checkValidMobileNo(mobileNo);
		assertTrue(result);
		
		mobileNo="3374292033";
		result=doctorBeanService.checkValidMobileNo(mobileNo);
		assertFalse(result);
		
	}

	@Test
	public void testCheckValidEmailID() {
		String emailID="bhanu29k@gmail.com";
		boolean result=doctorBeanService.checkValidEmailID(emailID);
		assertTrue(result);
		
		emailID="Bhanu29k@gmail.com";
		result=doctorBeanService.checkValidEmailID(emailID);
		assertFalse(result);
		
	}

	@Test
	public void testCheckValidDateOfBirth() {
		String dateOfBirth="1956-06-23";
		boolean result=doctorBeanService.checkValidDateOfBirth(dateOfBirth);
		assertTrue(result);
		
		dateOfBirth="1956-23-07";
		result=doctorBeanService.checkValidDateOfBirth(dateOfBirth);
		assertFalse(result);
		
	}

	@Test
	public void testCheckValidDateOfJoining() {
		String dateOfJoining="1976-06-23";
		boolean result=doctorBeanService.checkValidDateOfJoining(dateOfJoining);
		assertTrue(result);
		
		dateOfJoining="1976-13-23";
		result=doctorBeanService.checkValidDateOfJoining(dateOfJoining);
		assertFalse(result);
	}

	@Test
	public void testGenerateUserID() {
		String name="Mohan";
		String result=doctorBeanService.generateUserID(name);
		assertEquals(result.length(),6);
	}

}
