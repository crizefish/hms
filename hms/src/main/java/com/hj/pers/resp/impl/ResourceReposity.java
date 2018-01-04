package com.hj.pers.resp.impl;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.hj.pers.entites.impl.Resource;
import com.hj.pers.resp.BaseRepository;

public interface ResourceReposity extends BaseRepository<Resource,Long>{
	
	@Query(value = "select * from blogger  order by create_Date desc limit ?1",nativeQuery=true)
	public List<Resource>queryRecentResource(Long count);
	
	@Query(value = "SELECT * FROM blogger WHERE content LIKE %"+"?1"+"% ",nativeQuery=true)
	public List<Resource>queryResourceByKeyword(String keyWord);

}
