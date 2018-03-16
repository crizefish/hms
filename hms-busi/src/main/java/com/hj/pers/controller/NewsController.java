package com.hj.pers.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.hj.pers.pojo.Page;
import com.hj.pers.pojo.news.News;
import com.hj.pers.pojo.news.NewsRequest;
import com.hj.pers.util.Constants;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	RestTemplate restT;

	@Value("${key}")
	private String key;

	@Autowired
	private StringRedisTemplate redisT;

	private Date queryTime;

	/**
	 * 新闻首页
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/", produces = "application/json; charset=utf-8")
	String home1(HttpServletRequest request, Model m) {
		Gson g = new Gson();
		NewsRequest result = null;

		// if redis cached the result,get result from redis,else pull from web
		// interface
		long interval = (queryTime == null ? 0 : (new Date().getTime() - queryTime.getTime()));
		if (redisT.hasKey("result") && interval < 60000 && interval != 0) {
			String json = redisT.opsForValue().get("result");
			result = g.fromJson(json, NewsRequest.class);
		} else {
			String uri = "http://api.avatardata.cn/TouTiao/Query?key=" + key;
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Object> e = new HttpEntity<Object>(headers);
			result = restT.postForObject(uri, e, NewsRequest.class);
			redisT.opsForValue().set("result", g.toJson(result));
			queryTime = new Date();
		}

		List<News> data = result.getResult().getData();
		ArrayList<News> main = new ArrayList<News>();
		ArrayList<News> other = new ArrayList<News>();
		for (News news : data) {
			if (news.getThumbnail_pic_s03() == null) {
				if (other.size() < 10) {
					other.add(news);
				}
			} else {
				main.add(news);
			}
		}
		//
		String sp = request.getParameter("startPage");
		int from = 1;
		if (!StringUtils.isEmpty(sp)) {
			try {
				from = Integer.parseInt(sp);
			} catch (NumberFormatException e) {

			}
		}
		List<News> current = main.subList(from - 1, from + Constants.NEWS_PAGE_COUNT - 1);
		m.addAttribute("page", new Page(main.size() / Constants.NEWS_PAGE_COUNT, from));
		m.addAttribute("m", current);
		m.addAttribute("o", other);

		System.out.println(result.toString());
		return "/news/news";
	}

}
