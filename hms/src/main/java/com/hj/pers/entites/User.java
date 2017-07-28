package com.hj.pers.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table
@Entity(name="user")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1856544965147789551L;
	private String userName;
	private String password;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	public User(Long id,String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.id = id;
	}

	public User() {
		super();
	}

	@Column(name = "user_Name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
