package com.paceup.day20;

import java.util.stream.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.*;

class PersonData{
	String name;
	int age;
	boolean isMale;
	
	PersonData(String name, int age, boolean isMale){
		this.name = name;
		this.age = age;
		this.isMale = isMale;
	}
	
	@Override
	public String toString() {
		return name + " ( " +age+ ", " +(isMale ? " Male " : "Female" ) + ")";
	}
}

public class GroupingExample {
			
	public static void main(String[] args) {
		List<PersonData> people = Arrays.asList(
				new PersonData("Om", 5, true),
				new PersonData("Disha", 64, false),
				new PersonData("Dev", 25, true),
				new PersonData("Omi", 65, true),
				new PersonData("Dishant", 64, true),
				new PersonData("Devi", 67, false)
				);
		
		List<String> names = people.stream()
								.map(p -> p.name)
								.collect(Collectors.toList());
		
		System.out.println("\n Names List: "+names);
		
		Map<String,Integer> nameAgeMap = people.stream()
											.collect(Collectors.toMap(p->p.name, p->p.age));
		
		System.out.println("\n Name-Age map: "+nameAgeMap.toString());
		
		//groupingBy
		Map<Integer, List<PersonData>> groupByAge = people.stream().collect(Collectors.groupingBy(p->p.age));
		
		System.out.println("Grouped By Age:" +groupByAge);
		
		Map<Boolean, List<PersonData>> partitionByGender = people.stream().collect(Collectors.partitioningBy(p->p.isMale));
		
		System.out.println("\nPartitioned By Gender: "+partitionByGender);
		
		String joinedNames = people.stream()
								.map(p->p.name)
								.collect(Collectors.joining(", "));
		System.out.println("\nJoined Names: "+joinedNames);
		
		long count = people.stream()
						.collect(Collectors.counting());
		
		System.out.println("\n Total People: "+count);
		
		IntSummaryStatistics stats = people.stream().collect(Collectors.summarizingInt(p->p.age));
		
		System.out.println("\nAge Summary");
		System.out.println("\n Count " + stats.getCount());
		System.out.println("\n Average "+stats.getAverage());
		System.out.println("\n Minimum Age "+stats.getMin());

	}

}
