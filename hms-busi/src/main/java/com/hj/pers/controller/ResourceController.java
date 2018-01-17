package com.hj.pers.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hj.pers.entites.impl.Comment;
import com.hj.pers.entites.impl.Resource;
import com.hj.pers.service.OtherService;
import com.hj.pers.service.ResourceService;
@Controller
@RequestMapping("/resource")
public class ResourceController {
	@Autowired 
	ResourceService bs;
	@Autowired 
	OtherService os;
	private static Logger logger = LoggerFactory.getLogger(ResourceController.class);

	private String SUCCESS = "1";
	private String FAIL = "0";
		
		/**资源首页
		 * 
		 * @param m
		 * @return
		 */
	    @RequestMapping("/")
	    String home1(Model m) {
	    	List<Resource> resources = bs.queryRecentResource(5L);
	    	m.addAttribute("resources", resources);
	    	return"/resource/resource"; 
	    } 
	    
	    /**资源内容
	     * 
	     * @param request
	     * @param resourceId
	     * @param m
	     * @return
	     */
	    @RequestMapping("/detail")
	    String detail(HttpServletRequest request,String resourceId,Model m) {
	    	if(resourceId!=null&&!"".equals(resourceId)){
	    		Long id = Long.parseLong(resourceId);
	    		Resource b= bs.findOne(id);
	    		m.addAttribute("resource", b);
	    		List<Comment> c = os.findByArticleId("resource"+id);
	    		m.addAttribute("note", b);
	    		m.addAttribute("comment",c);
	    	}
	    	return"/resource/detail"; 
	    }
	    
	    
	    /**资源添加
	     * 
	     * @param request
	     * @param resourceId
	     * @param m
	     * @return
	     */
	    @RequestMapping(value="/add", produces = "application/json; charset=utf-8")
	    String add(HttpServletRequest request,Model model) {
	    	String id = request.getParameter("resourceId");
	    	if(!StringUtils.isEmpty(id)){
	    		Resource resource = bs.findOne(Long.parseLong(id));
	    		model.addAttribute("resource", resource);
	    	}else{
	    		model.addAttribute("resource", new Resource());
	    	}
	    	return"/resource/add"; 
	    }
	    
	    /*************************************************A**J**A**X******************************************/
	    
	    /**保存资源
	     * 
	     */
	    @RequestMapping(value="/save", produces = "application/json; charset=utf-8")
	    @ResponseBody
	    public Map<String, String> save(@ModelAttribute Resource resource,HttpServletRequest request) {
	    	Map< String,String> msg = new Hashtable<>();
	    	resource.setCreateDate(new Date());
	    	try{
	    		
	    		resource = bs.save(resource);
	    	}catch(Exception e){
	    		logger.error(e.getMessage(),e);
	    		msg.put("msg",FAIL);
	    	}
	    	msg.put("msg",SUCCESS);
	    	msg.put("id", String.valueOf(resource.getId()));
	    	return msg; 
	    }
	    
	    /**按条件查询
	     * 
	     * @param keyword
	     * @param model
	     * @return
	     */
	    @RequestMapping("/query")
	    @ResponseBody
	    public Map<String, String> save(String keyword,Model model) {
	    	Map< String,String> msg = new Hashtable<>();
	    	List<Resource> resources = bs.queryResourceByWord(keyword);
	    	if(resources.size()>0){
	    		model.addAttribute("resources",resources);
	    		msg.put("msg",SUCCESS);    		
	    	}else{
	    		msg.put("msg",FAIL);
	    	}
	    	return msg; 
	    }
	    
	    /**上传文件
	     * 
	     * @param keyword
	     * @param model
	     * @return
	     */
	    @RequestMapping("/upload")
	    @ResponseBody
	    public Map<String, String> upload(MultipartFile file) {
	    	Map< String,String> msg = new Hashtable<>();
//	    	String name = file.getName();
	    	File filedir = new File("D:\\WWW\\qq.txt");
	    	FileOutputStream out = null;
			try {
				out = new FileOutputStream(filedir);
			} catch (FileNotFoundException e1) {
				logger.error(e1.getMessage(),e1);
			}
	    	try {
				out.write(file.getBytes());
				out.close();
			} catch (IOException e) {
				logger.error(e.getMessage(),e);
			}
	    	/*if(resources.size()>0){
	    		model.addAttribute("resources",resources);
	    		msg.put("msg",SUCCESS);    		
	    	}else{
	    		msg.put("msg",FAIL);
	    	}*/
	    	return msg; 
	    }  
	    
}
