package com.paceup.day7;
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
    void age (int a) {
    	System.out.println("Age: "+a);
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
        super.sound();
    }
    int age() {
    	return 10;
    }
   
}

public class RunTimePolymorphism {
    public static void main(String[] args) {
        Animal myAnimal = new Dog(); // Upcasting
        myAnimal.sound();           // Calls Dog's sound method
        
        float f = 10543.3432487f;
        int num = (int) f; //TypeCasting
        System.out.println(num);
        
        
        /*
         * Dog d =  (Dog) new Animal(); //ERROR
         * d.sound();
        */
        
        Dog dg = (Dog) myAnimal; //Downcasting //Dog-> Animal -> Dog
        dg.sound();
        System.out.println("Age of dog is "+dg.age());
        
        Animal an = new Animal();
        an.sound();
        an.age(5);
    }
}
