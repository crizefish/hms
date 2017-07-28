package com.hj.pers.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.hj.pers.entites.User;
import com.hj.pers.service.DemoService;

/**
 * 
 * 测试类.
 * 
 * @author Angel(QQ:412887952)
 * 
 * @version v.0.1
 * 
 */

@Controller

public class DemoController {

	@Autowired

	DemoService demoInfoService;

	@RequestMapping("/test")

	public @ResponseBody String test() {

		User loaded = demoInfoService.findById(1);

		System.out.println("loaded=" + loaded);

		User cached = demoInfoService.findById(1);

		System.out.println("cached=" + cached);

		loaded = demoInfoService.findById(2);

		System.out.println("loaded2=" + loaded);

		return "ok";

	}

	@RequestMapping("/delete")

	public @ResponseBody String delete(long id) {

		demoInfoService.deleteFromCache(id);

		return "ok";

	}

	@RequestMapping("/test1")

	public @ResponseBody String test1() throws InterruptedException {

		demoInfoService.test();

		System.out.println("DemoInfoController.test1()");

		return "ok";

	}

}