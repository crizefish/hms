package com.hj.pers.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hj.pers.entites.Base;
import com.hj.pers.entites.impl.User;
import com.hj.pers.mapper.CommonMapper;
import com.hj.pers.pojo.article.Common;
import com.hj.pers.resp.impl.UserRepository;
import com.hj.pers.util.Constants;
import com.hj.pers.util.DesUtil;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository ur;
	@Autowired
	private CommonMapper cm;
	@Autowired
	private JavaMailSender mailSender; // 自动注入的Bean
	@Value("${spring.mail.username}")
	private String Sender; // 读取配置文件中的参数
	
	
	public User findOne(Long id) {
		return ur.findOne(id);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		String[] s = userName.split("#");
		String u = s[0];
		String p = s[1];
		User user = ur.findByUserNameAndPassword(u,p);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		user.addauth("role");
		user.setStatus(true);
		System.out.println("s:" + user);
		System.out.println("username:" + user.getUsername() + ";password:" + user.getPassword());
		return user;
	}

	public int sendNum(String add) {
		Random r = new Random();
		int l = r.nextInt(8999)+1000;
		   SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(Sender);
	        message.setTo(new String[]{add,Sender}); //自己给自己发送邮件
	        message.setSubject("欢迎加入我的个人网站，请验证登录邮箱思密达");
	        message.setText(add+"，您好!您获取的验证码是"+l);
	        mailSender.send(message);
		return l;
	}
	
	public User saveUser(User u) throws IOException, Exception{
		if(!StringUtils.isEmpty(u.getUsername())){
			u.setPassword(DesUtil.aesEncrypt(u.getPassword(),Constants.KEY));
			User user = (User)setCommonInfo(u);
			 return ur.saveAndFlush(user);
		}else{
			return null;
		}
	}
	
	public List<Common> findTopCommon(){
		return cm.findCommon("top_num");
	}
	public List<Common> findHotCommon(){
		return cm.findCommon("read_num");
	}
	public User findUserInfo() throws ClassCastException{
			return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	public Base setCommonInfo(Base b) throws ClassCastException{
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		b.setCreateDate(new Date());
		b.setAuthor(username);
		return b;
	}

	public boolean checkUsername(String username) {
		User user = ur.findByUserName(username);
		return user==null?false:true;
		
	}
	
}
