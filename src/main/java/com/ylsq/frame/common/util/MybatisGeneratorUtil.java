package com.ylsq.frame.common.util;

import static com.ylsq.frame.common.util.StringUtil.lineToHump;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.velocity.VelocityContext;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 代码生成类
 * Created by ZhangShuzheng on 2017/1/10.
 */
public class MybatisGeneratorUtil {

	// generatorConfig模板路径
	private static String generatorConfig_vm = "/template/generatorConfig.vm";
	// Service模板路径
	private static String service_vm = "/template/Service.vm";
	// ServiceMock模板路径
	private static String serviceMock_vm = "/template/ServiceMock.vm";
	// ServiceImpl模板路径
	private static String serviceImpl_vm = "/template/ServiceImpl.vm";
	// Controller模板路径
	private static String controller_vm = "/template/Controller.vm";
	private static String listPage_vm = "/template/list.vm";
	private static String editPage_vm = "/template/edit.vm";

	/**
	 * 根据模板生成generatorConfig.xml文件
	 * @param jdbcDriver   驱动路径
	 * @param jdbcUrl      链接
	 * @param jdbcUsername 帐号
	 * @param jdbcPassword 密码
	 * @param module        项目模块
	 * @param database      数据库
	 * @param tablePrefix  表前缀
	 * @param packageName  包名
	 */
	public static void generator(
			String jdbcDriver,
			String jdbcUrl,
			String jdbcUsername,
			String jdbcPassword,
			String module,
			String database,
			String tablePrefix,
			String packageName,
			Map<String, String> lastInsertIdTables,
			boolean deletefolder) throws Exception{

		String os = System.getProperty("os.name");
		String targetProject = module + "/" + module + "-dao";
		String basePath = MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/classes/", "").replace(targetProject, "");
		if (os.toLowerCase().startsWith("win")) {
			generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath().replaceFirst("/", "");
			service_vm = MybatisGeneratorUtil.class.getResource(service_vm).getPath().replaceFirst("/", "");
			serviceMock_vm = MybatisGeneratorUtil.class.getResource(serviceMock_vm).getPath().replaceFirst("/", "");
			serviceImpl_vm = MybatisGeneratorUtil.class.getResource(serviceImpl_vm).getPath().replaceFirst("/", "");
			controller_vm = MybatisGeneratorUtil.class.getResource(controller_vm).getPath().replaceFirst("/", "");
			basePath = basePath.replaceFirst("/", "");
		} else {
			generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath();
			service_vm = MybatisGeneratorUtil.class.getResource(service_vm).getPath();
			serviceMock_vm = MybatisGeneratorUtil.class.getResource(serviceMock_vm).getPath();
			serviceImpl_vm = MybatisGeneratorUtil.class.getResource(serviceImpl_vm).getPath();
			controller_vm = MybatisGeneratorUtil.class.getResource(controller_vm).getPath();
			listPage_vm = MybatisGeneratorUtil.class.getResource(listPage_vm).getPath();
			editPage_vm = MybatisGeneratorUtil.class.getResource(editPage_vm).getPath();
		}

		String generatorConfigXml = MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/classes/", "") + "/src/main/resources/generatorConfig.xml";
//		targetProject = basePath + targetProject;
		targetProject = basePath + "/";
		String sql = "SELECT table_name, table_comment FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '" + database + "' AND table_name LIKE '" + tablePrefix + "%';";

		System.out.println("========== 开始生成generatorConfig.xml文件 ==========");
		List<Map<String, Object>> tables = new ArrayList<>();
		try {
			VelocityContext context = new VelocityContext();
			Map<String, Object> table;

			// 查询定制前缀项目的所有表
			JdbcUtil jdbcUtil = new JdbcUtil(jdbcDriver, jdbcUrl, jdbcUsername, AESUtil.aesDecode(jdbcPassword));
			List<Map> result = jdbcUtil.selectByParams(sql, null);
			for (Map map : result) {
				System.out.println(map.get("TABLE_NAME"));
				table = new HashMap<>(3);
				table.put("table_name", map.get("TABLE_NAME"));
				table.put("table_comment", map.get("TABLE_COMMENT"));
				table.put("model_name", lineToHump(ObjectUtils.toString(map.get("TABLE_NAME"))));
				tables.add(table);
			}
			jdbcUtil.release();

//			String targetProjectSqlMap = basePath + "/" + module + "-rpc-service";
			String targetProjectSqlMap = basePath + "/";
			context.put("tables", tables);
			context.put("generator_javaModelGenerator_targetPackage", packageName + ".dao.model");
			context.put("generator_sqlMapGenerator_targetPackage", packageName + ".dao.mapper");
			context.put("generator_javaClientGenerator_targetPackage", packageName + ".dao.mapper");
			context.put("targetProject", targetProject);
			context.put("targetProject_sqlMap", targetProjectSqlMap);
			context.put("generator_jdbc_password", AESUtil.aesDecode(jdbcPassword));
			context.put("last_insert_id_tables", lastInsertIdTables);
			// 删除旧代码
			
			if(deletefolder) {
				deleteDir(new File(targetProject + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dao/model"));
				deleteDir(new File(targetProject + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dao/mapper"));
				deleteDir(new File(targetProjectSqlMap + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dao/mapper"));
			}
			else {
				deleteExisting(targetProject + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dao/mapper",tables,false);
				deleteExisting(targetProject + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dao/model",tables,true);
			}
			VelocityUtil.generate(generatorConfig_vm, generatorConfigXml, context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("========== 结束生成generatorConfig.xml文件 ==========");

		System.out.println("========== 开始运行MybatisGenerator ==========");
		List<String> warnings = new ArrayList<>();
		File configFile = new File(generatorConfigXml);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		for (String warning : warnings) {
			System.out.println(warning);
		}
		System.out.println("========== 结束运行MybatisGenerator ==========");

		System.out.println("========== 开始生成Service ==========");
		String ctime = new SimpleDateFormat("yyyy/M/d").format(new Date());
		String servicePath = basePath +"/src/main/java/" + packageName.replaceAll("\\.", "/") + "/service";
		String serviceImplPath = basePath +"/src/main/java/" + packageName.replaceAll("\\.", "/") + "/service/impl";
		String controllerPath = basePath +"/src/main/java/" + packageName.replaceAll("\\.", "/") + "/web";
		String pagesPath = basePath +"/src/main/webapp/WEB-INF/pages/";
		for (int i = 0; i < tables.size(); i++) {
			String tableName = ObjectUtils.toString(tables.get(i).get("table_name"));
			String model = StringUtil.lineToHump(tableName);
			String service = servicePath + "/" + model + "Service.java";
			String serviceMock = servicePath + "/" + model + "ServiceMock.java";
			String serviceImpl = serviceImplPath + "/" + model + "ServiceImpl.java";
			String controller = controllerPath + "/" + model + "Controller.java";
			String listPage = pagesPath + "/" + "list.vm";
			String editPage = pagesPath + "/" + "edit.vm";
			// 生成service
			File serviceFile = new File(service);
			if (!serviceFile.exists()) {
				VelocityContext context = new VelocityContext();
				context.put("package_name", packageName);
				context.put("model", model);
				context.put("ctime", ctime);
				VelocityUtil.generate(service_vm, service, context);
				System.out.println(service);
			}
			// 生成serviceMock
			File serviceMockFile = new File(serviceMock);
			if (!serviceMockFile.exists() ) {
				VelocityContext context = new VelocityContext();
				context.put("package_name", packageName);
				context.put("model", model);
				context.put("ctime", ctime);
//				VelocityUtil.generate(serviceMock_vm, serviceMock, context);
				System.out.println(serviceMock);
			}
			// 生成serviceImpl
			File serviceImplFile = new File(serviceImpl);
			if (!serviceImplFile.exists()) {
				VelocityContext context = new VelocityContext();
				context.put("package_name", packageName);
				context.put("model", model);
				context.put("mapper", StringUtil.toLowerCaseFirstOne(model));
				context.put("ctime", ctime);
				VelocityUtil.generate(serviceImpl_vm, serviceImpl, context);
				System.out.println(serviceImpl);
			}
			// 生成controller
			File controllerFile = new File(controller);
			if (!controllerFile.exists()) {
				VelocityContext context = new VelocityContext();
				context.put("package_name", packageName);
				context.put("model", model);
				context.put("tableName", tableName);
				context.put("mapper", StringUtil.toLowerCaseFirstOne(model));
				context.put("modelVariable", StringUtil.toLowerCaseFirstOne(model));
				context.put("ctime", ctime);
				VelocityUtil.generate(controller_vm, controller, context);
				System.out.println(controller);
			}
			// 生成page
			File listPageFolder = new File(pagesPath);
			if (listPageFolder.exists()) {
				VelocityContext context = new VelocityContext();
				context.put("package_name", packageName);
				context.put("tableName", tableName);
				context.put("tableComment", tables.get(i).get("table_comment"));
				context.put("model", model);
				context.put("modelVariable", StringUtil.toLowerCaseFirstOne(model));
				context.put("ctime", ctime);
//				VelocityUtil.generate(listPage_vm, pagesPath+"/list.vm", context);
//				VelocityUtil.generate(listPage_vm, pagesPath+"/edit.vm", context);
				System.out.println(pagesPath);
			}
		}
		System.out.println("========== 结束生成Service ==========");
	}
	
	public static void deleteExisting(String path,List<Map<String, Object>> tables, boolean ismodel) {
		for(Map<String,Object> map : tables) {
			String modelName = (String)map.get("model_name");
			if(ismodel) {
				File modelJava = new File(path + File.separator + modelName +".java");
				File exampleJava = new File(path + File.separator + modelName +"Example.java");
				
				if(modelJava.exists()) {
					System.out.println(modelJava);
					modelJava.delete();
				}
				if(exampleJava.exists()) {
					System.out.println(exampleJava);
					exampleJava.deleteOnExit();
				}
			}
			else {
				File mapperJava = new File(path + File.separator + modelName +"Mapper.java");
				File mapperXml = new File(path + File.separator + modelName +"Mapper.xml");
				if(mapperJava.exists()) {
					System.out.println(mapperJava);
					mapperJava.deleteOnExit();
				}
				if(mapperXml.exists()) {
					System.out.println(mapperXml);
					mapperXml.deleteOnExit();
				}
			}
		}
	}

	// 递归删除非空文件夹
	public static void deleteDir(File dir) {
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteDir(files[i]);
			}
		}
		dir.delete();
	}

}
