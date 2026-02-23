//3. Write a reflection-based program to invoke private methods.
package com.paceup.ReflectionAnnotations.Asses15;

import java.lang.reflect.Method;

class PrivateClass {
	// private method cannot be override out the class
	private void privatemethod(String Name) {
		//String Name = null;
		System.out.println("Hello, " + Name + "! This is private method.");
	}
}

public class ReflectionInvoke {

	public static void main(String[] args) {
		try {
			PrivateClass pc = new PrivateClass(); // Object creation of class

			// Get the class of object and locate the private method
			// use getDeclaredMethod to see private method
			Method method = PrivateClass.class.getDeclaredMethod("privatemethod", String.class);

			method.setAccessible(true); // to access the private method

			method.invoke(pc, "Developer"); // invoke the method on object

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
