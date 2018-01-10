package com.hj.pers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hj.pers.mapper.CommonMapper;
import com.hj.pers.pojo.article.Common;

@Service
@Transactional
public class OtherService {
@Autowired 
private CommonMapper m;
	
	public List<Common> searchByKeyWord(String keyWord){
		List<Common> s = m.searchByKeyWord(keyWord);
		for (Common common : s) {
			common.brushColor(keyWord);
		}
		return s;
	}
	
}
