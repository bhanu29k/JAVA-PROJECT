package com.niit.ocs.bean;

public class CredentialsBean {
private String userID;
private String password;
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public CredentialsBean(String userID, String password) {
	super();
	this.userID = userID;
	this.password = password;
}
/**
 * 
 */
public CredentialsBean() {
	super();
	// TODO Auto-generated constructor stub
}


}
