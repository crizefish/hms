package com.hj.pers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.hj.pers.security.FailHandler;
import com.hj.pers.security.SuccessHandler;
import com.hj.pers.service.UserService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	SuccessHandler sh;
	@Autowired
	FailHandler fh;

	@Bean
	SuccessHandler successHandler() {
		return new SuccessHandler();
	}

	@Bean
	FailHandler failHandler() {
		return new FailHandler();
	}

	@Bean
	UserDetailsService customUserService() {
		return new UserService();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http  
	        .authorizeRequests()  
				.antMatchers("/css/**", "/images/**", "/js/**", "/plug/**", "/ueditor/**", "/user/**").permitAll()
				.antMatchers("/blogger/**", "/index/**", "/login/**", "/message/**", "/news/**", "/note/**","/resource/**").permitAll()
				.and().formLogin().loginPage("/login").successHandler(sh).failureHandler(fh).usernameParameter("username").passwordParameter("password").permitAll();
		http.csrf().disable();
	}
}