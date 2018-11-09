package com.niit.ocs.util.impl;



import org.apache.log4j.Logger;

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.bean.ProfileBean;
import com.niit.ocs.dao.CredentialsBeanDao;
import com.niit.ocs.dao.ProfileDao;
import com.niit.ocs.dao.impl.CredentialsBeanDaoImpl;
import com.niit.ocs.dao.impl.ProfileDaoImpl;
import com.niit.ocs.util.Authentication;
import com.niit.ocs.util.User;

public class UserImpl implements User {
	static Logger loggr=Logger.getLogger(UserImpl.class);
	ProfileDao profileDao;
	/**
	 * @param profileDao
	 */
	public UserImpl(ProfileDao profileDao) {
		super();
		this.profileDao = profileDao;
	}


	CredentialsBeanDao credentialsBeanDao;
	Authentication authenticationObj;
	public UserImpl() {
		
		authenticationObj=new AuthenticationImpl();
		credentialsBeanDao=new CredentialsBeanDaoImpl();
		profileDao=new ProfileDaoImpl();
	}
	
	
	/**
	 * @param authenticationObj
	 */
	public UserImpl(Authentication authenticationObj,CredentialsBeanDao credentialsBeanDao) {
		super();
		this.authenticationObj = authenticationObj;
		this.credentialsBeanDao = credentialsBeanDao;
		
	}

	public String login(CredentialsBean credentialsBean) {
		
		loggr.info("login is working");
		if(authenticationObj.authenticate(credentialsBean))
		{
			
			 String a =authenticationObj.authorize(credentialsBean.getUserID());
			 authenticationObj.changeLoginStatus(credentialsBean, 0);
				return a;  
			 	
		}
		else return "INVALID";
		
	}

	
	
	public boolean logout(String userId) {
		
		loggr.info("logout is working");
		
		CredentialsBean credentialsBean=credentialsBeanDao.findByID(userId);
		return authenticationObj.changeLoginStatus( credentialsBean ,1);

		 
	}

	
	public String changePassword(CredentialsBean credentialsBean, String str) {
		loggr.info("changepassword is working");
		//credentialsBeanDao=new CredentialsBeanDaoImpl();
		if(credentialsBeanDao.updateCredentialBeanDao(credentialsBean))
		return "Successfull password changed";
		else return "Fail";
	}


	public String register(ProfileBean profileBean) {
		loggr.info("register is working");
		return profileDao.createProfile(profileBean);
		
	}

	

	
	
	
}
