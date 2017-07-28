package com.hj.pers.resp;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.hj.pers.entites.Blogger;

public interface BloggerReposity extends BaseRepository<Blogger,Long>{
	
	@Query(value = "select * from blogger  order by create_Date desc limit ?1",nativeQuery=true)
	public List<Blogger>queryRecentBlogger(Long count);
	@Query(value = "SELECT * FROM blogger WHERE content LIKE %"+"?1"+"% ",nativeQuery=true)
	public List<Blogger>queryBloggerByKeyword(String keyWord);

}
