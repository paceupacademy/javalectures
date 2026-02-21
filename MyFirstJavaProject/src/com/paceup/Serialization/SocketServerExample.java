package com.paceup.Serialization;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExample {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) { 
            System.out.println("Server is waiting for client connection...");

            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Receive object from client
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Person person = (Person) in.readObject();

            System.out.println("Object received from client:");
            System.out.println("Name: " + person.name + ", Age: " + person.age + ", Address: " + person.address + " Phone No: "+ person.phoneNo);

            in.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
