package com.niit.ocs.dao;

import com.niit.ocs.bean.CredentialsBean;

public interface AuthenticationDao {
	public boolean authenticateDb(CredentialsBean credentialsBean);
	public String authorizeDb(String userId);
	public boolean changeLoginStatusDb(CredentialsBean user,int loginStatus);
}
