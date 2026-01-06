//2. Implement a multilevel inheritance structure (Animal > Mammal > Dog).

package com.paceup.day6.Asses6;

class Animal {
	public void animal() {
		System.out.println("Animal class...");
	}
}

class Mammal extends Animal {
	public void mammal() {
		System.out.println("Mammal class....");
	}
}

class Dog extends Mammal {
	public void dog() {
		System.out.println("Dog class....");
	}
}

public class Multilevel_Inheritance {

	public static void main(String[] args) {
		 Animal a = new Animal();
		 Mammal m = new Mammal();
		 Dog d = new Dog();
		 
		 System.out.println("Accessing through Animal Object.");
		 a.animal();
		 
		 System.out.println("\n");
		 
		 System.out.println("Accessing through Mammal Object.");
		 m.animal();
		 m.mammal();
		 
		 System.out.println("\n");
		 
		 System.out.println("Accessing through Dog Object.");
		 d.animal();
		 d.mammal();
		 d.dog();

	}

}
