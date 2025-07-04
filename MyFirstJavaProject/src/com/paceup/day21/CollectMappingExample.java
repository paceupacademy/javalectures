package com.paceup.day21;

import java.util.*;
import java.util.stream.*;

public class CollectMappingExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<Integer> nameLengths = names.stream()
                                         .collect(Collectors.mapping(String::length, Collectors.toList()));
        System.out.println(nameLengths); // Output: [5, 3, 7]
    }
}
