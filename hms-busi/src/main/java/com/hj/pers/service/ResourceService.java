package com.hj.pers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hj.pers.entites.impl.Resource;
import com.hj.pers.resp.impl.ResourceReposity;

@Service
@Transactional
public class ResourceService {

	@Autowired
	private ResourceReposity rr;
	@Autowired
	private UserService us;

	public Resource save(Resource resource) {
		resource = (Resource) us.setCommonInfo(resource);
		return rr.save(resource);
	}

	public Resource findOne(Long id) {
		return rr.findOne(id);
	}

	public Page<Resource> queryRecentResource(Pageable pageable) {
		return rr.findAll(pageable);
	}

	public List<Resource> queryResourceByWord(String keyword) {
		return rr.queryResourceByKeyword(keyword);
	}
}
