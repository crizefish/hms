package com.hj.pers.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hj.pers.entites.impl.Comment;
import com.hj.pers.mapper.CommonMapper;
import com.hj.pers.pojo.article.Common;
import com.hj.pers.resp.impl.CommentReposity;

@Service
@Transactional
public class OtherService {
@Autowired 
private CommonMapper m;
@Autowired 
private CommentReposity cr;
	
	public List<Common> searchByKeyWord(String keyWord){
		List<Common> s = m.searchByKeyWord(keyWord);
		for (Common common : s) {
			common.brushColor(keyWord);
		}
		return s;
	}

	public Comment saveComment(Comment c) {
		c.setCreateTime(new Date());
		Comment newC = cr.save(c);
		return newC;
	}

	public List<Comment> findByArticleId(String articleId) {
		return  cr.findByArticleId(articleId);
	}
	
}
