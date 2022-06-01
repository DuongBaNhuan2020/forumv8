package com.dev2qa.rawDataForum.mvc.forumData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.dev2qa.rawDataForum.mvc.model.Category;
import com.dev2qa.rawDataForum.mvc.model.Message;
import com.dev2qa.rawDataForum.mvc.model.Topic;
import com.dev2qa.rawDataForum.mvc.model.User;

public class ForumData {
	public ForumData() {
	}
	public static void data() {
		//Calendar
		Calendar cal = Calendar.getInstance();
		//user
		User user1=new User("user1", "user1password", "user1@gmail.com", cal);
		User user2=new User("user2", "user2password", "user2@gmail.com", cal);
		User user3=new User("user3", "user3password", "user3@gmail.com", cal);
		User user4=new User("user4", "user4password", "user4@gmail.com", cal);
		User user5=new User("user5", "user5password", "user5@gmail.com", cal);
		
		//catagory
		Category category1=new Category("Chuyen hoc phi", new Category(), new ArrayList<Category>());
		
		
		
		//Message
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
		
		//Tocpic
		Topic topic1=new Topic("Chủ đề 1", "Nội dung chủ đề 1", cal, user1, 1,  messages, category1);
		Topic topic2=new Topic("Chủ đề 2", "Nội dung chủ đề 2", cal, user2, 2,  messages, category1);
		
		//Forum service
			//users
		Map<String, User> users1=new HashMap<String, User>();
		users1.put("user1", user1);
		users1.put("user2", user2);
		users1.put("user3", user3);
		users1.put("user4", user4);
		users1.put("user5", user5);
		
			//topics
		Map<Integer,Topic> topics1=new HashMap<Integer, Topic>();
		topics1.put(1, topic1);
		topics1.put(2, topic2);
	}
	
}
