package com.paceup.day14;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for version control
    String name;
    int age;
    transient String address; // except this all fields are serialized 

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        Person person = new Person("John", 30, "Canada");

        try (FileOutputStream fileOut = new FileOutputStream("person.ser"); //.ser is binary file that will store this serialized Java object
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
            System.out.println("Object serialized successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

