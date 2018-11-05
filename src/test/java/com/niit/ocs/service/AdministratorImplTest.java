package com.niit.ocs.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.dao.DoctorDao;
import com.niit.ocs.dao.impl.DoctorDaoImpl;
import com.niit.ocs.service.impl.AdministratorImpl;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
public class AdministratorImplTest {

	DoctorDaoImpl doctorDao;
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
	public void testAddDoctor() {
		doctorDao=mock(DoctorDaoImpl.class);
		String expectedFromCreateDoctor="success";
		DoctorBean db=new DoctorBean("Gh1231","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		//DoctorBean db=new DoctorBean("Gh123","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		
		when(doctorDao.createDoctor(db)).thenReturn(expectedFromCreateDoctor);// this is just to test DAO method before testing the actual Authenticate method
		
		Administrator administrator=new AdministratorImpl(doctorDao);
		
		String result = administrator.addDoctor(db);
		
		String expectedFromAddDoctor="SUCCESS";
		assertEquals(result,expectedFromAddDoctor);
	}

	@Test
	public void testModifyDoctor() {
		
		doctorDao=mock(DoctorDaoImpl.class);
		
		boolean expectedFromUpdateDoctor=true;
		
		DoctorBean doctorBean=new DoctorBean("1590","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		when(doctorDao.updateDoctor(doctorBean)).thenReturn(expectedFromUpdateDoctor);
		
		Administrator administrator=new AdministratorImpl(doctorDao);
		
		boolean result = administrator.modifyDoctor(doctorBean);
		boolean expectedFromModifyDoctor=true;
		assertEquals(result,expectedFromModifyDoctor);
	} 

	
}
