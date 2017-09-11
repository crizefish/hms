package com.hj.pers.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/message")
public class MessageController {

	@RequestMapping(name=("/"))
	public String blogger(HttpServletRequest request){
		
		return "/message/message";
	}
}
