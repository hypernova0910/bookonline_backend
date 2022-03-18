package com.hieu.backend.dto;

public class CustomerSignInDTO {
	private String phoneOrEmail;
	private String password;
	
	public String getPhoneOrEmail() {
		return phoneOrEmail;
	}
	public void setPhoneOrEmail(String phoneOrEmail) {
		this.phoneOrEmail = phoneOrEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
