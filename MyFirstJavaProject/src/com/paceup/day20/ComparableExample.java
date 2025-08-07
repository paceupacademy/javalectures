package com.paceup.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//Comparable used for ordering
class StudentData implements Comparable<StudentData> {
	int id;
	String name;
	int age;

	public StudentData(int id, String name, int age) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.age = age;
	}

	//Ordering
	@Override
	public int compareTo(StudentData o) {
		// TODO Auto-generated method stub
		return this.age - o.age; //does the comparison between two students ascending 
	}

	@Override
	public String toString() {
		return name + "(ID: "+id+ ", Age: "+age+")\n";
	}
}

class NameComparator implements Comparator<StudentData>{

	@Override
	public int compare(StudentData o1, StudentData o2) {
		// TODO Auto-generated method stub
		return o1.name.compareToIgnoreCase(o2.name); //alphabetically
	}
	
}

class IntermediateExample {
	public void flatMapdemo() {
		List<List<String>> namesList = Arrays.asList(
				Arrays.asList("Aishwarya","Jay"),
				Arrays.asList("Paul","Dev")
				);
		namesList.stream()
			.map(list -> list.stream())
			.forEach(System.out::println);
		
		namesList.stream()
			.flatMap(list -> list.stream())
			.skip(2)
			.forEach(System.out::println);
	}
}

class TerminalExample{
	public void collectorDemo() {
		Set<String> name = Stream.of("Aishwarya", "Paul", "Dev", "Jay")
								.collect(Collectors.toSet());
		System.out.println(" Through Collectors Names:"+name.toString());
	}
}




public class ComparableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<StudentData> students = new ArrayList<>();
		students.add(new StudentData(1, "Aishwarya", 28));
		students.add(new StudentData(2, "Dev", 25));
		students.add(new StudentData(3, "Paul", 22));
		students.add(new StudentData(4, "Jay", 29));
		students.add(new StudentData(5, "Ashwini", 30));

		students.stream().map(s -> s.name.length()).forEach(System.out::println);
		
		//Sort using Comparable by age
		Collections.sort(students);

		System.out.println("Sorted student data on age using Comparable:");
		for (StudentData sd : students) {
			System.out.println(sd);
		}
		
		//Sort using Comparator by name
		Collections.sort(students, new NameComparator());
		System.out.println("\n Sorted student data on name using Comparator");
		students.forEach(System.out::println);
		
		IntermediateExample ie = new IntermediateExample();
		ie.flatMapdemo();
		
		TerminalExample te = new TerminalExample();
		te.collectorDemo();
	}
}
