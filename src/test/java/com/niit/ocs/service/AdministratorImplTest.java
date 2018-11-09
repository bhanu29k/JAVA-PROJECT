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

import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
public class AdministratorImplTest {

	DoctorDao doctorDao;
	DoctorBean doctorBean;
	Administrator administrator=new AdministratorImpl();
	
	
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
		doctorBean=new DoctorBean("Gh1231","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");		
		when(doctorDao.createDoctor(doctorBean)).thenReturn(expectedFromCreateDoctor);// this is just to test DAO method before testing the actual Authenticate method
		administrator=new AdministratorImpl(doctorDao);		
		String result = administrator.addDoctor(doctorBean);
		String expectedFromAddDoctor="SUCCESS";
		assertEquals(result,expectedFromAddDoctor);
	
		doctorDao=mock(DoctorDaoImpl.class);
		expectedFromCreateDoctor="fail";
		doctorBean=new DoctorBean("Gh1231","Ghanshyam","1993-11","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");		
		when(doctorDao.createDoctor(doctorBean)).thenReturn(expectedFromCreateDoctor);// this is just to test DAO method before testing the actual Authenticate method
		administrator=new AdministratorImpl(doctorDao);		
		result = administrator.addDoctor(doctorBean);
		expectedFromAddDoctor="FAIL";
		assertEquals(result,expectedFromAddDoctor);
		
	}

	@Test
	public void testModifyDoctor() {
		
		doctorDao=mock(DoctorDaoImpl.class);
		boolean expectedFromUpdateDoctor=true;
		doctorBean=new DoctorBean("1590","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		when(doctorDao.updateDoctor(doctorBean)).thenReturn(expectedFromUpdateDoctor);
		administrator=new AdministratorImpl(doctorDao);
		boolean result = administrator.modifyDoctor(doctorBean);
		boolean expectedFromModifyDoctor=true;
		assertEquals(result,expectedFromModifyDoctor);
		
		
		doctorDao=mock(DoctorDaoImpl.class);
		expectedFromUpdateDoctor=false;
		doctorBean=new DoctorBean("1590","Ghanshyam","1993-11","2015-04-12","Male","","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		when(doctorDao.updateDoctor(doctorBean)).thenReturn(expectedFromUpdateDoctor);
		administrator=new AdministratorImpl(doctorDao);
		result = administrator.modifyDoctor(doctorBean);
		expectedFromModifyDoctor=false;
		assertEquals(result,expectedFromModifyDoctor);
		
	} 
	
	@Test
	public void testViewAllDoctors()
	{
		doctorDao=mock(DoctorDaoImpl.class);
		ArrayList<DoctorBean> expectedFromFindAll=new ArrayList<DoctorBean>();
		doctorBean=new DoctorBean("1590","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		expectedFromFindAll.add(doctorBean);
		when(doctorDao.findAll()).thenReturn(expectedFromFindAll);
		administrator=new AdministratorImpl(doctorDao);
		ArrayList<DoctorBean> result = administrator.viewAllDoctors();
		ArrayList<DoctorBean> expectedFromViewAllDoctors=new ArrayList<DoctorBean>();
		expectedFromViewAllDoctors.add(doctorBean);
		assertEquals(result,expectedFromViewAllDoctors);
		
		/*doctorDao=mock(DoctorDaoImpl.class);
		expectedFromFindAll=new ArrayList<DoctorBean>();
		doctorBean=new DoctorBean("1590","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		expectedFromFindAll.add(doctorBean);
		when(doctorDao.findAll()).thenReturn(expectedFromFindAll);
		administrator=new AdministratorImpl(doctorDao);
		result = administrator.viewAllDoctors();
		expectedFromViewAllDoctors=new ArrayList<DoctorBean>();
		expectedFromViewAllDoctors.add(doctorBean);
		assertEquals(result,expectedFromViewAllDoctors);
		*/
	}
	
	@Test
	public void testRemoveDoctor()
	{
		doctorDao=mock(DoctorDaoImpl.class);
		ArrayList<String> al=new ArrayList<String>();
		al.add("1234");
		al.add("1235");
		when(doctorDao.deleteDoctor(al)).thenReturn(1);
		administrator=new AdministratorImpl(doctorDao);
		assertEquals(administrator.removeDoctor("1234 1235"),1);
	}

	@Test
	public void testSuggestDoctors()
	{
		doctorDao=mock(DoctorDaoImpl.class);
		doctorBean=new DoctorBean("1590","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		ArrayList<DoctorBean> expectedFromFindByPatientIdAndAppointDate=new ArrayList<DoctorBean>();
		expectedFromFindByPatientIdAndAppointDate.add(doctorBean);
		when(doctorDao.findByPatientIdAndAppointDate("p1",LocalDate.now())).thenReturn(expectedFromFindByPatientIdAndAppointDate);
		administrator=new AdministratorImpl(doctorDao);
		assertEquals(administrator.suggestDoctors("p1",LocalDate.now()),expectedFromFindByPatientIdAndAppointDate);
	}
	
}
