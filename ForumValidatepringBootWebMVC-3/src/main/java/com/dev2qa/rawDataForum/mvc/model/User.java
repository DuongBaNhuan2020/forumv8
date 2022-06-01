package com.dev2qa.rawDataForum.mvc.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;





public class User {
	@NotBlank(message = "Not null")
	private String userName;
	@NotBlank(message = "Not null")
	private String password;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar joinDate;
	public User(String userName, String password, String email, Calendar joinDate) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.joinDate = joinDate;
	}
	public User() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Calendar joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
