package com.hj.pers.resp.impl;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hj.pers.entites.impl.Blogger;
import com.hj.pers.resp.BaseRepository;
@Repository
public interface BloggerReposity extends BaseRepository<Blogger,Long>{
	
	@Query(value = "SELECT * FROM blogger  ORDER BY create_Date DESC LIMIT ?1",nativeQuery=true)
	public List<Blogger>queryRecentBlogger(Long count);
	
	@Query(value = "SELECT * FROM blogger WHERE content LIKE %"+"?1"+"% ",nativeQuery=true)
	public List<Blogger>queryBloggerByKeyword(String keyWord);
}
