package com.paceup.day21;

import java.util.*;
import java.util.stream.*;

public class CollectGroupingByExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Anna");
        Map<Character, List<String>> groupedByFirstLetter = names.stream()
                                                                 .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(groupedByFirstLetter);
        // Output: {A=[Alice, Anna], B=[Bob], C=[Charlie], D=[David]}
    }
}
