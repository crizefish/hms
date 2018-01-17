package com.hj.pers.resp.impl;

import java.util.List;

import com.hj.pers.entites.impl.Comment;
import com.hj.pers.resp.BaseRepository;
public interface CommentReposity extends BaseRepository<Comment,Long>{

	
	List<Comment> findByArticleId(String articleId);

	
}
