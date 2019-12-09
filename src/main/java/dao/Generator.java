package dao;

import java.util.HashMap;
import java.util.Map;

import com.ylsq.frame.common.util.MybatisGeneratorUtil;
import com.ylsq.frame.common.util.PropertiesFileUtil;

public class Generator {
	// 根据命名规范，只修改此常量值即可
		private static boolean DELETE_PKG = false;
		private static String MODULE = "dao";
		private static String DATABASE = "frame";
//		private static String TABLE_PREFIX = "tz_encrypt_client";
//		private static String PACKAGE_NAME = "com.ylsq.frame.tianze.encrypt";
//		private static String TABLE_PREFIX = "sys_param";
//		private static String PACKAGE_NAME = "com.ylsq.frame.sys.base";
//		private static String TABLE_PREFIX = "tz_base_";
//		private static String PACKAGE_NAME = "com.ylsq.frame.tianze.base";
		private static String TABLE_PREFIX = "secu_user";
		private static String PACKAGE_NAME = "com.ylsq.frame.sys.secu";  //注意设置该变量，它会想service项目的该文件夹下覆盖写入东西

		private static String JDBC_DRIVER = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.driver");
		private static String JDBC_URL = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.url");
		private static String JDBC_USERNAME = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.username");
		private static String JDBC_PASSWORD = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.password");
		// 需要insert后返回主键的表配置，key:表名,value:主键名
		private static Map<String, String> LAST_INSERT_ID_TABLES = new HashMap<>();
		static {
//			LAST_INSERT_ID_TABLES.put("sys_blob", "blob_id");
		}

		/**
		 * 自动代码生成
		 * @param args
		 */
		public static void main(String[] args) throws Exception {
			MybatisGeneratorUtil.generator(JDBC_DRIVER, JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD, MODULE, DATABASE, TABLE_PREFIX, PACKAGE_NAME, LAST_INSERT_ID_TABLES,DELETE_PKG);
		}
}
