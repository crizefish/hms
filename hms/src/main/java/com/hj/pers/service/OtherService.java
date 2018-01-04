package com.hj.pers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hj.pers.resp.impl.OtherReposity;
@Service
@Transactional
public class OtherService {
@Autowired 
OtherReposity os;

	
}
