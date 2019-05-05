package com.sparrow.zg.simpleFactory;

/**
 * 简单工厂方法:
 * 设计一个计算器
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

class OperationFactory {
	public static Operation createOpertion(String operator){
		Operation operation = null;
		switch (operator){
			case "+":operation = new Add();break;
			case "-":operation = new Sub();break;
			case "*":operation = new Mul();break;
			case "/":operation = new Div();break;
			default:
				throw new RuntimeException("输入非法的运算符");
		}
		return operation;
	}
}

public class SimpleFactory {

	public static void main(String[] args) {
		Operation op = OperationFactory.createOpertion("+");
		op.numberA = 123;
		op.numberB = 321;
		System.out.println(op.getResult());
	}
}
