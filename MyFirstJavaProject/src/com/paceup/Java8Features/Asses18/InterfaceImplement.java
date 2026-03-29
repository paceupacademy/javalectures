//2. Create a functional interface and use a lambda to implement it.
package com.paceup.Java8Features.Asses18;

@FunctionalInterface
interface test {
	void hello();
}

@FunctionalInterface
interface MyInteface {
	int test(int a, int b);
}

public class InterfaceImplement {
	public static void main(String[] args) {

		test hi = () -> System.out.println("Functional Inteface implementating using Lambda.");
		hi.hello();

		MyInteface add = (a, b) -> (a + b);
		System.out.println("Addition: " + add.test(2, 5));

		MyInteface mul = (a, b) -> (a * b);
		System.out.println("Multiplication: " + mul.test(2, 5));
	}

}
