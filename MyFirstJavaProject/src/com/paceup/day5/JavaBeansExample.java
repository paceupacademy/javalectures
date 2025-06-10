package com.paceup.day5;

public class JavaBeansExample implements java.io.Serializable{
	private int id;
	private String name;
	
	public JavaBeansExample() {}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String args[]) {
		JavaBeansExample j = new JavaBeansExample();
		j.setId(9);
		j.setName("Daisy");
		System.out.println("Id:"+j.getId());
		System.out.println("Name:"+j.getName());
	}
}
