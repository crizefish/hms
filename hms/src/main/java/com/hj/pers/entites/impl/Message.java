package com.hj.pers.entites.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hj.pers.entites.Base;

@Entity(name="message")
public class Message extends Base{
			//id
			@Id
		    @GeneratedValue(strategy=GenerationType.IDENTITY)
		    @Column(name = "id")
		    private Long id;
}
