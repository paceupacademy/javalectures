package com.paceup.day21;

import java.util.*;
import java.util.stream.*;

public class CollectPartitioningByExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> partitioned = numbers.stream() //list to streams
                                                         .collect(Collectors.partitioningBy(num -> num % 2 == 0)); //groups elements in two categories true-false 
        System.out.println(partitioned);
        // Output: {false=[1, 3, 5], true=[2, 4, 6]}
    }
}
