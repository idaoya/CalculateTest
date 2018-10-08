package com;

public class Calculate {

	@FunctionalInterface
	interface MathOperation {
		int operation(int number1, int number2);
	}

	public int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	public int addition(int count) {
		MathOperation additionOp = (number1, number2) -> number1 + number2;
		int i = operate(10, count, additionOp);
		return i;
	}

	public int subtraction(int count) {
		MathOperation subtractionOp = (number1, number2) -> number1 - number2;
		int i = operate(10, count, subtractionOp);
		return i;
	}

	public int multiplication(int count) {
		MathOperation multiplicationOp = (number1, number2) -> number1 * number2;
		int i = operate(10, count, multiplicationOp);
		return i;
	}

	public int division(int count) {
		MathOperation divisionOp = (number1, number2) -> number1 / number2;
		int i = operate(10, count, divisionOp);
		return i;
	}
}