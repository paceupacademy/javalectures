//4.  Implement a JavaBean class with encapsulated fields.
package com.paceup.Encapsulation.Asses5;

public class JavaBeans implements java.io.Serializable{
	private int a;
	private String name;
	
	public JavaBeans() {}

	public int getA() {
		return this.a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String args[]) {
		JavaBeans obj = new JavaBeans();
		obj.setA(100);
		obj.setName("ABC");
		System.out.println("Id:"+obj.getA());
		System.out.println("Name:"+obj.getName());
	}
}
