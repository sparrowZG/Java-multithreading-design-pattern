package com.sparrow.zg.decorate;

/**
 * 装饰类继承人类,具体的装饰继承真实的装饰类,
 */
class Person{
	public void show(){
		System.out.println("装扮");
	}
}
class Finery extends Person{
	public Person person;
	public Finery(){}
	public void Decorate(Person person){
		this.person = person;
	}
	public void show(){
		person.show();
	}

}
class TShirts extends Finery {
	public void show() {
		super.show();
		System.out.println("T装扮");
	}
}
class BigTrouser extends Finery{
	@Override
	public void show() {
		super.show();
		System.out.println("BigTrouser装扮");
	}
}
public class ClothingPerson {
	public static void main(String[] args) {
		Person zhang = new Person();

		Finery finery = new Finery();
		TShirts tShirts = new TShirts();
		BigTrouser bigDecimal = new BigTrouser();
		finery.Decorate(zhang);
		bigDecimal.Decorate(finery);
		tShirts.Decorate(bigDecimal);
		tShirts.show();
	}
}
