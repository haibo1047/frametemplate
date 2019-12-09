package com.ylsq.frame.sys.base.web;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ylsq.frame.common.base.BaseController;
import com.ylsq.frame.common.base.SysParamEnum;
import com.ylsq.frame.common.base.ValidateResult;
import com.ylsq.frame.common.util.DataTypeValidator;
import com.ylsq.frame.sys.base.custobj.SystemSetting;
import com.ylsq.frame.sys.base.dao.model.SysParamConfig;
import com.ylsq.frame.sys.base.dao.model.SysParamValue;
import com.ylsq.frame.sys.base.service.SysParamConfigService;
import com.ylsq.frame.sys.base.service.SysParamValueService;



/**
 * Created by Harper.
 */
@Controller
@RequestMapping("/systemsetting")
public class SysSettingController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(SysSettingController.class);
	
	@Autowired
	private SysParamConfigService sysParamConfigService;
	@Autowired
	private SysParamValueService sysParamValueService;
	
	private static String param_key = SysParamEnum.System_Config.getConstant();
	private static String idParamKey = "valueId";
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String edit(ModelMap modelMap) throws Exception{
		List<SysParamValue> values = sysParamValueService.selectByParamName(param_key);
		SysParamValue value = null;
		if(values.size() > 0) {
			value = values.get(0);
			modelMap.put(idParamKey, value.getId());
		}
		List<SystemSetting> settings = initSetting(value);
		modelMap.put("settings", settings);
		return webPrefix();
	}
	
	private List<SystemSetting> initSetting(SysParamValue value) throws Exception{
		List<SysParamConfig> configs = sysParamConfigService.selectByParamName(param_key);
		List<SystemSetting> settings = new ArrayList<>();
		int index = 1;
		for(SysParamConfig spc: configs) {
			SystemSetting st = new SystemSetting();
			st.setValueIndex(index);
			st.setName(spc.getShowName());
			st.setConfig(spc.getConfigName());
			st.setDataType(spc.getDataType());
			st.setDataLength(spc.getDataLength());
			settings.add(st);
			if(value != null) {
				String currValue = sysParamValueService.getValue(value, index);
				st.setValue(currValue);
			}
			index++;
		}
		return settings;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(HttpServletRequest request,ModelMap modelMap) throws Exception{
		@SuppressWarnings("unchecked")
		Enumeration<String> pns = request.getParameterNames();
		Map<String,String> valueMap = new HashMap<>();
		Long valueId = 0l;
		while(pns.hasMoreElements()) {
			String pname = pns.nextElement();
			String pvalue = request.getParameter(pname);
			if(idParamKey.equals(pname)) {
				valueId = Long.parseLong(pvalue);
				modelMap.put(idParamKey, valueId);
				continue;
			}
			valueMap.put(pname, pvalue);
		}
		SysParamValue thevalue = sysParamValueService.selectByPrimaryKey(valueId);
		List<SystemSetting> settings = initSetting(thevalue);
		boolean updated = false;
		for(SystemSetting st : settings) {
			String pvalue = StringUtils.defaultIfEmpty(valueMap.get(st.getConfig()), "");
			if(pvalue.equals(st.getValue())) {
				continue;
			}
			sysParamValueService.setValue(thevalue, st.getValueIndex(), pvalue);
			st.setValue(pvalue);
			updated = true;
		}
		modelMap.put("settings", settings);
		if(updated) {
			ValidateResult vr = validate(settings);
			if(!vr.isPassed()) {
				modelMap.put("errorMsg", vr.getMsg());
				return webPrefix();
			}
			log.debug("system setting is being updated: " + thevalue);
			sysParamValueService.updateByPrimaryKeySelective(thevalue);
		}
		return webPrefix();
	}
	
	protected ValidateResult validate(List<SystemSetting> list) {
		for(SystemSetting st : list) {
			ValidateResult vr = new DataTypeValidator().validate(st.getName(), st.getValue(),st.getDataType(), st.getDataLength(), st.getNotNull());
			if(!vr.isPassed()) {
				return vr;
			}
			if(SystemSetting.Config_Db_backup_path.equals(st.getConfig())) {
				File file = new File(st.getValue());
				if(!file.exists()) {
					return new ValidateResult("数据库备份目录不存在:" + st.getValue() );
				}
				if(!file.canWrite()) {
					return new ValidateResult("数据库备份目录无写权限:" + st.getValue());
				}
			}
		}
		return ValidateResult.Passed;
	}
	

	@Override
	protected String webPrefix() {
		// TODO Auto-generated method stub
		return "/sys/common/setting";
	}
}