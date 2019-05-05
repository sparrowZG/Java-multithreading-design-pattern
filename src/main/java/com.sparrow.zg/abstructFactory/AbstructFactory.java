package com.sparrow.zg.abstructFactory;

/**
 * 抽象工厂:
 * 思路:增加一个sql服务端,就会修改大量的代码
 * 简单工厂: 通过创建一个工厂,客户端不用管具体是调用的那个类,将对象的创建交给工厂,增加需求,需要修改工厂中的switch
 * 工厂方法: 通过定义一个抽象工厂,将具体的工厂创建交给子类去完成,增加需求,需要更改客户端
 * 抽象工厂: 一个工厂做好多事情
 */
class User {
	private String name;
	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

interface IUserDao {
	void insert(User user);

	void remove(User user);
}

class SqlServerUser implements IUserDao {
public void insert(User user) {
	System.out.println("在 Sql Server中 给 User 添加一个数据");
	}

public void remove(User user) {
	System.out.println("在 Sql Server中 从 User 删除一个数据");
	}
	}

class AccessUser implements IUserDao {
	public void insert(User user) {
		System.out.println("在 Access 中 给 User 添加一个数据");
	}

	public void remove(User user) {
		System.out.println("在 Access 中 从 User 删除一个数据");
	}
}
//***********************新增一个表操作Department******************************
class Department {
	private String name;
	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

interface IDepartment{
	void insert(User user);

	void remove(User user);
}

class SqlServerDepartment implements IDepartment {
	public void insert(User user) {
		System.out.println("在 Sql Server中 给 Department 添加一个数据");
	}

	public void remove(User user) {
		System.out.println("在 Sql Server中 从 Department 删除一个数据");
	}
}

class AccessDepartment implements IDepartment {
	public void insert(User user) {
		System.out.println("在 Access 中 给 Department 添加一个数据");
	}

	public void remove(User user) {
		System.out.println("在 Access 中 从 Department 删除一个数据");
	}
}

interface IUserFactory {
	IUserDao createUser();
	IDepartment createDepartment();
}

class SqlServerFactory implements IUserFactory {

	@Override
	public IUserDao createUser() {
		return new SqlServerUser();
	}

	@Override
	public IDepartment createDepartment() {
		return new SqlServerDepartment();
	}
}

class AccessFactory implements IUserFactory {

	@Override
	public IUserDao createUser() {
		return new AccessUser();
	}

	@Override
	public IDepartment createDepartment() {
		return new AccessDepartment();
	}
}

public class AbstructFactory {
	public static void main(String[] args) {
		/**
		 *
		 版本一: 表示问题
		 User user = new User();

		 SqlServerUser sqlServerUser = new SqlServerUser();
		 sqlServerUser.insert(user);
		 sqlServerUser.remove(user);
		 *
		 */
		/**
		 * 第二版: 工厂方法模式: 在客户端中只需要修改//IUserFactory iUserFactory = new SqlServerUserFactory();就能正常工作
		User user = new User();
		//IUserFactory iUserFactory = new SqlServerUserFactory();
		IUserFactory iUserFactory = new AccessUserFactory();
		IUserDao sqlServerUser = iUserFactory.createUser();
		sqlServerUser.insert(user);
		 */
		/**
		 *第三版: 抽象工厂模式: 在一个工厂中创建多个商品,
		 *
		User user = new User();

		IUserFactory iUserFactory = new SqlServerFactory();
		IUserDao iUserDao = iUserFactory.createUser();
		IDepartment iDepartment = iUserFactory.createDepartment();
		iUserDao.insert(user);
		iDepartment.insert(user);
		 */
	}
}
