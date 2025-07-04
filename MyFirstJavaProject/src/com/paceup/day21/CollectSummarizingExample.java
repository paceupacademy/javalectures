package com.paceup.day21;

import java.util.*;
import java.util.stream.*;

/*
 * Integer::intValue - converts each Integer to int
 * summarizingInt - return object of type IntSummaryStatistics which has : counts how many numbers are there, sum thems up, finds min and max, calculates average
 */

public class CollectSummarizingExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        IntSummaryStatistics stats = numbers.stream()
                                            .collect(Collectors.summarizingInt(Integer::intValue)); 
        System.out.println(stats);
        // Output: IntSummaryStatistics{count=5, sum=15, min=1, average=3.000000, max=5}
    }
}

