package com.niit.ocs.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.dao.impl.AuthenticationDaoImpl;

public class AuthenticationDaoImplTest {

	AuthenticationDao authenticationDao=new AuthenticationDaoImpl();
	CredentialsBean credentialsBean;
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
	public void testAuthenticateDb() {
		
		credentialsBean=new CredentialsBean("72053","Bhanu@123");
		boolean result=authenticationDao.authenticateDb(credentialsBean);
		assertTrue(result);
		credentialsBean=new CredentialsBean("72053","Bhanu@1234");
		result=authenticationDao.authenticateDb(credentialsBean);
		assertFalse(result);
	}

	@Test
	public void testAuthorizeDb() {
		String id="72053";
		String result=authenticationDao.authorizeDb(id);
		assertEquals(result,"A");
		id="Go4741";
		result=authenticationDao.authorizeDb(id);
		assertEquals(result,"P");
		id="11111";
		result=authenticationDao.authorizeDb(id);
		assertEquals(result,"R");
		id="72054";
		result=authenticationDao.authorizeDb(id);
		assertEquals(result,"");
		
	}

	@Test
	public void testChangeLoginStatusDb() {
		credentialsBean=new CredentialsBean("72053","Bhanu@1234");
		int loginStatus=1;
		boolean result=authenticationDao.changeLoginStatusDb(credentialsBean, loginStatus);
		assertTrue(result);
		credentialsBean=new CredentialsBean("72053","Bhanu@1234");
		loginStatus=1;
		result=authenticationDao.changeLoginStatusDb(credentialsBean, loginStatus);
		assertTrue(result);
		
		
	}

}
