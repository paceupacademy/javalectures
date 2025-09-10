package com.paceup.day20;
import java.util.Random;
import java.util.function.Supplier;
public class SupplierExample {

	public static void main(String[] args) {
		//supplier will return a fixed string
		Supplier<String> supplier = () -> "Hello Aishwarya!!";
		
		System.out.println(supplier.get());
		
		Supplier<Integer> randomSupplier = ()-> new Random().nextInt(100); //0-99
		
		System.out.println("Random Number: "+randomSupplier.get());
		 //Supplier<Employee> emp = ()-> new Employee("Raj",50000);
		//Employee e = emp.get();
		//System.out.println("Name: "+emp.name+" Salary: "+emp.salary);
	}

}
