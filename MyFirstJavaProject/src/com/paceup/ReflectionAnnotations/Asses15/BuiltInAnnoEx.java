//5. Demonstrate use of built-in annotations like @Override, @Deprecated, and @SuppressWarnings.
package com.paceup.ReflectionAnnotations.Asses15;

import java.util.ArrayList;
import java.util.List;

class Parent {
	public void showMsg() {
		System.out.println("Parent class showMsg method.");
	}
}

public class BuiltInAnnoEx extends Parent {

	@Override
	public void showMsg() {
		System.out.println("Child class showMsg Method.");
	}

	@Deprecated
	public void obsolete() {
		System.out.println("This method is deprecated. Use another method.");
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public void warning() {
		obsolete();

		List list = new ArrayList();
		list.add("No conversion here");

		System.out.println("Warnings Supreeseed Succussfully.");
	}

	public static void main(String[] args) {
		BuiltInAnnoEx bi = new BuiltInAnnoEx();
		bi.showMsg();
		bi.warning();

	}

}
