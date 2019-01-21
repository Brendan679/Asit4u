package com.service.user;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	String userID;
	String password;
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
	

}
