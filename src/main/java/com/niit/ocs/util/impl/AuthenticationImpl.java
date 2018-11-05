package com.niit.ocs.util.impl;


import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.dao.AuthenticationDao;
import com.niit.ocs.dao.impl.AuthenticationDaoImpl;
import com.niit.ocs.util.Authentication;


public class AuthenticationImpl implements Authentication {
	
	String str1;
	AuthenticationDao authenticationDao;
	public AuthenticationImpl() {
		
		authenticationDao=new AuthenticationDaoImpl();
	}
	
	
	/**
	 * @param authenticationDao
	 */
	public AuthenticationImpl(AuthenticationDao authenticationDao) {
		super();
		this.authenticationDao = authenticationDao;
	}


	public AuthenticationImpl(String str1) {
		this.str1 = str1;
	}
	
	
	
	public boolean authenticate(CredentialsBean credentialsBean) 
	{
		return authenticationDao.authenticateDb(credentialsBean);	
	}

	
	public String authorize(String userId) 
	{	
		return authenticationDao.authorizeDb(userId);	 
	}


	public boolean changeLoginStatus(CredentialsBean user,int loginStatus)
	{
		return authenticationDao.changeLoginStatusDb(user, loginStatus);
	}
}
  