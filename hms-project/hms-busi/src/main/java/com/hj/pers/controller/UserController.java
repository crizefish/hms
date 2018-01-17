package com.hj.pers.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hj.pers.entites.impl.User;
import com.hj.pers.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService us;
	
	private static int num = 0;
	
	@RequestMapping("/register")
	public String blogger(HttpServletRequest request){
		
		return "/login/register";
	}
	
	/**发送验证码
	 * 
	 * @param u
	 * @return
	 */
	@RequestMapping("/checkNum")
	@ResponseBody
	public Map<String, String> checkNum(User u){
		Map<String, String> m = new HashMap<String,String>();
		num = us.sendNum(u.getEmail());
		m.put("msg", "1");
		return m;
	}
	
	/**保存用户
	 * 
	 * @param u
	 * @return
	 */
	@RequestMapping("/saveUser")
	@ResponseBody
	public Map<String, String> saveUser(HttpServletRequest request,User u){
		Map<String, String> m = new HashMap<String,String>();
		String n = request.getParameter("checkNum");
		if(!StringUtils.isEmpty(n)){
			if(num==Integer.parseInt(n)){
				User user = us.saveUser(u);
				if(user!=null){
					m.put("msg", "1");
				}else{
					m.put("msg", "保存用户信息失败，请检查");;
				}
				return m;
			}else{
				m.put("msg", "验证码不正确，请重新输入");
				return m;
			}
		}else{
			m.put("msg", "验证码为空！");
			return m;
		}
		
	}
	/**检查用户名
	 * 
	 * @param u
	 * @return
	 */
	@RequestMapping("/checkUsername")
	@ResponseBody
	public Map<String, String> checkUsername(HttpServletRequest request,String username){
		Map<String, String> m = new HashMap<String,String>();
				if(!StringUtils.isEmpty(username)){
					boolean isExist = us.checkUsername(username);
					if(isExist){
						m.put("msg","用户名已存在");
					}else{
						m.put("msg","成功");
						
					}
				}else{
					return null;
				}
				return m;
	}
	
	
	
}
