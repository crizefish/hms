package com.hj.pers.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hj.pers.pojo.article.Common;
import com.hj.pers.service.OtherService;
@Controller
@RequestMapping("/other")
public class OtherController {

	@Autowired
	private OtherService o;
	
	  @RequestMapping(value="/search", produces = "application/json; charset=utf-8")
	    public String search(HttpServletRequest request,Model m) {
		  String keyWord = request.getParameter("keyWord");
		  List<Common> common = o.searchByKeyWord(keyWord);
		  m.addAttribute("info",common);
		  m.addAttribute("keyWord",keyWord);
	    	return "/search/search"; 
	    } 
	  @RequestMapping(value="/index", produces = "application/json; charset=utf-8")
	  public String index(HttpServletRequest request,Model m) {
		  return "/search/index"; 
	  } 
}
