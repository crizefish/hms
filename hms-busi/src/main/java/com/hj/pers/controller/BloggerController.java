package com.hj.pers.controller;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hj.pers.entites.impl.Blogger;
import com.hj.pers.entites.impl.Comment;
import com.hj.pers.service.BloggerService;
import com.hj.pers.service.OtherService;

@Controller
@RequestMapping("/blogger")
public class BloggerController {
	@Autowired
	BloggerService bs;
	@Autowired
	OtherService os;

	private static Logger logger = LoggerFactory.getLogger(BloggerController.class);

	private String SUCCESS = "1";
	private String FAIL = "0";

	/**
	 * 博客首页
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping("/")
	String home1(Model m, @RequestParam(value = "startPage", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "4") Integer size) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page==0?0:page-1, size, sort);
		Page<Blogger> bloggers = bs.queryRecentBlogger(pageable);
		m.addAttribute("bloggers", bloggers);
		return "/blogger/blogger";
	}

	/**
	 * 博客内容
	 * 
	 * @param request
	 * @param bloggerId
	 * @param m
	 * @return
	 */
	@RequestMapping("/detail")
	String detail(HttpServletRequest request, String bloggerId, Model m) {
		if (bloggerId != null && !"".equals(bloggerId)) {
			Long id = Long.parseLong(bloggerId);
			Blogger b = bs.findOne(id);
			m.addAttribute("blogger", b);
			List<Comment> c = os.findByArticleId("blogger" + id);
			m.addAttribute("note", b);
			m.addAttribute("comment", c);
		}
		return "/blogger/detail";
	}

	/**
	 * 博客添加
	 * 
	 * @param request
	 * @param bloggerId
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	String add(HttpServletRequest request, Model model) {
		String id = request.getParameter("bloggerId");
		if (!StringUtils.isEmpty(id)) {
			Blogger blogger = bs.findOne(Long.parseLong(id));
			model.addAttribute("blogger", blogger);
		} else {
			model.addAttribute("blogger", new Blogger());
		}
		return "/blogger/add";
	}

	/*************************************************
	 * A**J**A**X
	 ******************************************/

	/**
	 * 保存博客
	 * 
	 */
	@RequestMapping(value = "/save", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, String> save(@ModelAttribute Blogger blogger, HttpServletRequest request) {
		Map<String, String> msg = new Hashtable<>();
		try {

			blogger = bs.save(blogger);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			msg.put("msg", FAIL);
		}
		msg.put("msg", SUCCESS);
		msg.put("id", String.valueOf(blogger.getId()));
		return msg;
	}

	/**
	 * 按条件查询
	 * 
	 * @param keyword
	 * @param model
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, String> save(String keyword, Model model) {
		Map<String, String> msg = new Hashtable<>();
		List<Blogger> bloggers = bs.queryBloggerByWord(keyword);
		if (bloggers.size() > 0) {
			model.addAttribute("bloggers", bloggers);
			msg.put("msg", SUCCESS);
		} else {
			msg.put("msg", FAIL);
		}
		return msg;
	}
}
