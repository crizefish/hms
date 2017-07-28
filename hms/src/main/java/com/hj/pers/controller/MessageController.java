package com.hj.pers.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(name=("/message"))
public class MessageController {

	@RequestMapping(name=("/"))
	public String blogger(HttpServletRequest request){
		
		return "/message";
	}
}
