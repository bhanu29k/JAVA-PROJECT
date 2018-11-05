package com.niit.ocs.dao;

import com.niit.ocs.bean.CredentialsBean;

public interface CredentialsBeanDao {
 public CredentialsBean findByID(String str);
 public boolean updateCredentialBeanDao(CredentialsBean credentialsBean);
}
