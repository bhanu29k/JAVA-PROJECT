package com.niit.ocs.util;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.dao.AuthenticationDao;
import com.niit.ocs.dao.impl.AuthenticationDaoImpl;
import com.niit.ocs.util.impl.AuthenticationImpl;

public class AuthenticationImplTest {

	AuthenticationDao authenticationDao;
	CredentialsBean credentialsBean;
	AuthenticationImpl authentication;
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
	public void testAuthenticate() {
		authenticationDao=mock(AuthenticationDaoImpl.class);
		credentialsBean=new CredentialsBean();
		credentialsBean.setPassword("72053");
		credentialsBean.setPassword("Bhanu@1234");
		when(authenticationDao.authenticateDb(credentialsBean)).thenReturn(true);
		authentication=new AuthenticationImpl(authenticationDao);
		boolean result=authentication.authenticate(credentialsBean);
		assertTrue(result);
	}

	@Test
	public void testAuthorize() {
		authenticationDao=mock(AuthenticationDaoImpl.class);
		when(authenticationDao.authorizeDb("72053")).thenReturn("A");
		authentication=new AuthenticationImpl(authenticationDao);
		String result=authentication.authorize("72053");
		assertEquals(result,"A");
	}

	@Test
	public void testChangeLoginStatus() {
		authenticationDao=mock(AuthenticationDaoImpl.class);
		credentialsBean=new CredentialsBean();
		credentialsBean.setPassword("72053");
		credentialsBean.setPassword("Bhanu@1234");
		when(authenticationDao.changeLoginStatusDb(credentialsBean,0)).thenReturn(true);
		authentication=new AuthenticationImpl(authenticationDao);
		boolean result=authentication.changeLoginStatus(credentialsBean,0);
		assertTrue(result);
		
	}

}
