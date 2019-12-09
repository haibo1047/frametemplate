package com.ylsq.frame.sys.secu.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
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

import com.ylsq.frame.common.base.BaseModelController;
import com.ylsq.frame.common.base.BaseService;
import com.ylsq.frame.common.base.SysParamEnum;
import com.ylsq.frame.common.base.ValidateResult;
import com.ylsq.frame.sys.secu.dao.model.SecuMenu;
import com.ylsq.frame.sys.secu.dao.model.SecuMenuExample;
import com.ylsq.frame.sys.secu.dao.model.SecuRoleMenu;
import com.ylsq.frame.sys.secu.service.SecuMenuService;
import com.ylsq.frame.sys.secu.service.SecuRoleMenuService;

@Controller
@RequestMapping("/sys/menu/")
public class SecuMenuController extends BaseModelController {
	private static Logger log = LoggerFactory.getLogger(SecuMenuController.class);
	
	@Autowired
	private SecuMenuService secuMenuService;
	@Autowired
	private SecuRoleMenuService secuRoleMenuService;
	
	@Override
	public String list(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum,ModelMap modelMap) {
		// TODO Auto-generated method stub
		int pageSize = (int)SecurityUtils.getSubject().getSession().getAttribute("pageSize");
		modelMap.put("moduleList", getParams(SysParamEnum.Menu_Module.getConstant()));
		modelMap.put("total", secuMenuService.countByExample(new SecuMenuExample()));
		modelMap.put("modelList", secuMenuService.selectByExampleForStartPage(new SecuMenuExample(), pageNum, pageSize));
		return webPrefix()+"list";
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
				Long mid = Long.parseLong(idStr);
				SecuMenu menu = secuMenuService.selectByPrimaryKey(mid);
				if(menu != null) {
					List<SecuRoleMenu> list = secuRoleMenuService.selectByMenuName(menu.getMenuName());
					if(list.size() > 0 ) {
						log.warn(menu.getMenuName() + "已经被配置给某些角色，请先移除绑定的角色");
						failedNames.add(menu.getMenuName());
						continue;
					}
					secuMenuService.deleteByPrimaryKey(mid);
				}
			}
			
			if(failedNames.size()> 0) {
				modelMap.put("errorMsg", "菜单("+String.join(",",failedNames)+")未删除成功，请先移除绑定的角色再重试");
			}
			else {
				modelMap.put("errorMsg", "操作成功");
			}
		}
		return list(modelMap);
	}


	@Override
	protected void beforeEdit(ModelMap modelMap) {
		// TODO Auto-generated method stub
		modelMap.put("moduleList", getParams(SysParamEnum.Menu_Module.getConstant()));
		super.beforeEdit(modelMap);
	}

	protected ValidateResult validate(SecuMenu model) {
		if(model.getId() != null) {
			SecuMenu existing = secuMenuService.selectByPrimaryKey(model.getId());
			if(existing != null && !existing.getMenuName().equals(model.getMenuName())) {
				return new ValidateResult("菜单名不允许修改");
			}
		}
		SecuMenu existing = secuMenuService.selectByMenuName(model.getMenuName());
		if(existing != null && !(existing.getId().equals(model.getId()))) {
			log.warn("菜单已经存在："+ model.getMenuName());
			return new ValidateResult("菜单名称已经存在");
		}
		return ValidateResult.Passed;
	}
	
	
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(SecuMenu menu,ModelMap modelMap) {
		log.debug(menu.toString());
		initModel(menu);
		
		ValidateResult vr = validate(menu);
		if(!vr.isPassed()) {
			modelMap.put("model", menu);
			modelMap.put("errorMsg", vr.getMsg());
			return webPrefix()+"edit";
		}
		if(menu.getId() == null) {
			secuMenuService.insert(menu);
		}
		else {
			secuMenuService.updateByPrimaryKey(menu);
		}
		return list(modelMap);
	}

	@Override
	protected BaseService<SecuMenu,SecuMenuExample> getService() {
		// TODO Auto-generated method stub
		return secuMenuService;
	}

	@Override
	protected String webPrefix() {
		// TODO Auto-generated method stub
		return "/sys/secuMenu/";
	}

}
