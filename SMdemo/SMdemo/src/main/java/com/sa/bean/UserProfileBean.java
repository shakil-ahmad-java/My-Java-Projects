package com.sa.bean;

public class UserProfileBean {

	private String fullname;
	private String email;
	private String Mobile;
	private String password;
	private String dob;
		
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "UserProfile [fullname=" + fullname + ", email=" + email + ", Mobile=" + Mobile
				+ ", password=" + password + ", dob=" + dob + "]";
	}
}
