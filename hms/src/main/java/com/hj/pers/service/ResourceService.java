package com.hj.pers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hj.pers.entites.impl.Resource;
import com.hj.pers.resp.impl.ResourceReposity;
@Service
@Transactional
public class ResourceService {
@Autowired 
ResourceReposity bs;

	public Resource save(Resource resource) {
		return bs.save(resource);
	}

	public Resource findOne(Long id) {
		return bs.findOne(id);
	}
	
	public List<Resource> queryRecentResource(Long count) {
		return bs.queryRecentResource(count).size()>0?bs.queryRecentResource(count):null;
	}
	public List<Resource> queryResourceByWord(String keyword) {
		return bs.queryResourceByKeyword(keyword);
	}
}
