package com.paceup.ArraysStrings;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * 
 * Arrays class:
 * - Provides static utility methods for array manipulation.
 * - Common operations: searching, comparing, copying, filling, sorting, streaming.
 * - Works for both primitive and object arrays.
 * 
 * Key Concepts:
 * -------------
 * - Arrays.asList(): Wraps array into fixed-size List (backed by original array).
 * - Arrays.binarySearch(): Efficient search (requires sorted array).
 * - Arrays.compare(): Lexicographically compares two arrays.
 * - Arrays.copyOf() / copyOfRange(): Creates new arrays with specified length/range.
 * - Arrays.deepEquals(), deepHashCode(), deepToString(): Work for nested arrays.
 * - Arrays.fill(): Assigns same value to all elements.
 * - Arrays.hashCode(): Returns hash based on contents.
 * - Arrays.mismatch(): Finds first differing index.
 * - Arrays.parallelPrefix(): Applies cumulative operation (prefix sum).
 * - Arrays.parallelSetAll() / setAll(): Initializes array with generator function.
 * - Arrays.parallelSort(): Multithreaded sort (faster for large arrays).
 * - Arrays.sort(): Standard sort (with optional comparator).
 * - Arrays.spliterator(): Creates Spliterator for parallel iteration.
 * - Arrays.stream(): Converts array to Stream.
 * - Arrays.toString(): String representation of array.
 */
public class ArraysMethodsDemo {

    public static void main(String[] args) {
        // 1. asList() - Convert array to fixed-size List
        String[] strArray = {"Java", "Python", "C++"};
        List<String> strList = Arrays.asList(strArray);
        //strList.add(null);
        System.out.println("1. asList(): " + strList + " | Length: " + strList.size());
        System.out.println("Is fixed size? " + isFixedSize(strList));

        // 2. binarySearch() O(log n) =>time complexity
        int[] numArray = {1, 3, 8, 5, 7, 9};
        System.out.println("2. binarySearch(): Index of 9 is " + Arrays.binarySearch(numArray, 9));

        // 3. binarySearch with comparator = Lexicographically
        String[] names = {"Anu", "Anish", "Chetan", "Divya", "Zara", "Rahul"};
        Comparator<String> comparator = String::compareTo;
        String s1 = "Java";
        String s2 = "Javascript";
         // 4 - 10 = -6
        // 10 - 4 = 6
        
        /*
         * low =0 high =5 mid => 2
         * Chetan = Rahul => high =>  5 , low =3
         * mid = 4
         * Divya.compare(Rahul)
         * Divya<Rahul
         * Rahul
         * 
         */
        System.out.println(s2.compareTo(s1));
        System.out.println("3. binarySearch with comparator: Index of 'Rahul' is " +
                           Arrays.binarySearch(names, 0, names.length, "Rahul", comparator));

        // 4. compare()
        /*
         * Equal = Return 0
         * First Array indexes value less => Returns -1
         * First Array indexes value greater => Returns 1
         */
        int[] a = {1, 4, 8};
        int[] b = {1, 4, 5};
        System.out.println("4. compare(): " + Arrays.compare(a, b));

        // 5. copyOf()
        System.out.println("5. copyOf(): " + Arrays.toString(Arrays.copyOf(a, 5)));

        // 6. copyOfRange()
        System.out.println("6. copyOfRange(): " + Arrays.toString(Arrays.copyOfRange(b, 1, 3)));

        // 7. deepEquals()
        Integer[][] arr1 = {{1, 2}, {3, 4}};
        Integer[][] arr2 = {{1, 2}, {3, 5}};
        System.out.println("7. deepEquals(): " + Arrays.deepEquals(arr1, arr2));

        // 8. deepHashCode()
        /*
         * A=65
         * B=66
         * C=67
         * 
         * 65*31^(2)+66*31^(1)+67*31^(0)
         * 65*961+66*31+67
         * 64578
         * 
         * arr1 =>
         * {1,2} => 994
         * {3,4} => 1058
         *
         */
        String s = "ABC";
        System.out.println("HashCode of 'ABC': " + s.hashCode());
        System.out.println("8. deepHashCode(): " + Arrays.deepHashCode(arr1));

        // 9. deepToString()
        System.out.println("9. deepToString(): " + Arrays.deepToString(arr1));

        // 10. equals()
        System.out.println("10. equals(): " + Arrays.equals(a, b));

        // 11. fill()
        int[] fillArray = new int[5];
        Arrays.fill(fillArray, 7);
        System.out.println("11. fill(): " + Arrays.toString(fillArray));

        // 12. hashCode()
        System.out.println("12. hashCode(): " + Arrays.hashCode(a));

        // 13. mismatch()
        System.out.println("13. mismatch(): " + Arrays.mismatch(a, b));

        // 14. parallelPrefix(range)
        /*
         * 2
         * 2+3 = 5
         * 2+3+4 = 9
         * 
         * [1,2,5,9,5]
         */
        int[] prefixRange = {1, 2, 3, 4, 5};
        Arrays.parallelPrefix(prefixRange, 1, 4, Integer::sum);
        System.out.println("14. parallelPrefix(range): " + Arrays.toString(prefixRange));

        // 15. parallelPrefix(full array)
        
        int[] prefixAll = {1, 2, 3, 4, 5};
        Arrays.parallelPrefix(prefixAll, Integer::sum);
        System.out.println("15. parallelPrefix(): " + Arrays.toString(prefixAll));
        
        /*
         * a*(b*c) = (a*b)*c
         * a+(b+c) = (a+b)+c
         * (a+b)*c != a+(b*c)
         */
        Arrays.parallelPrefix(prefixAll, (a1,b1)->a1*b1);
        System.out.println(Arrays.toString(prefixAll));

        // 16. parallelSetAll()
        int[] parallelSet = new int[5];
        Arrays.parallelSetAll(parallelSet, i -> i * i);
        System.out.println("16. parallelSetAll(): " + Arrays.toString(parallelSet));

        // 17. parallelSort()
        /*
         * 5, 2, 1, 4, 3
         * [5,2,1] [4,3]
         * 
         * [1,2,5] [3,4]
         * 
         * [1,2,3,4,5]
         */
        int[] unsorted = {5, 2, 1, 4, 3};
        Arrays.parallelSort(unsorted);
        System.out.println("17. parallelSort(): " + Arrays.toString(unsorted));

        // 18. setAll()
        int[] setAllArray = new int[5];
        Arrays.setAll(setAllArray, i -> i + 10);
        System.out.println("18. setAll(): " + Arrays.toString(setAllArray));

        Integer[] arr = {5,2,8,1,3};
        // 19. sort()
        byte[] simpleSort = {9, 1, 3};
        Arrays.sort(simpleSort);
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("19. sort(): " + Arrays.toString(simpleSort));
        System.out.println("Descending Order  "+Arrays.toString(arr));
        
        // 20. sort(range)
        int[] partialSort = {5, 8, 2, 6, 4};
        Arrays.sort(partialSort, 1, 5);
        System.out.println("20. sort(range): " + Arrays.toString(partialSort));

        // 21. sort(range, comparator)
        String[] compSortRange = {"dog", "apple", "cat", "bat"};
        Arrays.sort(compSortRange, 0, 3, Comparator.reverseOrder());
        System.out.println("21. sort(range, comparator): " + Arrays.toString(compSortRange));

        // 22. sort(comparator)
        String[] compSort = {"dog", "apple", "ape", "cat", "bat"};
        Arrays.sort(compSort, Comparator.naturalOrder());
        System.out.println("22. sort(comparator): " + Arrays.toString(compSort));

        // 23. spliterator()
        /*
         * Traverse elements
         * Split elements into portions for parallel processing
         */
        Spliterator<String> spliterator = Arrays.spliterator(compSort);
        System.out.println("23. spliterator():");
        spliterator.forEachRemaining(System.out::println);

        // 24. spliterator(range)
        Spliterator<String> spliteratorRange = Arrays.spliterator(compSort, 1, 3);
        System.out.println("24. spliterator(range):");
        spliteratorRange.forEachRemaining(System.out::println);

        // 25. stream()
        int[] streamArray = {1, 2, 3, 4};
        System.out.print("25. stream(): ");
        Arrays.stream(streamArray).forEach(n -> System.out.print(n + " "));
        
        System.out.println();
        System.out.println("Even Data");
        Arrays.stream(streamArray)
        		.filter(n -> n%2 ==0)
        		.forEach(System.out::println);
        
        int sum = Arrays.stream(streamArray).sum();
        System.out.println("Summation "+sum);

        // 26. toString()
        System.out.println("26. toString(): " + Arrays.toString(streamArray));
    }

    // Helper method to check if List is fixed-size
    public static boolean isFixedSize(List<?> strList){
        try {
            System.out.println("Adding null element"+strList.add(null));
            strList.remove(strList.size()-1);
            return false;
        } catch(UnsupportedOperationException e) {
            return true;
        }
    }
}
