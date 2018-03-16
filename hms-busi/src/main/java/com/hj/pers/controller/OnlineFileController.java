package com.hj.pers.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hj.pers.pojo.file.DirBean;
import com.hj.pers.pojo.file.RootBean;
import com.hj.pers.service.OnlineFileService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/introduction")
public class OnlineFileController {

	@Autowired
	private OnlineFileService ofs;

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/")
	public String index(HttpServletRequest request) {

		return "/introduction/file";

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/iterateDir", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray queryForDir(HttpServletRequest request) {
		String requestPath = request.getParameter("path").trim();
		if (requestPath != null && requestPath.length() > 1) {
			String nowPath = requestPath;
			if (nowPath.endsWith("/")) {
				nowPath = nowPath.substring(0, requestPath.length() - 1);
			}
			try {
				DirBean dirBean = ofs.getFiles(nowPath);
				JSONArray json = JSONArray.fromObject(dirBean);
				return json;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/iterateRoot", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray queryForFile() {
		List<RootBean> roots = ofs.getDiskInfo();
		if (roots != null) {
			return JSONArray.fromObject(roots);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/viewOnline", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> viewOnline(HttpServletRequest request, Model m, String path) {
		HashMap<String, String> map = new HashMap<>();
		String requestPath = request.getParameter("path").trim();
		String content = ofs.file2html(requestPath);
		m.addAttribute("content", content);
		map.put("content", content);
		return map;
	}

	@RequestMapping(value = "/short", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
	String sho() {
		return "/introduction/short";
	}
}
