package com.sparrow.zg.abstructFactory;

import javax.sql.DataSource;

class DateAccess{
	private static String db = "sqlserver";
	public static IUserDao createUser(){
		switch (db){
			case "sqlserver": return new SqlServerUser();
			case "access" : return new AccessUser();
			default:
				try {
					throw new Exception("数据库不和法");
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	public static IDepartment createDepartment(){
		switch (db){
			case "sqlserver": return new SqlServerDepartment();
			case "access" : return new AccessDepartment();
			default:
				try {
					throw new Exception("数据库不和法");
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return null;
	}
}
public class SimplerAndAbstructFactory {
	public static void main(String[] args) {
		IUserDao iUserDao = DateAccess.createUser();
		IDepartment iDepartment = DateAccess.createDepartment();
		iUserDao.insert(new User());
		iDepartment.insert(new User());
	}
}
