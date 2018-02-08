package com.hj.pers.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hj.pers.entites.impl.Message;
import com.hj.pers.service.MessageService;
@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService ms;
	
	@RequestMapping("/")
	String home1(Model m, @RequestParam(value = "startPage", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "4") Integer size) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page==0?0:page-1, size, sort);
		Page<Message> init = ms.findPageMessage(pageable);
		m.addAttribute("m",init);
		return "/message/message";
	}
	 @RequestMapping(value="/pageInfo", produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	 @ResponseBody
	public Map<String,Object> page(@RequestParam(value = "startPage", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "4") Integer size) {
		  Map<String,Object> m = new HashMap<String,Object>();
		  Sort sort = new Sort(Direction.DESC, "id");
			Pageable pageable = new PageRequest(page==0?0:page-1, size, sort);
		Page<Message> p = ms.findPageMessage(pageable);
		m.put("content",p);
		return m;
	}
	
	  @RequestMapping(value="/comment", method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	  @ResponseBody
	  public Map<String, Object> comment(@RequestBody Message com) {
		  Map<String,Object> m = new HashMap<String,Object>();
		  Message c = ms.saveMessage(com);
		  m.put("comment",c);
		  m.put("msg",1);
		return m;
	  } 
	
}
