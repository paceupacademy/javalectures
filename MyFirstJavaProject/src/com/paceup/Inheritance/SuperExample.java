package com.paceup.Inheritance;

//Method overriding + Calling Parent class constructor using super()
class Parent {
	Parent(){
		System.out.println("Inside SuperClass/Parent Class Constructor");
		display();
	}
	void display() {
        System.out.println("This is Parent class method");
    }
}

class Child extends Parent {
	Child(){
		super(); //explicit call to Parent class constructor
	}
	@Override
    void display() {
        super.display(); // Calls Parent's display method
        System.out.println("This is Child Class method");
    }
}

public class SuperExample{
	public static void main(String[] args) {
		Child ch = new Child();
		ch.display();
	}
}