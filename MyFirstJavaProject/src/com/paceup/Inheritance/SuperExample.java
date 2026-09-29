package com.paceup.Inheritance;

//Method overriding + Calling Parent class constructor using super()
class Parent {
	int num =10;
	Parent(){
		System.out.println("Inside SuperClass/Parent Class Constructor");
		display();
	}
	static void display() {
        System.out.println("This is Parent class method");
    }
}

class Child extends Parent {
	int num=15;
	Child(){
		super(); //explicit call to Parent class constructor
		System.out.println("Parent Static Variable "+super.num +" Child variable "+this.num);
		//this();
	}
	static void display() {
       // super.display(); // Calls Parent's display method
        System.out.println("This is Child Class method");
    }
}

public class SuperExample{
	public static void main(String[] args) {
		Child ch = new Child();
		Child.display();
	}
}