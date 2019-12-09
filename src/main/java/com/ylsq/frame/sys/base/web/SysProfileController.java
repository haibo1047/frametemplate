package com.ylsq.frame.sys.base.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ylsq.frame.common.base.BaseController;
import com.ylsq.frame.common.base.ValidateResult;
import com.ylsq.frame.sys.base.dao.model.SysProfile;
import com.ylsq.frame.sys.base.service.SysProfileService;
import com.ylsq.frame.sys.shiro.utils.ShiroSessionUtil;

@Controller
@RequestMapping("/myprofile")
public class SysProfileController extends BaseController {
	private Logger log = LoggerFactory.getLogger(SysProfileController.class);
	
	@Autowired
	private SysProfileService sysProfileService;
	
	@RequestMapping(method= RequestMethod.GET)
	public String myprofile(ModelMap modelMap) {
		SysProfile myProfile = sysProfileService.selectByLogin(currentLogin());
		modelMap.put("myProfile", myProfile);
		return webPrefix() + "profile";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(SysProfile profile,ModelMap modelMap) {
		log.debug(profile.toString());
		initModel(profile);
		
		ValidateResult vr = validate(profile);
		if(!vr.isPassed()) {
			modelMap.put("myProfile", profile);
			modelMap.put("errorMsg", vr.getMsg());
			return webPrefix()+"profile";
		}
		if(profile.getId() == null) {
			sysProfileService.insert(profile);
		}
		else {
			sysProfileService.updateByPrimaryKey(profile);
		}
		ShiroSessionUtil.replace("pageSize", profile.getPageSize());
		return myprofile(modelMap);
	}
	
	protected ValidateResult validate(SysProfile model) {
		SysProfile existing = sysProfileService.selectByLogin(model.getLogin());
		if(existing.getId() != null && !(existing.getId().equals(model.getId()))) {
			log.warn("Profile已经存在："+ model.getLogin());
			return new ValidateResult("Profile已经存在");
		}
		return ValidateResult.Passed;
	}

	@Override
	protected String webPrefix() {
		// TODO Auto-generated method stub
		return "/sys/common/";
	}

}
