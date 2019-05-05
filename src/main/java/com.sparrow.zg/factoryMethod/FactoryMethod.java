package com.sparrow.zg.factoryMethod;

/**
 *工厂方法模式:
 *       1.一个抽象产品类
 *       2.多个具体产品类
 *       3.一个抽象工厂类
 *       4.多个具体工厂类,每一个具体产品对应一个工厂
 *       优点: 降低耦合,对象的生成交给子类去完成
 *             实现开闭原则,每个添加的子产品不需要修改源代码
 *
 *       工厂方法是定义一个接口让具体的工厂创建具体的类
 *
 */
class Add extends Operation {
	@Override
	public double getResult() {
		return super.numberA + numberB;
	}
}

class Sub extends Operation {
	@Override
	public double getResult() {
		return super.numberA - numberB;
	}
}

class Mul extends Operation {
	@Override
	public double getResult() {
		return super.numberA * numberB;
	}
}

class Div extends Operation {
	@Override
	public double getResult() {
		return super.numberA / numberB;
	}
}
/**
 * 运算类
 */
class Operation {
	public double numberA;
	public double numberB;


	public double getResult() {
		double result = 0;
		return result;
	}

}

/**
 *工厂接口
 */
interface IFactory {
	public Operation createOperation();
}

/**
 * 加法工厂
 */
class AddFactory implements IFactory{

	@Override
	public Operation createOperation() {
		return new Add();
	}
}
class SubFactory implements IFactory{

	@Override
	public Operation createOperation() {
		return new Sub();
	}
}
class MulFactory implements IFactory{

	@Override
	public Operation createOperation() {
		return new Mul();
	}
}
class DivFactory implements IFactory{

	@Override
	public Operation createOperation() {
		return new Div();
	}
}


public class FactoryMethod {
	public static void main(String[] args) {
		IFactory iFactory = new AddFactory();
		Operation op = iFactory.createOperation();
		op.numberA = 1;
		op.numberB = 2;
		System.out.println(op.getResult());
	}

}
