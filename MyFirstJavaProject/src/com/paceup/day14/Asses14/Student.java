//1. Serialize a simple Student object to a file and deserialize it back.
//4. Modify a serialized class by adding a field and observe deserialization behavior. - Added 'std' field

package com.paceup.day14.Asses14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialversionUID = 2L;
	String Name = "Vaishnavi";
	int Roll_no = 34;
	transient double Marks = 89.60;
	String std = "2D";
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println("Serialization started..");
		try (FileOutputStream f = new FileOutputStream("Student.ser");
				ObjectOutputStream o = new ObjectOutputStream(f)) {
			o.writeObject(s);
			System.out.println("Serialization endned..");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Deserialization started..");
		try (FileInputStream fi = new FileInputStream("Student.ser");
				ObjectInputStream oi = new ObjectInputStream(fi)) {
			Student s1 = (Student) oi.readObject();
			System.out.println("Student Details are-");
			System.out.println("Name: " + s1.Name + ",\nRoll_no: " + s1.Roll_no + ",\nMarks: " + s1.Marks + "\nClass: "+s1.std);
			System.out.println("Deserialization endned..");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}