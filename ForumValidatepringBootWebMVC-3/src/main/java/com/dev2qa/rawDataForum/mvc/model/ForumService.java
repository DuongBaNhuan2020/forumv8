package com.dev2qa.rawDataForum.mvc.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ForumService {
	private Map<String,User> users;
	private Map<Integer, Topic> topics;
	public ForumService(Map<String, User> users, Map<Integer, Topic> topics) {
		super();
		this.users = users;
		this.topics = topics;
	}
	public ForumService() {
		super();
	}
	
	public Map<String, User> getUsers() {
		return users;
	}
	public void setUsers(Map<String, User> users) {
		this.users = users;
	}
	//get topics
	public Collection<Topic> getTopics(){
		return this.topics.values();
	}
	//check user
	public User checkUser(String name, String password) {
		for( String a: users.keySet()) {
			if(a.equalsIgnoreCase(name)) {
				User user=users.get(a);
				String pass=user.getPassword();
				if(pass.equalsIgnoreCase(password)) {
					return users.get(a);
				}
			}
		}
		return new User();
	}
	//find Topic
	public Topic findTopic(Integer id) {
		for(Integer a:topics.keySet()) {
			if(a.equals(id)) {
				return topics.get(a);
			}
		}
		return new Topic();
	}
	//Data for forum
	
	public void initData() {
		//Calendar
		Calendar cal = Calendar.getInstance();
		//user
				User user1=new User("user1", "user1password", "user1@gmail.com",cal);
				User user2=new User("user2", "user2password", "user2@gmail.com", cal);
				User user3=new User("user3", "user3password", "user3@gmail.com", cal);
				User user4=new User("user4", "user4password", "user4@gmail.com", cal);
				User user5=new User("user5", "user5password", "user5@gmail.com", cal);
				
				//catagory
				Category category1=new Category("Chuyen hoc phi", new Category(), new ArrayList<Category>());
				
				
				
				//Message
					//message1
				Message message1=new Message("message1", "Nội dung message 1", cal, user1);
				Message message2=new Message("message2", "Nội dung message 2", cal, user1);
				Message message3=new Message("message3", "Nội dung message 3", cal, user1);
				Message message4=new Message("message4", "Nội dung message 4", cal, user1);
				Message message5=new Message("message5", "Nội dung message 5", cal, user1);
				
				Stack<Message> messages=new Stack<Message>();
				messages.add(message1);
				messages.add(message2);
				messages.add(message3);
				messages.add(message4);
				messages.add(message5);
					//message2
				Message message1_1=new Message("message1", "Nội dung message 1", cal, user2);
				Message message1_2=new Message("message2", "Nội dung message 2", cal, user2);
				Message message1_3=new Message("message3", "Nội dung message 3", cal, user2);
				Message message1_4=new Message("message4", "Nội dung message 4", cal, user2);
				Message message1_5=new Message("message5", "Nội dung message 5", cal, user2);
				
				Stack<Message> messages2=new Stack<Message>();
				messages2.add(message1_1);
				messages2.add(message1_2);
				messages2.add(message1_3);
				messages2.add(message1_4);
				messages2.add(message1_5);
				
				//Tocpic
				Topic topic1=new Topic("Chủ đề 1", "Nội dung chủ đề 1", cal, user1, 1,  messages, category1);
				Topic topic2=new Topic("Chủ đề 2", "Nội dung chủ đề 2", cal, user2, 2,  messages2, category1);
				
		//users
		
		users.put("user1", user1);
		users.put("user2", user2);
		users.put("user3", user3);
		users.put("user4", user4);
		users.put("user5", user5);
		
			//topics
		
		topics.put(1, topic1);
		topics.put(2, topic2);
	}

	//add Topic
	public void addTopic(Topic topic) {
		Integer numKey=0;
		for(Topic a:topics.values()) {
			numKey=a.getId();
		}
		this.topics.put(numKey+1, topic);
	}
	public static void main(String[] args) {
		Map<String, User> users1=new HashMap<String, User>();
	
			//topics
		Map<Integer,Topic> topics1=new HashMap<Integer, Topic>();
		
		ForumService forumService=new ForumService(users1, topics1);
		forumService.initData();
		System.out.println(forumService.users);
	}
}
