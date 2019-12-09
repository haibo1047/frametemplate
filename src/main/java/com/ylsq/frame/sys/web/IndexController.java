package com.ylsq.frame.sys.web;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ylsq.frame.common.base.BaseController;

@RequestMapping("/")
@Controller
public class IndexController extends BaseController {
	private static Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		log.debug((String)SecurityUtils.getSubject().getPrincipal());
		return webPrefix() + "/index";
	}

	@RequestMapping(value= "/403", method = RequestMethod.GET)
	public String page403(ModelMap modelMap) {
		return webPrefix() + "403";
	}
	
	@RequestMapping(value= "/404", method = RequestMethod.GET)
	public String page404(ModelMap modelMap) {
		return webPrefix() + "404";
	}
	
	@RequestMapping(value= "/500", method = RequestMethod.GET)
	public String page500(ModelMap modelMap) {
		return webPrefix() + "500";
	}

	@Override
	protected String webPrefix() {
		// TODO Auto-generated method stub
		return "/common/";
	}	
}
