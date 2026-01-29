package com.paceup.day14;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Person class implements Serializable so that its objects can be converted
 * into a byte stream and stored/transferred.
 */
class Person implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility during deserialization

    String name;
    int age;
    transient String address; 
    // 'transient' means this field will NOT be serialized.
    // Useful when you want to skip sensitive or non-essential data.
    static String phoneNo;
    
    /*
     * final -> must be assigned once
     * transient -> ignored during deserialization
     * During deserialization constructor isn't called so value may become null/default 
     * JVM restores field from bytestream
     * But phoneNo was never serialized
     * So, JVM assigns default value  -> null
     * Allowed but dangerous if you expect value after deserialization
     */
    //final transient String phoneNo; 
    
    //is not serialized during serialization
    public Person(String name, int age, String address, String phoneNo) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNo = phoneNo;
    }
}

/**
 * Demonstrates Serialization: converting a Java object into a byte stream
 * and saving it into a file.
 */
public class SerializationExample {
    public static void main(String[] args) {
        // Step 1: Create an object of Person
        Person person = new Person("John", 30, "Canada","9876543210");
        Person p = new Person("Ana", 10, "UK", "98409384098");
        // Step 2: Serialize the object into a file named "person.ser"
        try (FileOutputStream fileOut = new FileOutputStream("person.ser"); // File to store serialized object
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {    // Stream to write object
             
            out.writeObject(person); // Convert object into byte stream and write to file
            System.out.println("Object serialized successfully! Stored in person.ser");
            
            System.out.println(" "+p.phoneNo);

        } catch (IOException e) {
            // Handle any I/O exceptions (e.g., file not found, permission issues)
            e.printStackTrace();
        }
    }
}
