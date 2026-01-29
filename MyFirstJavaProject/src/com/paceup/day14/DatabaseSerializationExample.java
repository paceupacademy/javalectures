package com.paceup.day14;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseSerializationExample {
    public static void main(String[] args) {
        Person person = new Person("Bob", 40, "USA");

        try {
            // Convert object to byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(person);
            byte[] personBytes = bos.toByteArray();

            // Store in database (assuming PERSON table with BLOB column 'data')
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO PERSON (data) VALUES (?)");
            ps.setBytes(1, personBytes);
            ps.executeUpdate();

            System.out.println("Object serialized and stored in database!");

            out.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
