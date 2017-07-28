package com.hj.pers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.pers.entites.User;
import com.hj.pers.resp.UserRepository;

@Service
public class UserService{
	@Autowired 
	UserRepository ur;
	public void save(User u) {
		ur.saveAndFlush(u);
	}

}
