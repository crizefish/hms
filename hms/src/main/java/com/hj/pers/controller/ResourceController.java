package com.hj.pers.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/resource")
public class ResourceController {

	  @RequestMapping("/")
	public String classes(HttpServletRequest request){
		
		return "/resource/resource";
		
	}
}
