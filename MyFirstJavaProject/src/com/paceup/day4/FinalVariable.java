package com.paceup.day4;

import com.paceup.day5.AccessSpecifiers;

public class FinalVariable {
	public int var= 100;
	private int pvar = 50;
	
	final void sum(int a, int b) {
		int result = a+b;
		System.out.println("Addition result:"+result);
	}
	
	public static void main(String[] args) {

		// Define a constant variable PI
		final double PI = 3.14159;
		FinalVariable fv = new FinalVariable();
		fv.pvar = 60;
		fv.sum(7, 19);
		// Print the value of PI
		System.out.println("Value of PI: " + PI + "\n PVAR changed value is : "+fv.pvar);
		AccessSpecifiers as = new AccessSpecifiers(fv.pvar);
	}
}