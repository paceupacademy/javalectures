package com.paceup.day21;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice","Eve", "Bob", "Charlie", "David","Chad", "Anna","Alice");

        // Group names by their first letter
        Map<Integer, List<String>> groupedByFirstLetter = names.stream()
                .collect(Collectors.groupingBy(String::length)); //groups names by the length of Strings

        System.out.println(groupedByFirstLetter);
    }
}
