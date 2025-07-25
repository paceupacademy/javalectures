package com.paceup.day13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class ObjectStreamExample {
    public static void main(String[] args) {

        int data1 = 5;
        String data2 = "This is Java Program";

        try {
            FileOutputStream file = new FileOutputStream("file2.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);

            // Writing to the file using ObjectOutputStream
            output.writeInt(data1); //writes primitive datatype
            output.writeObject(data2); //writes  StringObject

            FileInputStream fileStream = new FileInputStream("file2.txt");
            // Creating an object input stream
            ObjectInputStream objStream = new ObjectInputStream(fileStream);

            //Using the readInt() method
            System.out.println("Integer data :" + objStream.readInt());

            // Using the readObject() method
            System.out.println("String data: " + objStream.readObject());

            output.close();
            objStream.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}
