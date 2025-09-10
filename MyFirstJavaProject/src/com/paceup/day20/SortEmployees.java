package com.paceup.day20;
import java.util.*;

class Employee {
	String name;
	int age;
	
	Employee(String name,int age){
		this.name =  name;
		this.age =  age;
	}
	
	@Override
	public String toString() {
		return name+" : " +age;
	}
}

public class SortEmployees {

	public static void main(String[] args) {
		List<Employee> emp =  new ArrayList<>();
		emp.add(new Employee("Aish", 28));
		emp.add(new Employee("Rahul", 24));
		emp.add(new Employee("Neha", 22));
		
		emp.sort((e1,e2) -> Integer.compare(e1.age, e2.age));
		
		emp.forEach(System.out::println);
	}

}
