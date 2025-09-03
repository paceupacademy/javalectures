package com.paceup.day14;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        
        /* Serialization over network
        try {
			Socket socket = new Socket ("localhost",5000);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ServerSocket socket1 = new ServerSocket(5000);
			Socket socket2 = socket1.accept();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
        
        /*Serialization over database
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
			ObjectOutputStream outb = new ObjectOutputStream(bos);
			outb.writeObject(person);
			byte[] personBytes = bos.toByteArray();
			
			Connection conn = DriverManager.getConnection("localhost:3306","root","root");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO PERSON (data) VALUES (?)");
			ps.setBytes(1, personBytes);
			ps.executeUpdate();
			outb.close();
			conn.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        */
        
        
        try (FileOutputStream fileOut = new FileOutputStream("person.ser"); //.ser is binary file that will store this serialized Java object
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
            System.out.println("Object serialized successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

