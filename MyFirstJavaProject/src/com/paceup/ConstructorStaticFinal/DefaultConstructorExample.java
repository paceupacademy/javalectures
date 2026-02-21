package com.paceup.ConstructorStaticFinal;

class DefaultConstructor {
	int num;
	public DefaultConstructor() {
		num=7;
		System.out.println("Default Constructor called!");
		System.out.println("Object Created");
		display();
	}	
	void display() {
		System.out.println("Hello");
	}
	
}
public class DefaultConstructorExample{
    public static void main(String[] args) {
        DefaultConstructor obj = new DefaultConstructor(); // Calls the default constructor
        System.out.println("The value: "+obj.num);
        obj.display();
    }
}