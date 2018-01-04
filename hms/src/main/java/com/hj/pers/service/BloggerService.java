package com.hj.pers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.pers.entites.impl.Blogger;
import com.hj.pers.resp.impl.BloggerReposity;
@Service
public class BloggerService {
@Autowired 
BloggerReposity bs;

	public Blogger save(Blogger blogger) {
		return bs.save(blogger);
	}

	public Blogger findOne(Long id) {
		return bs.findOne(id);
	}
	
	public List<Blogger> queryRecentBlogger(Long count) {
		return bs.queryRecentBlogger(count).size()>0?bs.queryRecentBlogger(count):null;
	}
	public List<Blogger> queryBloggerByWord(String keyword) {
		return bs.queryBloggerByKeyword(keyword);
	}
}
