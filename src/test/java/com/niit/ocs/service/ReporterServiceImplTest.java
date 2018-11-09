/**
 * 
 */
package com.niit.ocs.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.bean.LeaveBean;
import com.niit.ocs.dao.DoctorDao;
import com.niit.ocs.dao.ReporterDao;
import com.niit.ocs.dao.impl.DoctorDaoImpl;
import com.niit.ocs.dao.impl.ReporterDaoImpl;
import com.niit.ocs.service.impl.ReporterServiceImpl;

/**
 * @author Training
 *
 */
public class ReporterServiceImplTest {

	ReporterService reporterService=new ReporterServiceImpl();
	ReporterDao reporterDao;
	CredentialsBean credentialsBean;
	DoctorDao doctorDao;
	DoctorBean doctorBean;
	LeaveBean leaveBean;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.niit.ocs.service.impl.ReporterServiceImpl#ReporterServiceImpl()}.
	 */
	@Test
	public void testReporterServiceImpl() {
		
		
	}

	/**
	 * Test method for {@link com.niit.ocs.service.impl.ReporterServiceImpl#checkValidReporterId(java.lang.String)}.
	 */
	@Test
	public void testCheckValidReporterId() {
		reporterDao=mock(ReporterDaoImpl.class);
		credentialsBean=new CredentialsBean("11111","Banti@123"); 
		when(reporterDao.findById(credentialsBean.getUserID())).thenReturn(credentialsBean);
		reporterService=new ReporterServiceImpl(reporterDao);
		boolean result=reporterService.checkValidReporterId(credentialsBean.getUserID());
		assertTrue(result);
		
		reporterDao=mock(ReporterDaoImpl.class);
		//credentialsBean=new CredentialsBean("11111","Banti@123"); 
		when(reporterDao.findById("12874")).thenReturn(null);
		reporterService=new ReporterServiceImpl(reporterDao);
		result=reporterService.checkValidReporterId("12874");
		assertFalse(result);
		
		
		}

	/**
	 * Test method for {@link com.niit.ocs.service.impl.ReporterServiceImpl#checkValidReporterName(java.lang.String)}.
	 */
	@Test
	public void testCheckValidReporterName() {
		String name="Bhanu";
		boolean result=reporterService.checkValidReporterName(name);
		assertTrue(result);
		
		name="bhanu";
		result=reporterService.checkValidReporterName(name);
		assertFalse(result);
	}

	/**
	 * Test method for {@link com.niit.ocs.service.impl.ReporterServiceImpl#checkValidDoctorId(java.lang.String)}.
	 */
	@Test
	public void testCheckValidDoctorId() {
		
		doctorDao=mock(DoctorDaoImpl.class);
		doctorBean=new DoctorBean("1590","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		when(doctorDao.findByID(doctorBean.getDoctorID())).thenReturn(doctorBean);
		reporterService=new ReporterServiceImpl(doctorDao);
		boolean result=reporterService.checkValidDoctorId(doctorBean.getDoctorID());
		assertTrue(result);
		
		reporterDao=mock(ReporterDaoImpl.class);
		//credentialsBean=new CredentialsBean("11111","Banti@123"); 
		when(doctorDao.findByID("12874")).thenReturn(null);
		reporterService=new ReporterServiceImpl(doctorDao);
		result=reporterService.checkValidDoctorId("12874");
		assertFalse(result);
	}

	/**
	 * Test method for {@link com.niit.ocs.service.impl.ReporterServiceImpl#checkValidLeaveFrom(java.lang.String)}.
	 */
	@Test
	public void testCheckValidLeaveFrom() {
		String dateOfBirth="11/12/2018";
		boolean result=reporterService.checkValidLeaveFrom(dateOfBirth);
		assertTrue(result); 
		
		dateOfBirth="123/12/2019";
		result=reporterService.checkValidLeaveFrom(dateOfBirth);
		assertFalse(result); 
		
	}

	/**
	 * Test method for {@link com.niit.ocs.service.impl.ReporterServiceImpl#checkValidLeaveTo(java.lang.String)}.
	 */
	@Test
	public void testCheckValidLeaveTo() {
		String dateOfBirth="11/12/2018";
		boolean result=reporterService.checkValidLeaveTo(dateOfBirth);
		assertTrue(result); 
		
		dateOfBirth="123/12/2019";
		result=reporterService.checkValidLeaveTo(dateOfBirth);
		assertFalse(result); 
		
	}

	/**
	 * Test method for {@link com.niit.ocs.service.impl.ReporterServiceImpl#generateLeaveId()}.
	 */
	@Test
	public void testGenerateLeaveId() {
		String result=reporterService.generateLeaveId();
		assertEquals(result.length(),4);
	}

	/**
	 * Test method for {@link com.niit.ocs.service.impl.ReporterServiceImpl#addLeave(com.niit.ocs.bean.LeaveBean)}.
	 */
	@Test
	public void testAddLeave() {
		reporterDao=mock(ReporterDaoImpl.class);
		leaveBean=new LeaveBean("11111","Bhanu","ra1234",LocalDate.now(),LocalDate.now(),"going home",0);
		when(reporterDao.createLeave(leaveBean)).thenReturn("SUCCESS");
		reporterService=new ReporterServiceImpl(reporterDao);
		assertEquals(reporterService.addLeave(leaveBean),"SUCCESS");
		
	}

	/**
	 * Test method for {@link com.niit.ocs.service.impl.ReporterServiceImpl#viewAllAvailableDoctors(java.time.LocalDate)}.
	 */
	@Test
	public void testViewAllAvailableDoctors() {
		reporterDao=mock(ReporterDaoImpl.class);
		ArrayList<DoctorBean> expectedFromFindDoctorByDate=new ArrayList<DoctorBean>();
		doctorBean=new DoctorBean("1590","Ghanshyam","1993-11-09","2015-04-12","Male","MD","surgery","6","sdf","hj","ghj","ghj","987654","9876543214","fdhjghj@gmail.com");
		expectedFromFindDoctorByDate.add(doctorBean);
		when(reporterDao.findDoctorByDate(LocalDate.now())).thenReturn(expectedFromFindDoctorByDate);
		reporterService=new ReporterServiceImpl(reporterDao);
		assertEquals(reporterService.viewAllAvailableDoctors(LocalDate.now()),expectedFromFindDoctorByDate);
		
		 
	}

}
