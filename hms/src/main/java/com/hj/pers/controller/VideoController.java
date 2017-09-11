package com.hj.pers.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/video")
public class VideoController {

	@RequestMapping("/")
	public String blogger(HttpServletRequest request){
		
		return "/video/video";
	}
}
