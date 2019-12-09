package com.ylsq.frame.sys.secu.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
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
import com.ylsq.frame.sys.secu.custobj.CustOrg;
import com.ylsq.frame.sys.secu.dao.model.SecuOrg;
import com.ylsq.frame.sys.secu.dao.model.SecuOrgExample;
import com.ylsq.frame.sys.secu.service.SecuOrgService;
import com.ylsq.frame.sys.secu.service.SecuUserService;



/**
 * Created by Harper.
 */
@Controller
@RequestMapping("/sys/org")
public class SecuOrgController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(SecuOrgController.class);
	
	@Autowired
	private SecuOrgService secuOrgService;
	@Autowired
	private SecuUserService secuUserService;
	
	
	@RequestMapping(value = "/orglist", method = RequestMethod.GET)
	public String orglist(@RequestParam(required = false, defaultValue = "0", value = "parentId") Long parentId,ModelMap modelMap) {
		// TODO Auto-generated method stub
		List<SecuOrg> secuOrgs = secuOrgService.selectByExample(new SecuOrgExample());
		List<CustOrg> orgList = secuOrgService.buildCustomOrgs(secuOrgs);
		List<SecuOrg> subList = secuOrgService.selectByParentId(parentId);
		modelMap.put("parentId", parentId);
		modelMap.put("modelList", subList);
		modelMap.put("orgList", orgList);
		return webPrefix() + "list";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	private String list(ModelMap modelMap) {
		return orglist(SystemConstants.Root_Org_Id, modelMap);
	}
	
	@RequestMapping(value= "/createOrg", method = RequestMethod.GET)
	public String create(@RequestParam("parentId") Long parentId, ModelMap modelMap) {
		beforeEditOrg(parentId, modelMap);
		return webPrefix()+"edit";
	}
	
	@RequestMapping(value= "/editOrg/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable(name="id") String id,ModelMap modelMap) {
		log.debug(id);
		SecuOrg model = secuOrgService.selectByPrimaryKey(Long.parseLong(id));
		beforeEditOrg(model.getParentId(), modelMap);
		modelMap.put("model", model);
		return webPrefix()+"edit";
	}
	
	protected void beforeEditOrg(Long parentId, ModelMap modelMap) {
		// TODO Auto-generated method stub
		SecuOrg parentOrg = new SecuOrg();
		if(parentId == SystemConstants.Root_Org_Id) {
			parentOrg.setOrgName("Root");
			parentOrg.setId(SystemConstants.Root_Org_Id);
		}
		else {
			parentOrg = secuOrgService.selectByPrimaryKey(parentId);
		}
		
		modelMap.put("parentOrg", parentOrg);
	}
	
	@RequestMapping(value= "/deleteOrgs/{ids}", method = RequestMethod.GET)
	public String delete(@PathVariable(name="ids") String ids,ModelMap modelMap) {
		if(StringUtils.isNotBlank(ids)) {
			String[] idArray = ids.split("-");
			Set<String> failedNames = new HashSet<>();
			for (String idStr : idArray) {
				if (StringUtils.isBlank(idStr)) {
					continue;
				}
				Long oid = Long.parseLong(idStr);
				int userCnt = secuUserService.countbyOrgId(oid);
				if(userCnt == 0) {
					List<SecuOrg> olist = secuOrgService.selectByParentId(oid);
					if(olist.size() == 0) {
						secuOrgService.deleteByPrimaryKey(oid);
					}
					else {
						log.warn(oid + "存在子机构，请先移除子机构");
						failedNames.add(oid+"");
					}
				}
				else {
					log.warn(oid + "已经被配置了某些用户，请先移除绑定的用户");
					failedNames.add(oid+"");
				}
				
			}
			
			if(failedNames.size()> 0) {
				modelMap.put("errorMsg", "机构("+String.join(",",failedNames)+")未删除成功，请先移除子机构或删除机构下的用户再重试");
			}
			else {
				modelMap.put("errorMsg", "操作成功");
			}
		}
		return list(modelMap);
	}
	
	protected ValidateResult validate(SecuOrg model) {
		if(model.getId() != null) {
			SecuOrg existing = secuOrgService.selectByPrimaryKey(model.getId());
			if(existing != null && !existing.getOrgName().equals(model.getOrgName())) {
				return new ValidateResult("机构名称不允许修改");
			}
		}
		SecuOrg org = secuOrgService.selectByName(model.getOrgName());
		if(org != null && !(org.getId().equals(model.getId()))) {
			log.warn("已经存在此名称的机构："+ model.getOrgName());
			return new ValidateResult("机构名称已经存在");
		}
		return ValidateResult.Passed;
	}
	
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(SecuOrg model,ModelMap modelMap) {
		log.debug(model.toString());
		initModel(model);
		
		ValidateResult vr = validate(model);
		if(!vr.isPassed()) {
			beforeEditOrg(model.getParentId(), modelMap);
			modelMap.put("model", model);
			modelMap.put("errorMsg", vr.getMsg());
			return webPrefix()+"edit";
		}
		if(model.getId() == null) {
			secuOrgService.insert(model);
		}
		else {
			secuOrgService.updateByPrimaryKey(model);
		}
		return orglist(model.getParentId() , modelMap);
	}
	
	@Override
	protected String webPrefix() {
		// TODO Auto-generated method stub
		return "/sys/secuOrg/";
	}
}