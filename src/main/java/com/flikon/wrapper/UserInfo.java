package com.flikon.wrapper;

public class UserInfo {

    private String email;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String password;
    private String passwordConfirm;

	public UserInfo() {
	}

	public UserInfo(String email, String firstName, String lastName, String contactNo, String password, String passwordConfirm, String salesforceStatus) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
}
