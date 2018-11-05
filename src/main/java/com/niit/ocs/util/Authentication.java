package com.niit.ocs.util;

import com.niit.ocs.bean.CredentialsBean;

public interface Authentication {

	public boolean authenticate(CredentialsBean credentialsBean);
	public String authorize(String userId);
	public boolean changeLoginStatus(CredentialsBean user,int loginStatus);
}
