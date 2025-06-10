package com.paceup.day6;

class Parent {
	Parent(int a){
		System.out.println(a);
	}
	void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
	
	  Child(){ super(10); }
	 
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