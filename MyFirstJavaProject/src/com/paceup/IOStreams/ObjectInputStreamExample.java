package com.paceup.IOStreams;

import java.io.*;

// Dog class must implement Serializable to allow object serialization
class Dog implements Serializable {
    String name;
    String breed;

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    // Optional: override toString() for cleaner object printing
    @Override
    public String toString() {
        return "Dog{name='" + name + "', breed='" + breed + "'}";
    }
}

/**
 * ObjectInputStreamExample:
 * -------------------------
 * This program demonstrates **object serialization and deserialization** in Java.
 * 
 * Key Concepts:
 * -------------
 * 1. **Serialization**:
 *    - Process of converting an object into a byte stream.
 *    - Allows saving objects to files or sending them over networks.
 *    - Requires the class to implement `Serializable`.
 * 
 * 2. **Deserialization**:
 *    - Process of converting a byte stream back into an object.
 *    - Must be read in the same order it was written.
 * 
 * 3. **Streams Used**:
 *    - ObjectOutputStream → writes objects to a file.
 *    - ObjectInputStream → reads objects from a file.
 * 
 * In this example:
 * - A `Dog` object is serialized into "file.txt".
 * - The object is then deserialized back into memory.
 * - Its properties are printed to the console.
 */
public class ObjectInputStreamExample {
    public static void main(String[] args) {
        // Create a Dog object
        Dog dog = new Dog("Tyson", "Labrador");

        try {
            // Step 1: Serialize the object
            FileOutputStream file = new FileOutputStream("file.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(dog); // write Dog object
            output.close();

            // Step 2: Deserialize the object
            FileInputStream fileStream = new FileInputStream("file.txt");
            ObjectInputStream input = new ObjectInputStream(fileStream);
            Dog newDog = (Dog) input.readObject(); // typecasting required
            input.close();

            // Step 3: Print deserialized object details
            System.out.println("Dog Object: " + newDog);
            System.out.println("Dog Name: " + newDog.name);
            System.out.println("Dog Breed: " + newDog.breed);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
