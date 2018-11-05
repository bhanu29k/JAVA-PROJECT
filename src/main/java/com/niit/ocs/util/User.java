package com.niit.ocs.util;

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.bean.ProfileBean;

public interface User {
	
public String login(CredentialsBean credentialsBean);
boolean logout(String userId);
String changePassword(CredentialsBean credentialsBean,String str );
String register(ProfileBean  profileBean);
}
