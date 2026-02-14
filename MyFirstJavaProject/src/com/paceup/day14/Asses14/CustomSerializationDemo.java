package com.paceup.day14.Asses14;

import java.io.*;

class EmployeeCustom implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    transient int salary;   

    public EmployeeCustom(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    // Custom writeObject
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();   // serialize non-transient fields
        oos.writeInt(salary);       // manually serialize salary(Salary is transient still we can manually serialized)
    }

    // Custom readObject
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();    // deserialize non-transient fields
        salary = ois.readInt();    // manually restore salary
    }
}

public class CustomSerializationDemo {

    public static void main(String[] args) throws Exception {

    	EmployeeCustom emp = new EmployeeCustom("Priya", 50000);

        // Serialization
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("emp.ser"))) {

            oos.writeObject(emp);
            System.out.println("Serialization completed.");
        }

        // Deserialization
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("emp.ser"))) {

        	EmployeeCustom e = (EmployeeCustom) ois.readObject();

            System.out.println("Deserialization completed.");
            System.out.println("Name: " + e.name);
            System.out.println("Salary: " + e.salary);
        }
    }
}

