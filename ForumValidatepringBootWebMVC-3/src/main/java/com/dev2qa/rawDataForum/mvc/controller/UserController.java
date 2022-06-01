package com.dev2qa.rawDataForum.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev2qa.rawDataForum.mvc.model.ForumService;
import com.dev2qa.rawDataForum.mvc.model.Topic;
import com.dev2qa.rawDataForum.mvc.model.User;



@Controller
public class UserController {
	Map<String, User> users1=new HashMap<String, User>();
	
	//topics
	Map<Integer,Topic> topics1=new HashMap<Integer, Topic>();

	private ForumService forumService=new ForumService(users1, topics1);
	
	@RequestMapping(value={"/new", "/"})
	public String newUserForm(Map<String, Object> model) {
		User user=new User();
		model.put("user", user);
		System.out.println("co vao day /new");
		return "forum_login";
	}
	@RequestMapping(value = {"/new","login","/saveuser"}, method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") @Validated User user,BindingResult result,Map<String, Object> model,HttpSession session) {
		forumService.initData();
		
		if (result.hasErrors()) {
			return "forum_login";
		}
		
		
		for(User u:forumService.getUsers().values()) {
			if(u.getUserName().equalsIgnoreCase((user.getUserName()))&& u.getPassword().equalsIgnoreCase((user.getPassword()))) {
				User userCheck=forumService.checkUser(user.getUserName(), user.getPassword());
				session.setAttribute("user", userCheck);
				return "redirect:/topicList";
			}	
		}
		 model.put("error", "Invalid user");
		return "forum_login";
	}
	@RequestMapping(value={ "/logout"})
	public String logout(HttpSession session) {
		 session.removeAttribute("username");
		return "redirect:/";
	}
	
	//get forumservice
	public ForumService getForumService() {
		this.forumService.initData();
			return this.forumService;
	}
	//get forumservice after update
	public ForumService getForumServiceAfter() {
			return this.forumService;
	}
}
