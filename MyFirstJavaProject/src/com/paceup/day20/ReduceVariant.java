package com.paceup.day20;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Employee2{
	String name;
	int salary;
	
	Employee2(String name, int salary){
		this.name =  name;
		this.salary =  salary;
	}
}

public class ReduceVariant {

	public static void main(String[] args) {
		//T reduce(T identiy, BinaryOperator<T> accumulator
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
		int sum = nums.stream()
						.reduce(0, (a,b)->a+b); //0->identity(initial value) => ((((0+1)+2)+3)+4)+5+6
		System.out.println("Sum of Elements: "+sum);

		//Optional<T> reduce(BinaryOperator<T> accumulator
		Optional<Integer> max = nums.stream()
									.reduce((a,b)->a>b?a:b); //1 vs 2 -> 2, 2 vs 3 -> 3, 
		
		System.out.println("Maximum value using reduce(): "+max.get());
		
		//<U> U reduce(U identity, BiFunction<U, ? super T,U>, accumulator, BinaryOperator<U> combiner)
		
		List<Employee2> emp = Arrays.asList(
				new Employee2("Akash",473948),
				new Employee2("Ajay",3874983),
				new Employee2("Rahul",49837));
		
		long totalSalary = emp.stream()
							.reduce(0L,
									(acc,e)->acc+e.salary,
									Long::sum);
		System.out.println("Total Salary: "+totalSalary);
	}

}
