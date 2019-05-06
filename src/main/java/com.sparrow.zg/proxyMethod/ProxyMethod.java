package com.sparrow.zg.proxyMethod;

/**
 * 代理模式:
 *       一个真实类,一个代理类,共同实现一个买电脑接口,
 *       代理类中包含有真实类的实例,封装了复杂的业务逻辑
 *       通过一个工厂,创建一个卖电脑的操作对象
 *       客户端就只能看到是在买电脑
 *
 */
interface ISubject{
	void buyComputer();//核心是卖电脑
}

class RealSubject implements ISubject{
	@Override
	public void buyComputer() {
		System.out.println("买一台笔记本电脑");
	}
}
class ProxySubject implements ISubject{
	private ISubject realSubject;//代理类中有真实类的实例
	public ProxySubject(ISubject realSubject){
		this.realSubject = realSubject;
	}

	@Override
	public void buyComputer() {
		System.out.println("1.生产一个笔记本");
		realSubject.buyComputer();
		System.out.println("3.笔记本售后");
	}
}
class Factory{
	public static ISubject getInstance(){
		return new ProxySubject(new RealSubject());
	}
}
public class ProxyMethod {
	public static void main(String[] args) {
		ISubject iSubject = Factory.getInstance();
		iSubject.buyComputer();
	}
}
