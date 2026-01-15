package com.paceup.day7;
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
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
        
        Dog dg = (Dog) myAnimal; //Downcasting
        dg.sound();
        
        Animal an = new Animal();
        an.sound();
    }
}
