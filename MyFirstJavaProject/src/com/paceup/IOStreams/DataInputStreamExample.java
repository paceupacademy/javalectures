package com.paceup.IOStreams;

import java.io.*;

/**
 * DataInputStreamExample:
 * -----------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **DataOutputStream**:
 *    - Allows writing primitive data types (int, double, boolean, char, etc.) to an output stream.
 *    - Data is written in a machine-independent binary format.
 * 
 * 2. **DataInputStream**:
 *    - Allows reading primitive data types from an input stream.
 *    - Must be read in the same order they were written, otherwise data corruption occurs.
 * 
 * 3. **Advantages**:
 *    - Useful for persisting structured data (numbers, booleans, characters).
 *    - Ensures consistent binary representation across platforms.
 * 
 * 4. **Try-with-resources**:
 *    - Ensures streams are closed automatically.
 *    - Prevents resource leaks and makes code cleaner.
 * 
 * In this example:
 * - Writes a double, int, boolean, and char into "file.dat".
 * - Reads them back in the same order.
 * - Prints the values to the console.
 */
public class DataInputStreamExample {

    public static void main(String[] args) {
        
        // Writing the data to file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("file.dat"))) {
            System.out.println("Writing data to file");
            dos.writeDouble(23.45);   // write double
            dos.writeInt(65);         // write integer
            dos.writeBoolean(false);  // write boolean
            dos.writeChar('$');       // write character
        } catch (FileNotFoundException f) {
            System.out.println("Cannot find the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Reading the data back
        try (DataInputStream dis = new DataInputStream(new FileInputStream("file.dat"))) {
            System.out.println("Reading data from file");
            
            // Read values in the same order they were written
            double d = dis.readDouble();
            int i = dis.readInt();
            boolean b = dis.readBoolean();
            char c = dis.readChar();
            
            System.out.println("\nValues are: double = " + d + 
                               "\tinteger = " + i + 
                               "\tboolean = " + b + 
                               "\tchar = " + c);
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
