package com.dev2qa.rawDataForum.mvc.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dev2qa.rawDataForum.mvc.model.Category;
import com.dev2qa.rawDataForum.mvc.model.ForumService;
import com.dev2qa.rawDataForum.mvc.model.Message;
import com.dev2qa.rawDataForum.mvc.model.Topic;
import com.dev2qa.rawDataForum.mvc.model.User;



@Controller
public class TopicController {

	private ForumService forumServic=new UserController().getForumService();
	
	
	@RequestMapping(value={"/topicList"})
	public ModelAndView home() {
		Collection<Topic> listTopic = forumServic.getTopics();
		ModelAndView mav = new ModelAndView("topic_list");
		
		mav.addObject("listTopic", listTopic);
		for(Topic a:listTopic) {
			System.out.println("vao listTopic:"+a.getTitle()+"/"+a.getId());
		}
		
		return mav;
	}
	@RequestMapping("/newTopic")
	public String newTopicForm(Map<String, Object> model) {
		Topic topic = new Topic();
		model.put("topic", topic);
		return "forum_topic_new";
	}
	@RequestMapping(value = "/saveTopic", method = RequestMethod.POST)
	public String saveNewTopic(@ModelAttribute("topic") @Validated Topic topic,BindingResult result,HttpSession session) {
		if (result.hasErrors()) {
			
			return "forum_topic_new";
		}
		Integer numKey=0;
		for(Topic a:forumServic.getTopics()) {
			numKey=a.getId();
		}
		User user1=(User) session.getAttribute("user");
		topic.setCreater(user1);
		topic.setCreatedTime(Calendar.getInstance());
		topic.setId(numKey+1);
		topic.setCategory(new Category());
		topic.setMessages(new Stack<Message>());
		forumServic.addTopic(topic);
		return "redirect:/topicList";
	}
	
	//Reply message controller

	@RequestMapping("/detailTopic")
	public ModelAndView detailTopic( @RequestParam Integer top_id) {
		Topic topic=forumServic.findTopic(top_id);
		List<Message> listReply =topic.getMessages() ;
		ModelAndView mav = new ModelAndView("forum_show_topic");
		User author=topic.getCreater();
		
		mav.addObject("listReply", listReply);
		mav.addObject("author", author);
		mav.addObject("firsttopic", topic);
		return mav;
		
	}
	@RequestMapping("/newReply")
	public String newReplyForm(Map<String, Object> model, @RequestParam Integer top_id) {
		Message replyTopic = new Message();
		Topic topic=forumServic.findTopic(top_id);
		model.put("replytopic", replyTopic);
		model.put("topic", topic);
		return "forum_reply_topic_new";
	}
	@RequestMapping(value = "/saveReplyMessage", method = RequestMethod.POST)
	public String saveReplyMessage(@ModelAttribute("replytopic") @Validated Message replyMessage, BindingResult result,Map<String, Object> model,@RequestParam Integer top_id,HttpSession session) {
		if (result.hasErrors()) {
			Topic topic=forumServic.findTopic(top_id);
			User user=(User) session.getAttribute("user");
			model.put("topic", topic);
			model.put("user",user);
			return "forum_reply_topic_new";
		}
		User user1=(User) session.getAttribute("user");
		replyMessage.setCreater(user1);
		replyMessage.setCreatedTime(Calendar.getInstance());
		
		Topic topic1=forumServic.findTopic(top_id);
		System.out.println("topic id duoc luu la:"+top_id);
		topic1.addMessage(replyMessage);
		return "redirect:/detailTopic?top_id="+top_id;
	}
}
