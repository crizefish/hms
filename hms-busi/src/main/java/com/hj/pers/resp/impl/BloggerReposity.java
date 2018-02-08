package com.hj.pers.resp.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.hj.pers.entites.impl.Blogger;
import com.hj.pers.resp.BaseRepository;
public interface BloggerReposity extends BaseRepository<Blogger,Long>{
	
//	@Query(value = "SELECT * FROM blogger  ORDER BY create_Date DESC LIMIT ?1,?2",nativeQuery=true)
//	public List<Blogger>queryRecentBlogger(int from,int count);
	
	Page<Blogger> findAll(Pageable pageable);
	
	@Query(value = "SELECT * FROM blogger WHERE content LIKE %"+"?1"+"% ",nativeQuery=true)
	public List<Blogger>queryBloggerByKeyword(String keyWord);
}
