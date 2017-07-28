package com.hj.pers.controller;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hj.pers.entites.Blogger;
import com.hj.pers.service.BloggerService;
@Controller
@RequestMapping("/hello")
public class BloggerController {
	@Autowired 
	BloggerService bs;
	private static Logger logger = LoggerFactory.getLogger(BloggerController.class);

	private String AJAX_STATUS_SUCCESS = "1";
	private String AJAX_STATUS_FAIL = "0";

	    @RequestMapping("/")
	    String home() {
	    	return"/index"; 
	    }
	    @RequestMapping("/blogger")
	    String home1(Model m) {
	    	List<Blogger> bloggers = bs.queryRecentBlogger(5L);
	    	m.addAttribute("bloggers", bloggers);
	    	return"/blogger"; 
	    } 
	    @RequestMapping("/detail")
	    String detail(HttpServletRequest request,String bloggerId,Model m) {
	    	if(bloggerId!=null&&!"".equals(bloggerId)){
	    		Long id = Long.parseLong(bloggerId);
	    		Blogger b= bs.findOne(id);
	    		m.addAttribute("blogger", b);
	    	}
	    	return"/bloggerDetail"; 
	    }
	    @RequestMapping("/save")
	    @ResponseBody
	    public Map<String, String> save(@ModelAttribute Blogger blogger,HttpServletRequest request) {
	    	Map< String,String> msg = new Hashtable<>();
	    	blogger.setCreateDate(new Date());
	    	try{
	    		blogger = bs.save(blogger);
	    	}catch(Exception e){
	    		logger.error(e.getMessage(),e);
	    		msg.put("msg",AJAX_STATUS_FAIL);
	    	}
	    	msg.put("msg",AJAX_STATUS_SUCCESS);
	    	msg.put("id", String.valueOf(blogger.getId()));
	    	return msg; 
	    }
	    @RequestMapping("/query")
	    @ResponseBody
	    public Map<String, String> save(String keyword,Model model) {
	    	Map< String,String> msg = new Hashtable<>();
	    	List<Blogger> bloggers = bs.queryBloggerByWord(keyword);
	    	if(bloggers.size()>0){
	    		model.addAttribute("bloggers",bloggers);
	    		msg.put("msg",AJAX_STATUS_SUCCESS);    		
	    	}else{
	    		msg.put("msg",AJAX_STATUS_FAIL);
	    	}
	    	return msg; 
	    }
}
