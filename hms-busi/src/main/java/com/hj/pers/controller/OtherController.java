package com.hj.pers.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hj.pers.entites.impl.Comment;
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
		  String trim = keyWord.trim();
		  if(trim.contains("'")){
			  trim = "";
		  }
		  List<Common> common = o.searchByKeyWord(trim);
		  m.addAttribute("info",common);
		  m.addAttribute("keyWord",keyWord);
	    	return "/search/search"; 
	    } 
	  
	  @RequestMapping(value="/comment", method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	  @ResponseBody
	  public Map<String, Object> comment(@RequestBody Comment com) {
		  Map<String,Object> m = new HashMap<String,Object>();
		  Comment c = o.saveComment(com);
		  m.put("comment",c);
		  m.put("msg",1);
		return m;
	  } 
	  
	  @RequestMapping(value="/index", produces = "application/json; charset=utf-8")
	  public String index(HttpServletRequest request,Model m) {
		  return "/search/index"; 
	  } 
}
