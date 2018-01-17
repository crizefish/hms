package com.hj.pers.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.hj.pers.service.UserService;

@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

	@Autowired
	private UserService us;

	@Pointcut("execution(* com.hj.pers.controller..*.*(..))")
	public void executeService() {

	}

	private static final Logger logger = LoggerFactory.getLogger(Aspect.class);

	/**
	 * 前置通知，方法调用前被调用
	 * 
	 * @param joinPoint
	 */
	@After("executeService()")
	public void doBeforeAdvice(JoinPoint joinPoint) {
		// 获取RequestAttributes
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = (HttpServletRequest) requestAttributes
				.resolveReference(RequestAttributes.REFERENCE_REQUEST);
		request.setAttribute("hot", us.findHotCommon());
		request.setAttribute("top", us.findTopCommon());

		try {
			request.setAttribute("user", us.findUserInfo());
		} catch (ClassCastException e) {
			logger.info("未检测到有效用户");
		}

	}
}
