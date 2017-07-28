package com.hj.pers.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(name=("/resource"))
public class ResourceController {

	@RequestMapping(name=("/"))
	public String classes(HttpServletRequest request){
		
		return "/resource";
		
	}
}
