package com.dev2qa.rawDataForum.mvc.model;

import java.util.Calendar;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public abstract class Entry {
	@NotBlank(message = "Not null")
	protected String title;
	@NotBlank(message = "Not null")
	protected String content;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Calendar createdTime;
	protected User creater;

	public Entry(String title, String content, Calendar createdTime, User creater) {
		super();
		this.title = title;
		this.content = content;
		this.createdTime = createdTime;
		this.creater = creater;
	}
	
	public Entry() {
		super();
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Calendar getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}
	public User getCreater() {
		return creater;
	}
	public void setCreater(User creater) {
		this.creater = creater;
	}
	

}
