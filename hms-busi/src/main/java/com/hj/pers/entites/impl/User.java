package com.hj.pers.entites.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hj.pers.entites.Base;
/**用户实体
 * 
 * @author hujian
 *
 */
@Table
@Entity(name="user")
public class User extends Base implements Serializable,UserDetails{
	private static final long serialVersionUID = -1856544965147789551L;
	private String userName;
	private String password;
	private String email;
	private String sex;
	private String phone;
	@Transient
	private Collection<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
	@Transient
	private boolean status ;

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

	public void addauth(String role){
		this.auth.add(new SimpleGrantedAuthority(role));
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

	
	
	public Collection<GrantedAuthority> getAuth() {
		return auth;
	}

	public void setAuth(Collection<GrantedAuthority> auth) {
		this.auth = auth;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.auth;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.status;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.status;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.status;
	}

	@Override
	public boolean isEnabled() {
		return this.status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}
