package com.hj.pers.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/other")
public class OtherController {

	@RequestMapping("/top")
	@ResponseBody
	public String top(HttpServletRequest request){
		
		return "/video/video";
	}
	@RequestMapping("/recommend")
	@ResponseBody
	public String blogger(HttpServletRequest request){
		
		return "/video/video";
	}
}
