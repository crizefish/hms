package com.hj.pers.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/note")
public class NoteController {

	@RequestMapping("/")
	public String blogger(HttpServletRequest request){
		
		return "/note/note";
	}
}
