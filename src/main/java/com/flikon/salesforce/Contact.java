package com.flikon.salesforce;

public class Contact {
	
	private boolean CreateUser;
	private String UserName;
	private String Password;
	private String ContactFirstName;
	private String LastName;
	private String ContactEmail;
	private String ContactPhone;

	public boolean isCreateUser() {
		return CreateUser;
	}
	public void setCreateUser(boolean createUser) {
		CreateUser = createUser;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getContactFirstName() {
		return ContactFirstName;
	}
	public void setContactFirstName(String contactFirstName) {
		ContactFirstName = contactFirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getContactEmail() {
		return ContactEmail;
	}
	public void setContactEmail(String contactEmail) {
		ContactEmail = contactEmail;
	}
	public String getContactPhone() {
		return ContactPhone;
	}
	public void setContactPhone(String contactPhone) {
		ContactPhone = contactPhone;
	} 
}
