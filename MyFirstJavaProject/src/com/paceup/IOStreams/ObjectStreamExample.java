package com.paceup.IOStreams;

import java.io.*;

/**
 * ObjectStreamExample:
 * --------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **ObjectOutputStream**:
 *    - Can write both primitive data types (int, double, etc.) and objects.
 *    - Objects must implement Serializable to be written.
 * 
 * 2. **ObjectInputStream**:
 *    - Reads back data written by ObjectOutputStream.
 *    - Must read in the same order they were written.
 * 
 * 3. **Serialization vs Primitive Writing**:
 *    - `writeInt()` → writes primitive int directly.
 *    - `writeObject()` → writes an object (like String, or custom Serializable class).
 * 
 * 4. **Try-with-resources**:
 *    - Recommended for automatic closing of streams.
 *    - Prevents resource leaks.
 * 
 * In this example:
 * - Writes an integer and a String object into "file2.txt".
 * - Reads them back using `readInt()` and `readObject()`.
 * - Prints the values to the console.
 */
class ObjectStreamExample {
    public static void main(String[] args) {

        int data1 = 5;
        String data2 = "This is Java Program";

        try {
            // Step 1: Serialize data (write to file)
            FileOutputStream file = new FileOutputStream("file2.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);

            output.writeInt(data1);     // writes primitive int
            output.writeObject(data2);  // writes String object

            // Step 2: Deserialize data (read from file)
            FileInputStream fileStream = new FileInputStream("file2.txt");
            ObjectInputStream objStream = new ObjectInputStream(fileStream);

            // Read values in the same order they were written
            System.out.println("Integer data: " + objStream.readInt());
            System.out.println("String data: " + objStream.readObject());

            // Step 3: Close streams
            output.close();
            objStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
