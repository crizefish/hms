package com.hj.pers.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
	private static Logger logger = LoggerFactory.getLogger(BloggerController.class);

		/**首页
		 * 
		 * @param m
		 * @return
		 */
	    @RequestMapping(name="/")
	    String home1(Model m) {
	    	logger.info("");
	    	return"/index/index"; 
	    } 
	    }
	    