//Create a final method and explain its use.
package com.paceup.day4.Asses4;

public class FinalMethod {
	//Final method
	final void finalM() {
		System.out.println("This is Final Method!!");
	}

	public static void main(String[] args) {
		FinalMethod fm = new FinalMethod();
		fm.finalM(); //called final using object
	}

}

/*
Use of Final method:
	Its prevent the method overriding.
	final method can be inherited.
	
*/