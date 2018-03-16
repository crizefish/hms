package com.hj.pers.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.hj.pers.entites.impl.Message;
import com.hj.pers.resp.impl.MessageReposity;

@Service
@Transactional
public class MessageService {
	@Autowired
	private MessageReposity mr;

	public Message saveMessage(Message c) {
		c.setCreateTime(new Date());
		if (StringUtils.isEmpty(c.getReplyName())) {
			c.setReplyName("游客");
		}
		Message newC = mr.save(c);
		return newC;
	}

	public List<Message> findAllMessage(String articleId) {
		return mr.findAll();
	}

	public Page<Message> findPageMessage(Pageable pageable) {
		return mr.findAll(pageable);
	}

}
