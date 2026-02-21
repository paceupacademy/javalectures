package com.paceup.StreamsAPI;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingWithCounting {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Anna");

        // Count names grouped by their first letter
        Map<Character, Long> countByFirstLetter = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()));

        System.out.println(countByFirstLetter);
    }
}
