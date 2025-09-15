package com.paceup.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOpsExample {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>(Arrays.asList(55,10,35,15,20,25,15,30));
		
		nums.add(45);
		List<Integer> result = nums.stream()
									.filter(x-> x>12)
									.collect(Collectors.toList());
		
		System.out.println("Original List: "+nums);
		System.out.println("Filtered List:"+result);
		
		List<Integer> dby5 = nums.stream()
								.map(x->x/5)
								.collect(Collectors.toList());
		
		System.out.println("Divide by 5 result: "+dby5);
		
		List<Integer> distinctList =  nums.stream().distinct().collect(Collectors.toList());
		
		System.out.println("Unique Elements: "+distinctList);
		
		List<Integer> sortedList = nums.stream()
										.sorted((a,b)->b.compareTo(a))
										.collect(Collectors.toList());
		
		System.out.println("Sorted List: "+sortedList);
		
		List<Integer> limitList = nums.stream()
									.limit(4)
									.collect(Collectors.toList());
		System.out.println("Limit List to 4 has: "+limitList);
		
		List<Integer> skipList =  nums.stream()
										.skip(3)
										.collect(Collectors.toList());
		System.out.println("Skipped first 3 elements: "+skipList);
		
		List<List<String>> listofLists = Arrays.asList(Arrays.asList("Java","Spring"), Arrays.asList("Docker","Kubernetes"));
		
		List<String> flatMapResult =  listofLists.stream()
												.flatMap(list->list.stream())
												.collect(Collectors.toList());
		
		System.out.println("Converted nested list: "+flatMapResult);
		
		List<String> peekList = flatMapResult.stream()
											.peek(n-> System.out.println("Learning:  "+n))
											.map(String::toUpperCase) //Instance Method
											.collect(Collectors.toList()); //collect Terminal Operation
		
		System.out.println("Peeked List: "+peekList);
		
		/********************************/
		/****Terminal Operations ********/
		/********************************/
		
		flatMapResult.stream().forEach(System.out::println);
		
		int sum =  nums.stream().reduce(0, Integer::sum);
		System.out.println("Sum of addition of all elements is: "+sum);
		
		long cnt =  nums.stream().count();
		System.out.println("Total number of elements is: "+cnt);
		
		int minVal =  nums.stream().min(Integer::compare).get();
		int maxVal =  nums.stream().max(Integer::compare).get();
		
		System.out.println("Minimum value from nums list is"+minVal+ ". Maximum value from nums List is "+maxVal);
		
		boolean any = nums.stream().anyMatch(x->x>25);
		boolean all = nums.stream().allMatch(x-> x>5);
		boolean none =  nums.stream().noneMatch(x-> x<0);
		System.out.println("Values more than 25? "+any+"\nValues greater than 5? "+all+"\nNo values less than 0? "+none);
		
		String first = flatMapResult.stream().findFirst().get();
		
		String findAny = flatMapResult.parallelStream().findAny().get();
		
		System.out.println("First element: "+first+ " Any Element: "+findAny);
	}
}

/*
 * Stream -> [1,2,3,4,5,6,7] -> Processed one-by-one -> Final Result
 * 
 * ParallelStream -> [1,2,3,4,5,6,7,8] -> [1,2] [3,4] [5,6] [7,8] (Splitting into chunks)
 * 
 * Chunk -> processed using one thread 
 * 
 * MutliThreading Completed -> FinalResult
*/