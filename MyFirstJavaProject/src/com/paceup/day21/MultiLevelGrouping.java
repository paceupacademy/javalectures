package com.paceup.day21;

import java.util.*;
import java.util.stream.Collectors;

public class MultiLevelGrouping {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob","Bunty", "Charlie","Chad", "Dave", "Dane", "David", "Eve", "Anna", "Anju");

        // Group names by first letter, then by length
        Map<Character, Map<Integer, List<String>>> multiLevelGrouping = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0),
                        Collectors.groupingBy(String::length)));

        System.out.println(multiLevelGrouping);
    }
}
