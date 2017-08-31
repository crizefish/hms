package com.hj.pers.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hj.pers.entites.User;
import com.hj.pers.service.UserService;

@Controller
@RequestMapping("/user")
class Restcontroller {
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView create(HttpServletRequest request,HttpServletResponse response,User user){
		userService.save(user);
	return new ModelAndView("/index","user",user);
	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView show(HttpServletRequest request,HttpServletResponse response,User user){
		userService.save(user);
		return new ModelAndView("/index","user",user);
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response,User user){
		userService.save(user);
		return new ModelAndView("/index","user",user);
	}
	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView put(HttpServletRequest request,HttpServletResponse response,User user){
		userService.save(user);
		return new ModelAndView("/index","user",user);
	}
}