package com.paceup.day14;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClientExample {
    public static void main(String[] args) {
        try {
            // Connect to server
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server!");

            // Create object to send
            Person person = new Person("Alice", 25, "India");

            // Serialize and send object
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(person);
            System.out.println("Object sent to server!");

            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
