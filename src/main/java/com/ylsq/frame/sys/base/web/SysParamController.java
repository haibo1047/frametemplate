package com.ylsq.frame.sys.base.web;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

import com.ylsq.frame.common.base.BaseExample;
import com.ylsq.frame.common.base.BaseModel;
import com.ylsq.frame.common.base.BaseModelController;
import com.ylsq.frame.common.base.BaseService;
import com.ylsq.frame.common.base.SysParamEnum;
import com.ylsq.frame.common.base.ValidateResult;
import com.ylsq.frame.common.util.DataTypeValidator;
import com.ylsq.frame.sys.base.dao.model.SysParam;
import com.ylsq.frame.sys.base.dao.model.SysParamConfig;
import com.ylsq.frame.sys.base.dao.model.SysParamExample;
import com.ylsq.frame.sys.base.dao.model.SysParamValue;
import com.ylsq.frame.sys.base.dao.model.SysParamValueExample;
import com.ylsq.frame.sys.base.service.SysParamConfigService;
import com.ylsq.frame.sys.base.service.SysParamService;
import com.ylsq.frame.sys.base.service.SysParamValueService;
import com.ylsq.frame.sys.base.sorter.ParamConfigSorter;

@Controller
@RequestMapping("/sys/param")
public class SysParamController extends BaseModelController {
	private static Logger log = LoggerFactory.getLogger(SysParamController.class);
	
	@Autowired
	private SysParamService sysParamService;
	@Autowired
	private SysParamConfigService sysParamConfigService;
	@Autowired
	private SysParamValueService sysParamValueService;
	
	@RequestMapping(value= "/createValue/{paramName}", method = RequestMethod.GET)
	public String createValue(@PathVariable(value="paramName")String paramName,ModelMap modelMap) {
		List<SysParamConfig> configList = sysParamConfigService.selectByParamName(paramName);
		List<SysParamValue> valueList = sysParamValueService.selectByParamName(paramName);
		SysParamValue model = new SysParamValue();
		model.setParamName(paramName);
		modelMap.put("model", model);
		modelMap.put("configList", configList);
		modelMap.put("valueList", valueList);
		return webPrefix()+"editValue";
	}
	
	@RequestMapping(value= "/editValue/{id}", method = RequestMethod.GET)
	public String editValue(@PathVariable(name="id") String id,ModelMap modelMap) {
		log.debug(id);
		SysParamValue model = sysParamValueService.selectByPrimaryKey(Long.parseLong(id));
		List<SysParamConfig> configList = sysParamConfigService.selectByParamName(model.getParamName());
		modelMap.put("model", model);
		modelMap.put("configList", configList);
		return webPrefix()+"editValue";
	}
	
	public String errorEdit(String paramName, ModelMap modelMap) {
		List<SysParamConfig> configList = sysParamConfigService.selectByParamName(paramName);
		modelMap.put("configList", configList);
		return webPrefix()+"editValue";
	}
	
	private void validate(SysParamValue value) throws Exception {
		List<SysParamConfig> configs = sysParamConfigService.selectByParamName(value.getParamName());
		Collections.sort(configs, new ParamConfigSorter());
		SysParamValueExample example = new SysParamValueExample();
		SysParamValueExample.Criteria criteria = example.createCriteria().andParamNameEqualTo(value.getParamName());
		List<String> uniqColumns = new ArrayList<>();
		for(int index = 0; index < configs.size(); index ++) {
			SysParamConfig config = configs.get(index);
			Method mtd = SysParamValue.class.getMethod("getValue"+(index+1) , null);
			String currValue = mtd.invoke(value, null).toString();
			
			String field = config.getShowName()+"["+config.getConfigName() +"]";
//			if(StringUtils.isBlank(currValue)) {
//				if(new Integer(1).equals(config.getNotNull()))
//					throw new Exception(field +"不能为空");
//				else
//					continue;
//			}
//			if(currValue.length() > config.getDataLength()) {
//				throw new Exception(field + "超过定义的长度("+config.getDataLength()+")");
//			}
//			
//			if("Integer".equals(config.getDataType()) && !StringUtils.isNumeric(currValue)) {
//				throw new Exception(field + "定义为数值型，请检查"+currValue);
//			}
			ValidateResult vr = new DataTypeValidator().validate(field, currValue, config.getDataType(), config.getDataLength(), config.getNotNull());
			if(!vr.isPassed()) {
				throw new Exception(vr.getMsg());
			}
			if(StringUtils.isNotBlank(currValue) && new Integer(1).equals(config.getIsOfUniq())) {
				Method md = criteria.getClass().getMethod("andValue"+(index+1)+"EqualTo", currValue.getClass());
				md.invoke(criteria, currValue);
				uniqColumns.add(config.getShowName());
			}
		}
		if( criteria != null) {
			List<SysParamValue> dbList = sysParamValueService.selectByExample(example);
			if(dbList.size() ==0)
				return;
			if(dbList.size()>1 || value.getId() == null) {
				String tips = String.join("+", uniqColumns);
				throw new Exception("此参数已经存在，请重新录入:" + tips);
			}
		}
	}
	
	@RequestMapping(value= "/saveValue", method = RequestMethod.POST)
	public String saveValue(SysParamValue param,ModelMap modelMap) {
		log.debug(param.toString());
		initModel(param);
		try {
			validate(param);
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			modelMap.put("errorMsg", e.getMessage());
			modelMap.put("model", param);
			return errorEdit(param.getParamName(),modelMap);
		}
		if(param.getId() == null) {
			sysParamValueService.insert(param);
		}
		else {
			sysParamValueService.updateByPrimaryKey(param);
		}
		return values(param.getParamName(),modelMap);
	}
	
	@RequestMapping(value= "/deleteValue/{paramName}/{ids}", method = RequestMethod.GET)
	public String deleteValue(@PathVariable(value="paramName")String paramName,@PathVariable(name="ids") String ids,ModelMap modelMap) {
		int cnt = sysParamValueService.deleteByPrimaryKeys(ids);
		log.debug(cnt + ":" + ids);
		return values(paramName,modelMap);
	}
	
	@RequestMapping(value= "/values/{paramName}", method = RequestMethod.GET)
	public String values(@PathVariable(value="paramName")String paramName,ModelMap modelMap) {
		List<SysParamConfig> configList = sysParamConfigService.selectByParamName(paramName);
		List<SysParamValue> valueList = sysParamValueService.selectByParamName(paramName);
		modelMap.put("configList", configList);
		modelMap.put("valueList", valueList);
		modelMap.put("paramName", paramName);
		return webPrefix()+"valueList";
	}
	
	@RequestMapping(value= "/createConfig/{paramName}", method = RequestMethod.GET)
	public String createConfig(@PathVariable(value="paramName")String paramName,ModelMap modelMap) {
		modelMap.put("dataTypeList", getParams(SysParamEnum.Param_Data_type.getConstant()));
		modelMap.put("alternativeList", getParams(SysParamEnum.Alternative.getConstant()));
		modelMap.put("paramName", paramName);
		return webPrefix()+"editConfig";
	}
	
	@RequestMapping(value= "/editConfig/{id}", method = RequestMethod.GET)
	public String editConfig(@PathVariable(name="id") String id,ModelMap modelMap) {
		log.debug(id);
		SysParamConfig model = sysParamConfigService.selectByPrimaryKey(Long.parseLong(id));
		modelMap.put("model", model);
		modelMap.put("paramName", model.getParamName());
		modelMap.put("dataTypeList", getParams(SysParamEnum.Param_Data_type.getConstant()));
		modelMap.put("alternativeList", getParams(SysParamEnum.Alternative.getConstant()));
		return webPrefix()+"editConfig";
	}
	@RequestMapping(value= "/saveConfig", method = RequestMethod.POST)
	public String saveConfig(SysParamConfig param,ModelMap modelMap) {
		log.debug(param.toString());
		initModel(param);
		if(param.getId() == null) {
			sysParamConfigService.insert(param);
		}
		else {
			sysParamConfigService.updateByPrimaryKey(param);
		}
		return config(param.getParamName(),modelMap);
	}
	@RequestMapping(value= "/deleteConfig/{paramName}/{ids}", method = RequestMethod.GET)
	public String deleteConfig(@PathVariable(value="paramName")String paramName,@PathVariable(name="ids") String ids,ModelMap modelMap) {
		int cnt = sysParamConfigService.deleteByPrimaryKeys(ids);
		log.debug(cnt + ":" + ids);
		return config(paramName,modelMap);
	}
	
	@RequestMapping(value="/config/{paramName}", method = RequestMethod.GET)
	public String config(@PathVariable(value="paramName")String paramName, ModelMap modelMap) {
		List<SysParamConfig> configList = sysParamConfigService.selectByParamName(paramName);
		

		modelMap.put("dataTypeList", getParams(SysParamEnum.Param_Data_type.getConstant()));
		modelMap.put("alternativeList", getParams(SysParamEnum.Alternative.getConstant()));
		modelMap.put("configList", configList);
		modelMap.put("paramName", paramName);
		return webPrefix() + "configList";
	}
	
	@Override
	public String list(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum, ModelMap modelMap) {
		// TODO Auto-generated method stub
		int pageSize = (int)SecurityUtils.getSubject().getSession().getAttribute("pageSize");
		List<SysParam> list =  sysParamService.selectByExampleForStartPage(new SysParamExample(), pageNum, pageSize);
		modelMap.put("modelList", list);
		modelMap.put("alternative", getParams(SysParamEnum.Alternative.getConstant()));
		modelMap.put("total", sysParamService.countByExample(new SysParamExample()));
		return webPrefix() + "list";
	}
	
	
	@Override
	protected void beforeEdit(ModelMap modelMap) {
		// TODO Auto-generated method stub
		modelMap.put("alternative", getParams(SysParamEnum.Alternative.getConstant()));
		super.beforeEdit(modelMap);
	}

	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(SysParam param,ModelMap modelMap) {
		log.debug(param.toString());
		initModel(param);
		if(param.getId() == null) {
			sysParamService.insert(param);
		}
		else {
			sysParamService.updateByPrimaryKey(param);
		}
		return list(modelMap);
	}
	
	@Override
	protected BaseService<? extends BaseModel, ? extends BaseExample> getService() {
		// TODO Auto-generated method stub
		return sysParamService;
	}

	@Override
	protected String webPrefix() {
		// TODO Auto-generated method stub
		return "sys/param/";
	}

}
