package com.hj.pers.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(name=("/photo"))
public class PhotoController {

	@RequestMapping(name=("/"))
	public String blogger(HttpServletRequest request){
		
		return "/photo";
	}
}
