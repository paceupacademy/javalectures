package com.paceup.StreamsAPI;

import java.util.*;
import java.util.stream.*;

public class CollectJoiningExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "is", "awesome");
        String sentence = words.stream()
                               .collect(Collectors.joining(" ")); //collect elements of stream and join them in single string
        System.out.println(sentence); // Output: Java is awesome
    }
}
