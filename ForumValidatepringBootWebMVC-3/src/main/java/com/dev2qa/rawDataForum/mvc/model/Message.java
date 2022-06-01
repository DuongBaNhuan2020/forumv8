package com.dev2qa.rawDataForum.mvc.model;

import java.util.Calendar;


public class Message extends Entry {
	public Message(String title, String content, Calendar createdTime, User creater) {
		super(content, content, createdTime, creater);
		
	}
	public Message() {
		
	}
}
