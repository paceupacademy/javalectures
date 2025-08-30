package com.paceup.day20;

import java.util.Arrays;
import java.util.Comparator;

public class SortComparatorExample {
	public static void main(String[] args) {
		String[] words = {"banana", "apple", "watermelon", "grapes", "Chickoo", "mango", "cherry"};
		System.out.println("UnSorted Array: "+Arrays.toString(words));
		Arrays.sort(words, Comparator.comparingInt(String::length).thenComparing(Comparator.reverseOrder()));
		
		System.out.println("Sorted Array: "+Arrays.toString(words));
	}
}
