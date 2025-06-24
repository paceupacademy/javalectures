package com.paceup.day14;

import java.io.FileInputStream; // read raw byte from file
import java.io.ObjectInputStream; //read Java objects from the input stream

public class DeserializationExample {
    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream("person.ser"); // opens file start reading it
             ObjectInputStream in = new ObjectInputStream(fileIn)) { // //start deserialization of objects
            Person person = (Person) in.readObject(); // reads object from filestream
            System.out.println("Object deserialized successfully!");
            System.out.println("Name: " + person.name + ", Age: " + person.age +" , Address: " + person.address);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

