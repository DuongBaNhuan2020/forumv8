package com.dev2qa.rawDataForum.mvc.model;

import java.util.Calendar;
import java.util.Stack;

public class Topic extends Entry {
	private Integer id;
	private Stack<Message> messages;
	private Category category;
	
	
	public Topic(String string, String string2, Calendar cal, User user1, Integer id, Stack<Message> messages, Category category) {
		super(string2, string2, cal, user1);
		this.id = id;
		this.messages = messages;
		this.category = category;
	}

	public Topic() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Stack<Message> getMessages() {
		return messages;
	}

	public void setMessages(Stack<Message> messages) {
		this.messages = messages;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	//add messages
	public void addMessage(Message message) {
		this.messages.add(message);
	}
	//get new message
	public Message getNewMessage() {
		return this.messages.lastElement();
	}
}
