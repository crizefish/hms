package com.hj.pers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hj.pers.entites.impl.Blogger;
import com.hj.pers.resp.impl.BloggerReposity;

@Service
public class BloggerService {

	@Autowired
	private BloggerReposity bs;
	@Autowired
	private UserService us;

	public Blogger save(Blogger blogger) {
		Blogger base = (Blogger) us.setCommonInfo(blogger);
		return bs.save(base);
	}

	public Blogger findOne(Long id) {
		return bs.findOne(id);
	}

	public Page<Blogger> queryRecentBlogger(Pageable pageable) {
		return bs.findAll(pageable);
	}

	public List<Blogger> queryBloggerByWord(String keyword) {
		return bs.queryBloggerByKeyword(keyword);
	}
}
