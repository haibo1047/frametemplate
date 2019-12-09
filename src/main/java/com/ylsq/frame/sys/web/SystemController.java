package com.ylsq.frame.sys.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ylsq.frame.common.base.BaseController;
import com.ylsq.frame.sys.base.service.SysLogService;

@RequestMapping("/sys/")
@Controller
public class SystemController extends BaseController {
	static private Logger log = LoggerFactory.getLogger(SystemController.class);
	
	@Autowired
	private SysLogService sysLogService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()) {
			log.debug((String)subject.getPrincipal());
			return "redirect:/";
		}
		return "/common/login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam(value="username") String username,@RequestParam(value="password") String passwd,HttpServletRequest request,ModelMap modelMap) {
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()) {
			log.debug((String)subject.getPrincipal());
		}
		else {
			UsernamePasswordToken token = new UsernamePasswordToken(username, passwd);
			try {
				subject.login(token);
			}catch(Exception e) {
				modelMap.put("errorMsg", e.getMessage());
				return login(modelMap);
			}
			log.info(username + " 登录成功");
			
			sysLogService.doLogin(currentLogin(), new Date(), getIp(request), null);
		}
		SavedRequest sr = WebUtils.getSavedRequest(request);
		if(sr == null) {
			log.debug("redirect to : /" );
			return "redirect:/";
		}
		String url = sr.getRequestUrl().replaceAll(request.getContextPath(), "");
		log.debug("redirect to :" + url);
		return "redirect:" + url;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, ModelMap modelMap) {
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()) {
			log.debug((String)subject.getPrincipal() + "  is logging out");
			sysLogService.doLogout(currentLogin(), new Date(), getIp(request), null);
			subject.logout();
		}
		return "redirect:/sys/login";
	}
}
