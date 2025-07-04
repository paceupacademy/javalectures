package com.paceup.day21;

import java.util.*;
import java.util.stream.*;

public class CollectToListExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie","Avinash", "David","Anju");
        List<String> collectedNames = names.stream() //names to streams
                                           .filter(name -> name.startsWith("A")) //lambda expression to check if name starts with A
                                           .collect(Collectors.toList());
        System.out.println(collectedNames); // Output: [Alice,Avinash,Anju]
    }
}
