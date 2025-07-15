package com.paceup.day6;


//Java program to illustrate the
//concept of Hierarchical  inheritance

class A {
	public void print_A() { System.out.println("Class A method called "); }
}

class B extends A {
	public void print_B() { System.out.println("Class B method called"); }
}

class C extends A {
	public void print_C() { System.out.println("Class C method called"); }
}

class D extends A {
	public void print_D() { System.out.println("Class D method called"); }
}

class E extends B{
	public void print_E() {
		System.out.println("Class E method called");
	}
}

//Driver Class
public class HierarchicalInheritance {
	public static void main(String[] args)
	{
		B obj_B = new B();
		obj_B.print_A();
		obj_B.print_B();

		System.out.println("\n");
		C obj_C = new C();
		obj_C.print_A();
		obj_C.print_C();

		System.out.println("\n");
		D obj_D = new D();
		obj_D.print_A();
		obj_D.print_D();
	}
}
