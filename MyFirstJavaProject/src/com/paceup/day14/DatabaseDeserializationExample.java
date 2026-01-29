package com.paceup.day14;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseDeserializationExample {
    public static void main(String[] args) {
        try {
            // Retrieve byte array from database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT data FROM PERSON LIMIT 2");

            if (rs.next()) {
                byte[] personBytes = rs.getBytes("data");

                // Convert byte array back to object
                ByteArrayInputStream bis = new ByteArrayInputStream(personBytes); // byte array -> byte stream
                ObjectInputStream in = new ObjectInputStream(bis); 
                Person person = (Person) in.readObject();  //bytestream -> Object

                System.out.println("Object deserialized from database:");
                System.out.println("Name: " + person.name + ", Age: " + person.age + ", Address: " + person.address + " Phone No: "+person.phoneNo);

                in.close();
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
