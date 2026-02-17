package com.paceup.day10;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ArraysMethodsDemo {

	public static void main(String[] args) {
		// 1. asList() - Convert array to fixed-size List
		String[] strArray = {"Java", "Python", "C++"};
		System.out.println("Length "+strArray.length);
		List<String> strList = Arrays.asList(strArray);
		System.out.println("1. asList(): " + strList.toString()+ "  Length:"+strList.size());
		
		boolean isFlag = isFixedSize(strList);
		System.out.println(isFlag);

		// 2. binarySearch()
		int[] numArray = {1, 3, 5, 7, 9};
		int index = Arrays.binarySearch(numArray, 9);
		System.out.println("2. binarySearch(): Index of 9 is " + index);

		// 3. binarySearch with range and comparator
		String[] names = {"Anu", "Anish", "Chetan", "Divya", "Zara","Rahul"};
		//Arrays.sort(names);
		Comparator<String> comparator = String::compareTo;
		int idx = Arrays.binarySearch(names, 0, names.length, "Rahul", comparator);
		System.out.println("3. binarySearch with comparator: Index of 'Rahul' is " + idx);

		// 4. compare()
		int[] a = {1, 2, 3};
		int[] b = {1, 4, 5};
		System.out.println("4. compare(): " + Arrays.compare(a, b)); // -1 because a < b & 1 because a > b

		// 5. copyOf()
		int[] copied = Arrays.copyOf(a, 5); //Copies array with new length
		System.out.println("5. copyOf(): " + Arrays.toString(copied)); // padded with 0s or default value

		// 6. copyOfRange()
		int[] rangedCopy = Arrays.copyOfRange(b, 1, 3);
		System.out.println("6. copyOfRange(): " + Arrays.toString(rangedCopy));

		// 7. deepEquals()
		Integer[][] arr1 = {{1, 2}, {3, 4}};
		Integer[][] arr2 = {{1, 2}, {3, 5}};
		System.out.println("7. deepEquals(): " + Arrays.deepEquals(arr1, arr2));

		// 8. deepHashCode() // s[0] *31 ^(n-1) + s[1] * 31 ^(n-2)+ s[n-1]
		//"ABC"  => 65*31^2 + 66*31^1 + 67 
		String s = "ABC";
		System.out.println("Hashcode of string ABC"+s.hashCode());
		System.out.println("8. deepHashCode(): " + Arrays.deepHashCode(arr1));

		// 9. deepToString()
		System.out.println("9. deepToString(): " + Arrays.deepToString(arr1));

		// 10. equals()
		System.out.println("10. equals(): " + Arrays.equals(a, b)); // false

		// 11. fill()
		int[] fillArray = new int[5];
		Arrays.fill(fillArray, 7);
		System.out.println("11. fill(): " + Arrays.toString(fillArray));

		// 12. hashCode()
		System.out.println("12. hashCode(): " + Arrays.hashCode(a));

		// 13. mismatch()
		System.out.println("13. mismatch(): " + Arrays.mismatch(a, b) + " index values are first to be mismatched" ); // equals => -1 or else first mismatched index value

		// 14. parallelPrefix(fromIndex, toIndex)
		int[] prefixRange = {1, 2, 3, 4, 5};
		Arrays.parallelPrefix(prefixRange, 1, 4, Integer::sum);
		System.out.println("14. parallelPrefix(range): " + Arrays.toString(prefixRange));

		// 15. parallelPrefix(full array)
		int[] prefixAll = {1, 2, 3, 4, 5};
		Arrays.parallelPrefix(prefixAll, Integer::sum);
		System.out.println("15. parallelPrefix(): " + Arrays.toString(prefixAll));

		// 16. parallelSetAll()
		int[] parallelSet = new int[5];
		Arrays.parallelSetAll(parallelSet, i -> i * i);
		System.out.println("16. parallelSetAll(): " + Arrays.toString(parallelSet));

		// 17. parallelSort() - uses multi-threading ForkJoinPool is much faster
		int[] unsorted = {5, 2, 1, 4, 3};
		Arrays.parallelSort(unsorted);
		System.out.println("17. parallelSort(): " + Arrays.toString(unsorted));

		// 18. setAll()
		int[] setAllArray = new int[5];
		Arrays.setAll(setAllArray, i -> i + 10);
		System.out.println("18. setAll(): " + Arrays.toString(setAllArray));

		// 19. sort()
		byte[] simpleSort = {9, 1, 3};
		Arrays.sort(simpleSort);
		System.out.println("19. sort(): " + Arrays.toString(simpleSort));

		// 20. sort(fromIndex, toIndex)
		int[] partialSort = {5, 8, 2, 6, 4};
		Arrays.sort(partialSort, 1, 5);
		System.out.println("20. sort(range): " + Arrays.toString(partialSort));

		// 21. sort with comparator (range)
		String[] compSortRange = {"dog", "apple", "cat", "bat"};
		Arrays.sort(compSortRange, 0, 3, Comparator.reverseOrder());
		System.out.println("21. sort(range, comparator): " + Arrays.toString(compSortRange));

		// 22. sort with comparator (full)
		String[] compSort = {"dog", "apple","ape", "cat", "bat"};
		Arrays.sort(compSort, Comparator.naturalOrder());
		System.out.println("22. sort(comparator): " + Arrays.toString(compSort));

		// 23. spliterator() = Split + Iterator => Java 8
		Spliterator<String> spliterator = Arrays.spliterator(compSort);
		System.out.print("23. spliterator(): \n");
		spliterator.forEachRemaining(System.out::println); 
		System.out.println();

		// 24. spliterator(fromIndex, toIndex) => Creates Splititerator performs operation on parts concatenates result
		Spliterator<String> spliteratorRange = Arrays.spliterator(compSort, 1, 3);
		System.out.print("24. spliterator(range): ");
		spliteratorRange.forEachRemaining(System.out::println);
		System.out.println();

		// 25. stream() =>  Converts array to Stream
		int[] streamArray = {1, 2, 3, 4};
		IntStream stream = Arrays.stream(streamArray);
		System.out.print("25. stream(): ");
		stream.forEach(n -> System.out.print(n + " "));
		System.out.println();

		// 26. toString()
		System.out.println("26. toString(): " + Arrays.toString(streamArray));
	}

	public static boolean isFixedSize(List<?> strList){
		try {

			strList.add(null);
			strList.remove(strList.size()-1);
			return false;
		}catch(UnsupportedOperationException e) {
			return true;
		}
	}

}
