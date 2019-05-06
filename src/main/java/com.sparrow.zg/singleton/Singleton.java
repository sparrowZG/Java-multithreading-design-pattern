package com.sparrow.zg.singleton;

class SingletonDemo{
	//懒汉双重检锁单例
	private static  volatile Singleton singleton;
	private void Singleton(){
	}
	public static Singleton getSingleton(){
		if(singleton==null){
			synchronized (SingletonDemo.class){
				if(singleton==null){
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

}
public class Singleton {
	public static void main(String[] args) {
		Singleton s1 = SingletonDemo.getSingleton();
		Singleton s2 = SingletonDemo.getSingleton();
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
	}
}
