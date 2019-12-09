package com.ylsq.frame.sys.quartz;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.ylsq.frame.common.base.SysParamEnum;
import com.ylsq.frame.sys.base.custobj.SystemSetting;
import com.ylsq.frame.sys.base.dao.model.SysParamConfig;
import com.ylsq.frame.sys.base.dao.model.SysParamValue;
import com.ylsq.frame.sys.base.service.SysParamConfigService;
import com.ylsq.frame.sys.base.service.SysParamValueService;

@Service
public class DbAutomatBackUpJob extends QuartzJobBean{
	private Logger log = LoggerFactory.getLogger(DbAutomatBackUpJob.class);
	
	@Autowired
	private SysParamValueService sysParamValueService;
	@Autowired
	private SysParamConfigService sysParamConfigService;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		log.debug("DB backup job is been triggered now.");
		List<SysParamConfig> configs = sysParamConfigService.selectByParamName(SysParamEnum.System_Config.getConstant());
		int valueIndex = -1;
		int index = 1;
		for(SysParamConfig spc : configs) {
			if(SystemSetting.Config_Db_backup_path.equals(spc.getConfigName())) {
				valueIndex = index;
				break;
			}
			index++;
		}
		List<SysParamValue> values = sysParamValueService.selectByParamName(SysParamEnum.System_Config.getConstant());
		if(values.size() > 0) {
			String dbBackupPath = sysParamValueService.getValue(values.get(0), valueIndex);
			log.info("DB back up to :" + dbBackupPath);
			String command = backupCmd(context, dbBackupPath);
			try {
				Process process = Runtime.getRuntime().exec(command);
				int ret = process.waitFor();
				log.debug("return: " + ret);
				if(ret == 0) {
					log.info("backup successfully.");
				}
				else {
					String tmp = null;
					BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
					while((tmp = br.readLine() ) != null) {
						log.error(tmp);
					}
				}
				
			}catch(Exception e) {
				log.error(e.getMessage());
			}
		}
		log.debug("DB backup completed");
	}
	
	private String backupCmd(JobExecutionContext context, String dbBackupPath) {
		JobDataMap map = context.getMergedJobDataMap();
		String uname = null;
		String upassword = null;
		String dbname = null;
		for(String key : map.keySet()) {
			if(key.contains("name")) {
				uname = map.getString(key);
			}
			else if(key.contains("pass")) {
				upassword = map.getString(key);
			}
			else if(key.contains("url")) {
				String url = map.getString(key).split("\\?")[0];
				String portAndName = url.split("\\:")[3];
				dbname = portAndName.split("\\/")[1];
			}
		}
		String command = String.format("mysqldump --databases -u %s -p%s %s >%s%sbackup.sql",uname, upassword,dbname, dbBackupPath,File.separator);
		if(StringUtils.isBlank(uname) || StringUtils.isBlank(upassword) || StringUtils.isBlank(dbname)) {
			log.warn("DB backup command was not built.");
		}
		log.debug(command);
		return command;
	}

}
