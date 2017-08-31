package com.hj.pers.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.pers.locker.DistributedLockHandler;
import com.hj.pers.locker.Lock;

@Service
public class LockerHandlerTest {
	@Autowired
	DistributedLockHandler distributedLockHandler;
	Lock lock=new Lock("lockk","sssssssss");
	
	public void doTask(){
		if(distributedLockHandler.tryLock(lock)){
		   System.out.println("******************");
		    distributedLockHandler.releaseLock(lock);
		}
	}
}
