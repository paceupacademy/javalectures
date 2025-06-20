package com.paceup.day14;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationExample {
    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Person person = (Person) in.readObject();
            System.out.println("Object deserialized successfully!");
            System.out.println("Name: " + person.name + ", Age: " + person.age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

