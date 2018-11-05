package com.niit.ocs.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.dao.impl.DoctorDaoImpl;

public class DoctorDaoImplTest {
	DoctorDao doctorDao;
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
	public void testCreateDoctor() {
		doctorDao=new DoctorDaoImpl();
		doctorBean=new DoctorBean("ra1235","Harisingh","1986-10-23","2016-06-28","Male","MBBS","Medicine","4","Techzone","Noida","noida","up","201310","9876543221","harisingh@gmail.com");
		String result=doctorDao.createDoctor(doctorBean);
		assertEquals(result,"success");
	}

	@Test
	public void testFindByID() {
	String id="Ma6293";
	doctorDao=new DoctorDaoImpl();
	doctorBean=doctorDao.findByID(id);
	assertEquals(doctorBean.getDoctorName(),"Mansingh");
	}

	@Test
	public void testUpdateDoctor() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDeleteDoctor() {
		fail("Not yet implemented"); // TODO
	}

}
