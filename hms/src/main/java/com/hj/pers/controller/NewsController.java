package com.hj.pers.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.hj.pers.pojo.news.News;
import com.hj.pers.pojo.news.NewsRequest;
@Controller
@RequestMapping("/news")
public class NewsController {
	
	 @Autowired
	    RestTemplate rt;
	
	 @Value("${key}")
	private String key;
//
//	private static Logger logger = LoggerFactory.getLogger(NewsController.class);
//
//	private String SUCCESS = "1";
//	private String FAIL = "0";
		
		/**博客首页
		 * 
		 * @param m
		 * @return
		 */
	    @RequestMapping(value="/",produces = "application/json; charset=utf-8")
	    String home1(Model m) {
	    	int size = 5;
	    	int from = 0;
	    	String uri = "http://api.avatardata.cn/TouTiao/Query?key="+key;
	    	HttpHeaders headers =new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<Object> request=new HttpEntity<Object>(headers);
	        NewsRequest result = rt.postForObject(uri, request,NewsRequest.class);
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
