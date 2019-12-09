package com.ylsq.frame.common.base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class BaseModelController extends BaseController{
	private static Logger log = LoggerFactory.getLogger(BaseModelController.class);
	
	@RequestMapping(value= "/defaultlist", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		return list(1, modelMap);
	}
	
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public String list(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum, ModelMap modelMap) {
		log.debug("displaying LIST page");
		beforeList(modelMap);
		List<? extends BaseModel> list = getModelList();
		modelMap.put("modelList", list);
		return webPrefix()+"list";
	}
	
	@RequestMapping(value= "/create", method = RequestMethod.GET)
	public String create(ModelMap modelMap) {
		beforeEdit(modelMap);
		return webPrefix()+"edit";
	}
	
	@RequestMapping(value= "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable(name="id") String id,ModelMap modelMap) {
		log.debug(id);
		beforeEdit(modelMap);
		BaseModel model = getService().selectByPrimaryKey(Long.parseLong(id));
		modelMap.put("model", model);
		return webPrefix()+"edit";
	}
	
	@RequestMapping(value= "/delete/{ids}", method = RequestMethod.GET)
	public String delete(@PathVariable(name="ids") String ids,ModelMap modelMap) {
		int cnt = getService().deleteByPrimaryKeys(ids);
		log.debug(cnt + ":" + ids);
		return list(modelMap);
	}
	
	
	protected void beforeEdit(ModelMap modelMap) {
	}
	
	protected void beforeList(ModelMap modelMap) {
	}
    
	protected BaseService<? extends BaseModel,? extends BaseExample> getService() {
		throw new UnsupportedOperationException();
	}
	
	protected List<? extends BaseModel> getModelList(){
		throw new UnsupportedOperationException();
	}
	
}
