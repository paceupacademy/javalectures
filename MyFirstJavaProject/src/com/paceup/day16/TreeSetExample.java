package com.paceup.day16;

import java.util.TreeSet;

class Employee implements Comparable<Employee> {

	int id;
	String name;
	
	Employee (int id, String name){
		this.id=id;
		this.name=name;
	}
	
	@Override
	public int compareTo(Employee e) {
		
		return Integer.compare(this.id,e.id);
	}
	
	@Override
	public String toString() {
		return "Employee [ID: " +id+" NAME: "+name+" ]";
	}
	
}

public class TreeSetExample {
    public static void main(String[] args) {
        // Create a TreeSet
        TreeSet<Integer> numbers = new TreeSet<>();

        // Add elements
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        numbers.add(15);
        numbers.add(25);
        numbers.add(30);
        numbers.add(1);
        numbers.add(21);

        // Display elements (sorted order)
        System.out.println("TreeSet: " + numbers);

        // Access specific elements
        System.out.println("First Element: " + numbers.first());
        System.out.println("Last Element: " + numbers.last());

        // NavigableSet methods Provides methods to navigate through set
        System.out.println("Higher than 10: " + numbers.higher(10));
        System.out.println("Lower than 10: " + numbers.lower(15));

        // Remove an element
        numbers.remove(15);
        System.out.println("After Removal: " + numbers);
        
        //Sorting Employee Object using treeset
        
        TreeSet<Employee> emp = new TreeSet<>();
        emp.add(new Employee(1,"Akash"));
        emp.add(new Employee(2,"Bharat"));
        emp.add(new Employee(7,"Omkar"));
        emp.add(new Employee(5, "Kamlesh"));
        emp.add(new Employee(6,"Kumar"));
        
        System.out.println(emp.toString());
        
    }
}

