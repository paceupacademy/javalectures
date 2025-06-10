package com.paceup.day6;

class Parent {
	Parent(){
		System.out.println("Inside SuperClass Constructor");
	}
	void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
	Child(){
		super();
	}
    void display() {
        super.display(); // Calls Parent's display method
        System.out.println("Child method");
    }
}

public class SuperExample{
	public static void main(String[] args) {
		Child ch = new Child();
		ch.display();
	}
}