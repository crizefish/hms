package com.hj.pers.resp.impl;

import com.hj.pers.entites.impl.User;
import com.hj.pers.resp.BaseRepository;

public interface UserRepository extends BaseRepository<User, Long> {

	User findByUserNameAndPassword(String userName,String password);
	User findByUserName(String userName);

}
