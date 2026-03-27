package com.paceup.Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Emp implements Serializable{
	private static final long serialVersionUID = 129348983L;
	transient int a;
	static int b;
	String name;
	int age;
	
	public Emp(String name, int age, int a, int b) {
		this.name =  name;
		this.age = age;
		this.a = a;
		this.b = b;
	}
}
public class SerialVersionUIDExample {

	public static void printData(Emp e) {
		System.out.println("Name: "+e.name);
		System.out.println("age: "+e.age);
		System.out.println("A: "+e.a+" B: "+e.b);
	}
	public static void main(String[] args) {
		Emp obj = new Emp("abc",20,1,2000);
		String filename = "EData.txt";
		
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream out =  new ObjectOutputStream(fos);
			out.writeObject(obj);
			out.close();
			fos.close();
			System.out.println("Object serialized");
			printData(obj);
			
			obj.b = 200;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		obj = null;
		
		try {
			FileInputStream fis =  new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fis);
			obj = (Emp) in.readObject();
			in.close();
			fis.close();
			System.out.println("Object Deserialized!!!");
			
			printData(obj);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
