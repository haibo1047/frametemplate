package com.ylsq.frame.sys.secu.web;

import java.util.ArrayList;
import java.util.Collections;
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

import com.ylsq.frame.common.base.BaseExample;
import com.ylsq.frame.common.base.BaseModel;
import com.ylsq.frame.common.base.BaseModelController;
import com.ylsq.frame.common.base.BaseService;
import com.ylsq.frame.common.base.ValidateResult;
import com.ylsq.frame.sys.secu.dao.model.SecuMenu;
import com.ylsq.frame.sys.secu.dao.model.SecuMenuExample;
import com.ylsq.frame.sys.secu.dao.model.SecuRole;
import com.ylsq.frame.sys.secu.dao.model.SecuRoleExample;
import com.ylsq.frame.sys.secu.dao.model.SecuRoleMenu;
import com.ylsq.frame.sys.secu.dao.model.SecuUser;
import com.ylsq.frame.sys.secu.dao.model.SecuUserExample;
import com.ylsq.frame.sys.secu.dao.model.SecuUserRole;
import com.ylsq.frame.sys.secu.service.SecuMenuService;
import com.ylsq.frame.sys.secu.service.SecuRoleMenuService;
import com.ylsq.frame.sys.secu.service.SecuRoleService;
import com.ylsq.frame.sys.secu.service.SecuUserRoleService;
import com.ylsq.frame.sys.secu.service.SecuUserService;
import com.ylsq.frame.sys.secu.sorter.MenuSorter;


@Controller
@RequestMapping("/sys/role")
public class SecuRoleController extends BaseModelController {
	private static Logger log = LoggerFactory.getLogger(SecuRoleController.class);
	
	@Autowired
	private SecuRoleService secuRoleService;
	@Autowired
	private SecuUserService secuUserService;
	@Autowired
	private SecuUserRoleService secuUserRoleService;
	
	@Autowired
	private SecuMenuService secuMenuService;
	@Autowired
	private SecuRoleMenuService secuRoleMenuService;
	
	@Override
	public String list(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum,ModelMap modelMap) {
		// TODO Auto-generated method stub
		int pageSize = (int)SecurityUtils.getSubject().getSession().getAttribute("pageSize");
		List<SecuRole> list = secuRoleService.selectByExampleForStartPage(new SecuRoleExample(),pageNum,pageSize);
		
		modelMap.put("modelList", list);
		modelMap.put("total", secuRoleService.countByExample(new SecuRoleExample()));
		return webPrefix() + "list";
	}

	@Override
	public String delete(@PathVariable(name="ids") String ids, ModelMap modelMap) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(ids)) {
			String[] idArray = ids.split("-");
			Set<String> failedNames = new HashSet<>();
			for (String idStr : idArray) {
				if (StringUtils.isBlank(idStr)) {
					continue;
				}
				Long rid = Long.parseLong(idStr);
				SecuRole role = secuRoleService.selectByPrimaryKey(rid);
				if(role != null) {
					List<SecuRoleMenu> mlist = secuRoleMenuService.selectByRoleName(role.getRoleName());
					if(mlist.size() > 0 ) {
						log.warn(role.getRoleName() + "已经被配置了某些菜单，请先移除绑定的菜单");
						failedNames.add(role.getRoleName());
						continue;
					}
					
					List<SecuUserRole> ulist = secuUserRoleService.selectByRoleName(role.getRoleName());
					if(ulist.size() > 0) {
						log.warn(role.getRoleName() + "已经被配置了某些用户，请先移除绑定的用户");
						failedNames.add(role.getRoleName());
						continue;
					}
					secuRoleService.deleteByPrimaryKey(rid);
				}
			}
			
			if(failedNames.size()> 0) {
				modelMap.put("errorMsg", "角色("+String.join(",",failedNames)+")未删除成功，请先移除绑定的用户或菜单再重试");
			}
			else {
				modelMap.put("errorMsg", "操作成功");
			}
		}
		return list(modelMap);
	}
	
	protected ValidateResult validate(SecuRole model) {
		if(model.getId() != null) {
			SecuRole role = secuRoleService.selectByPrimaryKey(model.getId());
			if(role != null && !role.getRoleName().equals(model.getRoleName())) {
				log.warn("角色名不可修改！");
				return new ValidateResult("角色名不允许修改");
			}
		}
		if(StringUtils.isNotBlank(model.getRoleName())) {
			SecuRole role = secuRoleService.selectByRoleName(model.getRoleName());
			if(role != null && !(role.getId().equals(model.getId()))) {
				log.warn("已经存在此名的角色："+ model.getRoleName());
				return new ValidateResult("角色名已经存在");
			}
		}
		return ValidateResult.Passed;
	}
	
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(SecuRole role,ModelMap modelMap) {
		log.debug(role.toString());
		initModel(role);
		ValidateResult vr = validate(role);
		if(!vr.isPassed()) {
			modelMap.put("model", role);
			modelMap.put("errorMsg", vr.getMsg());
			return webPrefix()+"edit";
		}
		if(role.getId() == null) {
			secuRoleService.insert(role);
		}
		else {
			secuRoleService.updateByPrimaryKey(role);
		}
		return list(modelMap);
	}
	
	@RequestMapping(value="/configMenus/{roleName}", method = RequestMethod.GET)
	public String configMenus(@PathVariable(name="roleName") String roleName, ModelMap modelMap) {
		SecuRole currentRole = secuRoleService.selectByRoleName(roleName);
		List<SecuRoleMenu> mappingList = secuRoleMenuService.selectByRoleName(roleName);
		List<String> names = new ArrayList<>();
		for(SecuRoleMenu srm: mappingList)
			names.add("'" + srm.getMenuName() +"'");
		String selectedMenuNames = String.join(",", names);
		SecuMenuExample example = new SecuMenuExample();
		example.setOrderByClause(" id desc");
		List<SecuMenu> allMenus = secuMenuService.selectByExample(example);
		log.debug("size:" + mappingList.size());
		modelMap.put("selectedMenuNames", "["+selectedMenuNames+"]");
		modelMap.put("allMenus", allMenus);
		modelMap.put("role", currentRole);
		return webPrefix() + "/configMenus";
	}
	
	@RequestMapping(value="/configMenus", method = RequestMethod.POST)
	public String configMenus(@RequestParam(name="roleName") String roleName,@RequestParam(value="selectedIds") String selectedMenuIds, ModelMap modelMap) {
		log.debug(roleName);
		Map<String,SecuRoleMenu> existingMap = new HashMap<>();
		List<SecuRoleMenu> mappingList = secuRoleMenuService.selectByRoleName(roleName);
		for(SecuRoleMenu srm: mappingList)
			existingMap.put(srm.getRoleName(), srm);
		
		List<SecuMenu> allMenus = secuMenuService.selectByExample(new SecuMenuExample());
		Set<String> allMenuNames = new HashSet<>();
		for(SecuMenu sm : allMenus)
			allMenuNames.add(sm.getMenuName());
		String[] idArray = StringUtils.defaultIfEmpty(selectedMenuIds, "").split(",");
		for(String menuName : idArray) {
			if(existingMap.keySet().contains(menuName)) {
				mappingList.remove(existingMap.get(menuName));
			}
			else {
				if(!allMenuNames.contains(menuName))
					continue;
				SecuRoleMenu srm = new SecuRoleMenu();
				srm.setRoleName(roleName);
				srm.setMenuName(menuName);
				initModel(srm);
				secuRoleMenuService.insert(srm);
			}
		}
		for(SecuRoleMenu srm: mappingList) {
			secuRoleMenuService.deleteByPrimaryKey(srm.getId());
		}
		
		return list(modelMap);
	}
	
	
	@RequestMapping(value="/configUsers/{roleName}", method = RequestMethod.GET)
	public String configUsers(@PathVariable(name="roleName") String roleName, ModelMap modelMap) {
		SecuRole currentRole = secuRoleService.selectByRoleName(roleName);
		List<SecuUserRole> mappingList = secuUserRoleService.selectByRoleName(roleName);
		List<String> selectedUserNames = new ArrayList<String>();
		for(SecuUserRole sur: mappingList)
			selectedUserNames.add(sur.getUserName());
		
		List<SecuUser> unselectedUsers = new ArrayList<>();
		List<SecuUser> selectedUsers = new ArrayList<>();
		List<SecuUser> allUsers = secuUserService.selectByExample(new SecuUserExample());
		for(SecuUser user: allUsers) {
			if(selectedUserNames.contains(user.getUserName())) {
				selectedUsers.add(user);
			}
			else {
				unselectedUsers.add(user);
			}
		}
		log.debug("size:" + mappingList.size());
		modelMap.put("selectedList", selectedUsers);
		modelMap.put("unselectedList", unselectedUsers);
		modelMap.put("role", currentRole);
		
		return webPrefix() + "/configUsers";
	}
	
	
	@RequestMapping(value="/configUsers", method = RequestMethod.POST)
	public String configUsers(@RequestParam(value="roleName") String roleName, @RequestParam(value="selectedIds") String selectedUserNames, ModelMap modelMap) {
		log.debug(roleName);
		List<SecuUserRole> mappingList = secuUserRoleService.selectByRoleName(roleName);
		Map<String,SecuUserRole> existingMap = new HashMap<>();
		for(SecuUserRole sur: mappingList)
			existingMap.put(sur.getUserName(),sur);
		
		String[] idArray = StringUtils.defaultIfEmpty(selectedUserNames, "").split("-");
		for(String userName : idArray) {
			if(existingMap.keySet().contains(userName)) {
				mappingList.remove(existingMap.get(userName));
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
		return list(modelMap);
	}

	@Override
	protected BaseService<? extends BaseModel, ? extends BaseExample> getService() {
		// TODO Auto-generated method stub
		return secuRoleService;
	}

	@Override
	protected String webPrefix() {
		// TODO Auto-generated method stub
		return "/sys/secuRole/";
	}
}
