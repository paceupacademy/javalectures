package com.paceup.AbstractionAndInterfaces;
/*
 * abstract class ClassName{
 * 		abstract void methodNAme();
 * 		void concreteMethodName(){
 * 			System.out.println("Concrete Method Called!");
 * 		}
 * }
 */
//Abstract class cannot be instantiated may contain abstract method(w/o body) as well as concrete method(implementation)
abstract class Animal {
	Animal(){
		System.out.println("Animal Constructor called!");
	}
	
	Animal(String name){
		System.out.println("Animal Name "+name);
	}
	// Abstract method (no body)
	abstract void sound();

	// Concrete method
	void sleep() {
		System.out.println("Sleeping...");
	}
	
	abstract class InnerClass{
		abstract void myAbstractMethod();
	}
}

//Subclass (inherits from Animal)
class Dog extends Animal {
	Dog(){
		super();
		System.out.println("Dog Constructor Called!!");
	}
	Dog(String name){
		super(name);
		System.out.println("Dog Name "+name);
	}
	public void printName() {
		System.out.println("Name is Champ!!");
	}
	// Providing implementation for the abstract method
	@Override
	void sound() {
		System.out.println("Woof Woof!");
	}
	
	class InnerClassDog extends InnerClass{

		@Override
		void myAbstractMethod() {
			System.out.println("Inside Abstratc Method Implementation of Inner Abstract Class");
		}
		
	}
}

class DemoClass extends Animal.InnerClass{

	DemoClass(Animal animal) {
		animal.super();
	}
	@Override
	void myAbstractMethod() {
		// TODO Auto-generated method stub
		System.out.println("Abstratc method called of inner abstract class");
	}
	
}

public class AbstractionExample {
	public static void main(String[] args) {
		// Cannot instantiate an abstract class
		//Animal animal = new Animal(); // This will cause an error

		// Using a subclass
		Animal myDog = new Dog(); //upcasting
		myDog.sound(); // Calls the overridden method
		myDog.sleep(); // Calls the concrete method
		
		Animal newDog = new Dog("Tom");
		newDog.sleep();
		newDog.sound();
		
		Dog dg= new Dog();
		dg.printName(); // Cannot be accessed by Animal class object myDog as this is not created inside Animal Class
		
		Dog.InnerClassDog inc =dg.new InnerClassDog();
		inc.myAbstractMethod();
		
		DemoClass dc = new DemoClass(myDog);
		dc.myAbstractMethod();
		
		Animal.InnerClass inc1 = new DemoClass(newDog);
		inc1.myAbstractMethod();
	}
}

/*
* new Dog() -> Dog Constructor -> super() -> Animal Constructor -> Dog Constructor
*/