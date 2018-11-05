package com.niit.ocs.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.dao.impl.CredentialsBeanDaoImpl;

public class CredentialsBeanDaoImplTest {
	CredentialsBean credentialsBean;
	CredentialsBeanDao credentialsBeanDao;
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
	public void testFindByID() {
	credentialsBeanDao=new CredentialsBeanDaoImpl();
	credentialsBean=credentialsBeanDao.findByID("99999");
	assertEquals(credentialsBean.getPassword(),"Rakesh@123");
	}

	@Test
	public void testUpdateCredentialBeanDao() {
		credentialsBean=new CredentialsBean("72053","Bhanu@123");
		credentialsBeanDao=new CredentialsBeanDaoImpl();
		boolean result=credentialsBeanDao.updateCredentialBeanDao(credentialsBean);
		assertTrue(result);
		
	}

}
