package com.paceup.StreamsAPI;

import java.util.*;
import java.util.stream.*;

public class CollectToSetExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        Set<Integer> uniqueNumbers = numbers.stream()
                                            .collect(Collectors.toSet()); 
        System.out.println(uniqueNumbers); // Output: [1, 2, 3, 4, 5]
    }
}
