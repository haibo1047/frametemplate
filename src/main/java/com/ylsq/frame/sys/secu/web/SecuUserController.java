package com.ylsq.frame.sys.secu.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ylsq.frame.common.base.BaseController;
import com.ylsq.frame.common.base.SystemConstants;
import com.ylsq.frame.common.base.ValidateResult;
import com.ylsq.frame.common.util.PasswordUtils;
import com.ylsq.frame.sys.secu.custobj.CustOrg;
import com.ylsq.frame.sys.secu.dao.model.SecuOrg;
import com.ylsq.frame.sys.secu.dao.model.SecuOrgExample;
import com.ylsq.frame.sys.secu.dao.model.SecuRole;
import com.ylsq.frame.sys.secu.dao.model.SecuRoleExample;
import com.ylsq.frame.sys.secu.dao.model.SecuUser;
import com.ylsq.frame.sys.secu.dao.model.SecuUserRole;
import com.ylsq.frame.sys.secu.service.SecuOrgService;
import com.ylsq.frame.sys.secu.service.SecuRoleService;
import com.ylsq.frame.sys.secu.service.SecuUserRoleService;
import com.ylsq.frame.sys.secu.service.SecuUserService;

@RequestMapping("/sys/user/")
@Controller
public class SecuUserController extends BaseController {
	private static Logger log = LoggerFactory.getLogger(SecuUserController.class);
	
	@Autowired
	private SecuUserService secuUserService;
	@Autowired
	private SecuOrgService secuOrgService;
	@Autowired
	private SecuRoleService secuRoleService;
	@Autowired
	private SecuUserRoleService secuUserRoleService;
	
	@RequestMapping("/list")
	public String list(ModelMap modelMap) {
		return userList(SystemConstants.Root_Org_Id, 1, modelMap);
	}
	
	@RequestMapping("/userlist/{orgId}")
	public String userList(@PathVariable(name="orgId") Long orgId,
			@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum, ModelMap modelMap) {
		// TODO Auto-generated method stub
		int pageSize = (int)SecurityUtils.getSubject().getSession().getAttribute("pageSize");
		List<SecuOrg> secuOrglist = secuOrgService.selectByExample(new SecuOrgExample());
		List<CustOrg> orgList = secuOrgService.buildCustomOrgs(secuOrglist);
		List<SecuUser> userList = secuUserService.selectByOrgId(orgId, pageNum, pageSize);
		
		modelMap.put("total", secuUserService.countbyOrgId(orgId));
		modelMap.put("secuOrglist", secuOrglist);
		modelMap.put("orgList", orgList);
		modelMap.put("orgId", orgId);
		modelMap.put("modelList", userList);
		return webPrefix() + "list";
	}

	@RequestMapping(value= "/create/{orgId}", method = RequestMethod.GET)
	public String create(@PathVariable("orgId") Long orgId, ModelMap modelMap) {
		beforeEdit(orgId, modelMap);
		return webPrefix()+"edit";
	}
	
	protected void beforeEdit(Long orgId, ModelMap modelMap) {
		SecuOrg org = new SecuOrg();
		if(orgId == SystemConstants.Root_Org_Id) {
			org.setOrgName("Root");
			org.setId(SystemConstants.Root_Org_Id);
		}
		else {
			org = secuOrgService.selectByPrimaryKey(orgId);
		}
		modelMap.put("org", org);
	}
	

	@RequestMapping(value= "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable(name="id") String id,ModelMap modelMap) {
		log.debug(id);
		SecuUser model = secuUserService.selectByPrimaryKey(Long.parseLong(id));
		beforeEdit(model.getOrgId(), modelMap);
		modelMap.put("model", model);
		return webPrefix()+"edit";
	}
	
	@RequestMapping(value= "/delete/{orgId}/{ids}", method = RequestMethod.GET)
	public String delete(@PathVariable("orgId") Long orgId, @PathVariable(name="ids") String ids, ModelMap modelMap) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(ids)) {
			String[] idArray = ids.split("-");
			Set<String> failedNames = new HashSet<>();
			for (String idStr : idArray) {
				if (StringUtils.isBlank(idStr)) {
					continue;
				}
				Long uid = Long.parseLong(idStr);
				SecuUser user = secuUserService.selectByPrimaryKey(uid);
				if(user != null) {
					List<SecuUserRole> list = secuUserRoleService.selectByUserName(user.getUserName());
					if(list.size() > 0) {
						log.warn(user.getUserName() + "已经被配置了某些角色，请先移除绑定的角色");
						failedNames.add(user.getUserName());
						continue;
					}
					secuUserService.deleteByPrimaryKey(uid);
				}
			}
			
			if(failedNames.size()> 0) {
				modelMap.put("errorMsg", "用户("+String.join(",",failedNames)+")未删除成功，请先移除绑定的角色再重试");
			}
			else {
				modelMap.put("errorMsg", "操作成功");
			}
		}
		return userList(orgId, 1, modelMap);
	}
	
	protected ValidateResult validate(SecuUser model) {
		if(model.getId() != null) {
			SecuUser existing = secuUserService.selectByPrimaryKey(model.getId());
			if(existing != null && !existing.getUserName().equals(model.getUserName())) {
				return new ValidateResult("登录名不允许修改");
			}
		}
		SecuUser user = secuUserService.selectByUsername(model.getUserName());
		if(user != null && !(user.getId().equals(model.getId()))) {
			log.warn("已经存在此登录名的用户："+ model.getUserName());
			return new ValidateResult("登录名已经存在");
		}
		return ValidateResult.Passed;
	}
	
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(SecuUser user,ModelMap modelMap) {
		log.debug(user.toString());
		initModel(user);
		
		ValidateResult vr = validate(user);
		if(!vr.isPassed()) {
			modelMap.put("model", user);
			modelMap.put("errorMsg", vr.getMsg());
			return webPrefix()+"edit";
		}
		if(user.getId() == null) {
			user.setPassword(PasswordUtils.encode(user.getPassword()));
			secuUserService.insert(user);
		}
		else {
			user.setPassword(null);//密码不能在编辑页面更改
			secuUserService.updateByPrimaryKeySelective(user);
		}
		return userList(user.getOrgId(), 1, modelMap);
	}
	
	@RequestMapping(value="/configRoles/{userName}", method = RequestMethod.GET)
	public String configRoles(@PathVariable(name="userName")String userName, ModelMap modelMap) {
		SecuUser currentUser = secuUserService.selectByUsername(userName);
		List<SecuUserRole> mappingList = secuUserRoleService.selectByUserName(userName);
		Map<String,SecuUserRole> existingMap = new HashMap<>();
		for(SecuUserRole sur: mappingList)
			existingMap.put(sur.getRoleName(),sur);
		
		List<SecuRole> unselectedRoles = new ArrayList<>();
		List<SecuRole> selectedRoles = new ArrayList<>();
		List<SecuRole> allRoles = secuRoleService.selectByExample(new SecuRoleExample());
		for(SecuRole role: allRoles) {
			if(existingMap.keySet().contains(role.getRoleName())) {
				selectedRoles.add(role);
			}
			else {
				unselectedRoles.add(role);
			}
		}
		log.debug("size:" + mappingList.size());
		modelMap.put("selectedList", selectedRoles);
		modelMap.put("unselectedList", unselectedRoles);
		modelMap.put("user", currentUser);
		
		return webPrefix() + "/configRoles";
	}
	
	@RequestMapping(value="/configRoles", method = RequestMethod.POST)
	public String configRoles(@RequestParam(value="userName") String userName, @RequestParam(value="selectedIds") String selectedRoleIds, ModelMap modelMap) {
		log.debug(userName);
		SecuUser user = secuUserService.selectByUsername(userName);
		List<SecuUserRole> mappingList = secuUserRoleService.selectByUserName(userName);
		Map<String,SecuUserRole> existingMap = new HashMap<>();
		for(SecuUserRole sur: mappingList)
			existingMap.put(sur.getRoleName(),sur);
		
		String[] idArray = StringUtils.defaultIfEmpty(selectedRoleIds, "").split("-");
		for(String roleName : idArray) {
			if(existingMap.keySet().contains(roleName)) {
				mappingList.remove(existingMap.get(roleName));
			}
			else {
				SecuUserRole sur = new SecuUserRole();
				sur.setRoleName(roleName);
				sur.setUserName(userName);
				initModel(sur);
				secuUserRoleService.insert(sur);
			}
		}
		for(SecuUserRole sur: mappingList) {
			secuUserRoleService.deleteByPrimaryKey(sur.getId());
		}
		return userList(user.getOrgId(), 1, modelMap);
	}

	@Override
	protected String webPrefix() {
		// TODO Auto-generated method stub
		return "/sys/secuUser/";
	}
}
