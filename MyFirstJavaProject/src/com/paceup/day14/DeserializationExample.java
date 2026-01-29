package com.paceup.day14;

import java.io.FileInputStream;   // Reads raw bytes from file
import java.io.ObjectInputStream; // Converts byte stream back into Java object

/**
 * Demonstrates Deserialization: converting a byte stream back into a Java object.
 */
public class DeserializationExample {
    public static void main(String[] args) {
        // Step 1: Open the file containing the serialized object
        try (FileInputStream fileIn = new FileInputStream("person.ser"); // File containing serialized object
             ObjectInputStream in = new ObjectInputStream(fileIn)) {     // Stream to read object
             
            // Step 2: Read object from file and cast it back to Person
            Person person = (Person) in.readObject();

            // Step 3: Display deserialized object data
            System.out.println("Object deserialized successfully!");
            System.out.println("Name: " + person.name + 
                               ", Age: " + person.age + 
                               ", Address: " + person.address +
                               ", Phone No: " + person.phoneNo); 
            // Note: 'address' will be null because it was marked transient

        } catch (Exception e) {
            // Handle exceptions (ClassNotFoundException, IOException, etc.)
            e.printStackTrace();
        }
    }
}
