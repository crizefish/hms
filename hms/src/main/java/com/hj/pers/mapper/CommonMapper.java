package com.hj.pers.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hj.pers.pojo.Common;

@Mapper
public interface CommonMapper {
	
public List<Common> findTopCommon();

public List<Common> findHotCommon();
}
