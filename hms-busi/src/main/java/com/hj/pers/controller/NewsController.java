package com.hj.pers.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.hj.pers.pojo.news.News;
import com.hj.pers.pojo.news.NewsRequest;
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
		
		/**博客首页
		 * 
		 * @param m
		 * @return
		 */
	    @RequestMapping(value="/",produces = "application/json; charset=utf-8")
	    String home1(Model m) {
	    	Gson g = new Gson();
	    	int size = 5;
	    	int from = 0;
	    	
	        NewsRequest result = null;
	        
	        //if redis cached the result,get result from redis,else pull from web interface 
	        long interval = (queryTime == null? 0 :(new Date().getTime()-queryTime.getTime()));
	        if(redisT.hasKey("result")&&interval<60000&&interval!=0){
	        	String json = redisT.opsForValue().get("result");
	            result = g.fromJson(json, NewsRequest.class);
	        }else{
	        	String uri = "http://api.avatardata.cn/TouTiao/Query?key="+key;
		    	HttpHeaders headers =new HttpHeaders();
		        headers.setContentType(MediaType.APPLICATION_JSON);
		        HttpEntity<Object> request=new HttpEntity<Object>(headers);
	        	result = restT.postForObject(uri, request,NewsRequest.class);
	        	redisT.opsForValue().set("result", g.toJson(result));
	        	queryTime = new Date();
	        }
	         
	        List<News> data = result.getResult().getData();
	        ArrayList<News> main = new ArrayList<News>();
	        ArrayList<News> other = new ArrayList<News>();
	    	for (News news : data) {
				if(news.getThumbnail_pic_s03()==null){
					other.add(news);
				}else{
					main.add(news);
				}
			}
	    	List<News> current = main.subList(from, from+size);
	        m.addAttribute("m", current);
	        m.addAttribute("o", other);
	        
	    	System.out.println(result.toString());
	    	return"/news/news"; 
	    } 
	  
	    
}
