package com.niit.ocs.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.bean.ProfileBean;
import com.niit.ocs.dao.CredentialsBeanDao;
import com.niit.ocs.dao.ProfileDao;
import com.niit.ocs.dao.impl.CredentialsBeanDaoImpl;
import com.niit.ocs.dao.impl.ProfileDaoImpl;
import com.niit.ocs.util.impl.AuthenticationImpl;
import com.niit.ocs.util.impl.UserImpl;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
public class UserImplTest {

	User user;
	CredentialsBeanDao credentialsBeanDao;
	CredentialsBean credentialsBean;
	ProfileBean profileBean;
	ProfileDao profileDao;
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
	public void testLogin() {
		credentialsBean= new CredentialsBean();
	
		credentialsBeanDao=mock(CredentialsBeanDaoImpl.class);
		credentialsBean.setUserID("72053");
		credentialsBean.setPassword("Bhanu@1234");
		Authentication authenticationObj;
		authenticationObj=mock(AuthenticationImpl.class);
		when(authenticationObj.authenticate(credentialsBean)).thenReturn(true);
		when(authenticationObj.authorize(credentialsBean.getUserID())).thenReturn("A");
		when(authenticationObj.changeLoginStatus(credentialsBean, 0)).thenReturn(true);
		user=new UserImpl(authenticationObj,credentialsBeanDao);
		String userType=user.login(credentialsBean);
		assertEquals(userType,"A");
		
	}

	@Test
	public void testLogout() {
		credentialsBeanDao=mock(CredentialsBeanDaoImpl.class);
		credentialsBean=new CredentialsBean();
		credentialsBean.setPassword("Bhanu@1234");
		credentialsBean.setUserID("72053");
		
		when(credentialsBeanDao.findByID("72053")).thenReturn(credentialsBean);
		Authentication authenticationObj;
		authenticationObj=mock(AuthenticationImpl.class);
		
		when(authenticationObj.changeLoginStatus(credentialsBean, 1)).thenReturn(true);
		
		user=new UserImpl(authenticationObj,credentialsBeanDao);
		boolean result=user.logout("72053");
		assertTrue(result);
		
		
	}

	@Test
	public void testChangePassword() {
		credentialsBeanDao=mock(CredentialsBeanDaoImpl.class);
		credentialsBean=new CredentialsBean();
		credentialsBean.setUserID("72053");
		credentialsBean.setPassword("Bhanu@123");
		when(credentialsBeanDao.updateCredentialBeanDao(credentialsBean)).thenReturn(true);
		Authentication authenticationObj=new AuthenticationImpl();
		user=new UserImpl(authenticationObj,credentialsBeanDao);
		String result=user.changePassword(credentialsBean, "Bhanu@123");
		assertEquals(result,"Successfull password changed");
		
	}

	@Test
	public void testRegister() {
		profileDao=mock(ProfileDaoImpl.class);
		profileBean=new ProfileBean();
		profileBean.setFirstName("Stuart");
		profileBean.setLastName("Binny");
		profileBean.setDateOfBirth("1995-12-24");
		profileBean.setGender("Male");
		profileBean.setStreet("xyz");
		profileBean.setLocation("xyz");
		profileBean.setCity("xyz");
		profileBean.setState("xyz");
		profileBean.setPincode("123456");
		profileBean.setMobileNo("8746539292");
		profileBean.setEmailID("ffbj@gmail.com");
		profileBean.setPassword("Bhanu@123");
		profileBean.setUserID();
		when(profileDao.createProfile(profileBean)).thenReturn(profileBean.getUserID());
		user=new UserImpl(profileDao); 
		String result=user.register(profileBean);
		assertEquals(result,profileBean.getUserID());
	}

}
