package com.hj.pers.service;

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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.StringUtils;

import com.hj.pers.entites.impl.User;
import com.hj.pers.mapper.CommonMapper;
import com.hj.pers.pojo.Common;
import com.hj.pers.resp.impl.UserRepository;

@Service
@ActiveProfiles("163")
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository ur;
	@Autowired
	private CommonMapper cm;

	@Autowired
	private JavaMailSender mailSender; // 自动注入的Bean

	@Value("${spring.mail.username}")
	private String Sender; // 读取配置文件中的参数

	public void save(User u) {
		ur.saveAndFlush(u);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		String[] s = userName.split("#");
		String u = s[0];
		String p = s[1];
		User user = ur.findByUserName(u);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		user.setPassword(p);
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
	
	public User saveUser(User u){
		if(!StringUtils.isEmpty(u.getUsername())){
		 return  ur.save(u);
		}else{
			return null;
		}
	}
	
	public List<Common> findTopCommon(){
		return cm.findTopCommon();
	}
	public List<Common> findHotCommon(){
		return cm.findHotCommon();
	}
	public User findUserInfo() throws ClassCastException{
			return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
}
