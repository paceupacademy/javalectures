//3. Write a method that takes an integer and tries to change its value inside the method. Print original value.
package com.paceup.AbstractionAndInterfaces.Asses8_and_Asses9;

public class IntegerCallByValue {

	public static void Modifyvalue(int value) {
		value = 20;
		System.out.println("After modification value: " + value);
	}

	public static void main(String[] args) {
		int x = 10;
		Modifyvalue(x);
		System.out.println("Original value: " + x);

	}

}
