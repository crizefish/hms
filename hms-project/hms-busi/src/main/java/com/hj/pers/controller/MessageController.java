package com.hj.pers.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hj.pers.entites.impl.Message;
import com.hj.pers.service.MessageService;
@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService ms;
	
	@RequestMapping(name=("/"))
	public String blogger(HttpServletRequest request){
		return "/message/message";
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
