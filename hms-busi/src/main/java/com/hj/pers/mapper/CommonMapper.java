package com.hj.pers.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hj.pers.pojo.article.Common;

@Mapper
public interface CommonMapper {

	/**
	 * 
	 * @param orderBy
	 * @return
	 */
	public List<Common> findCommon(@Param("orderBy") String orderBy);

	/***
	 * 
	 * @param keyWord
	 * @return
	 */
	public List<Common> searchByKeyWord(@Param("keyWord") String keyWord);

}
