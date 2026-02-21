package com.paceup.ArraysStrings;

/**
 * StringExample1:
 * ----------------
 * This program demonstrates various operations available in the **String** class in Java.
 * 
 * Key Concepts:
 * -------------
 * 1. **String Immutability**:
 *    - Strings in Java are immutable (cannot be changed once created).
 *    - Operations like concat(), replace(), etc. return new String objects.
 * 
 * 2. **Common Methods Demonstrated**:
 *    - concat(): Appends text to the existing string.
 *    - length(): Returns the length of the string.
 *    - contains(): Checks if a substring exists.
 *    - substring(): Extracts part of the string.
 *    - join(): Joins multiple strings with a delimiter.
 *    - replace(), replaceAll(), replaceFirst(): Replace characters or substrings.
 *    - charAt(): Returns character at a given index.
 *    - getBytes(): Converts string into byte array.
 *    - indexOf(): Finds position of a substring.
 *    - compareTo(), compareToIgnoreCase(): Lexicographical comparison.
 *    - trim(): Removes leading/trailing spaces.
 *    - format(): Creates formatted strings using placeholders.
 *    - split(): Splits string into array of substrings.
 *    - toLowerCase(), toUpperCase(): Case conversion.
 *    - valueOf(): Converts primitive values into String.
 *    - toCharArray(): Converts string into char array.
 *    - matches(): Regex matching.
 *    - startsWith(), endsWith(): Prefix/suffix checks.
 *    - isEmpty(): Checks if string is empty.
 *    - contentEquals(): Compares with StringBuffer/CharSequence.
 *    - hashCode(): Returns hash code of the string.
 *    - subSequence(): Extracts a subsequence of characters.
 */
public class StringExample1 {
    public static void main(String[] args) {
        String s = "Data Recovered";
        s = s.concat(" but corrupted"); // concat(): appends text to the string
        System.out.println(s);

        String original = "  Hello Java Developers!  ";
        String test = " JaVa";
        String test2 = "java";
        String str = new String("Welcome to Java!!");

        str = "World";
        String str1 = str.concat(" Universe"); // concat(): appends " Universe"
        System.out.println("String: " + str1);

        System.out.println("Length of string is " + str1.length()); // length(): returns string length

        System.out.println("Contains 'Java': " + original.contains("Java")); // contains(): checks substring

        System.out.println("Substring (8, 12): " + original.substring(8, 12)); // substring(): extract part

        String joined = String.join("-", "2025", "07", "15"); // join(): joins with delimiter
        System.out.println("Joined: " + joined);

        System.out.println("Replace 'Java' with 'World': " + original.replace("Java", "World")); // replace(): replaces substring
        System.out.println("ReplaceAll whitespace with '-': " + original.replaceAll("\\s", "-")); // replaceAll(): regex replace
        System.out.println("ReplaceFirst whitespace with '*': " + original.replaceFirst("\\s", "*")); // replaceFirst(): replace first match

        System.out.println("Character at index 6: " + original.charAt(5)); // charAt(): character at index

        byte[] byteArray = original.getBytes(); // getBytes(): converts to byte array
        System.out.print("getBytes(): ");
        for (byte b : byteArray) {
            System.out.print(b + " ");
        }
        System.out.println();

        System.out.println("Index of 'Java' " + original.indexOf("Java")); // indexOf(): position of substring

        System.out.println("Test: " + test + " Test2: " + test2);
        System.out.println("CompareTo 'Java': " + test2.compareTo(test)); // compareTo(): lexicographic comparison
        System.out.println("CompareToIgnoreCase 'java': " + test.compareToIgnoreCase(test2)); // compareToIgnoreCase(): ignores case

        System.out.println("Trimmed: '" + original.trim() + "'"); // trim(): removes leading/trailing spaces

        String formatted = String.format("My name is %s and I am %d years old", "Aishwarya", 28); // format(): formatted string
        System.out.println("Formatted: " + formatted);

        String[] words = original.trim().split(" "); // split(): splits into array
        System.out.print("Split words: ");
        for (String w : words) {
            System.out.print(w + " | ");
        }
        System.out.println();

        System.out.println("To Lower Case: " + original.trim().toLowerCase()); // toLowerCase(): lowercase
        System.out.println("To Upper Case: " + original.toUpperCase()); // toUpperCase(): uppercase

        int num = 100;
        String numStr = String.valueOf(num); // valueOf(): converts primitive to String
        System.out.println("Value Of int: " + numStr);

        char[] chars = original.trim().toCharArray(); // toCharArray(): converts to char array
        System.out.print("ToCharArray: ");
        for (char c : chars) {
            System.out.print(c + ", ");
        }
        System.out.println();

        System.out.println("Matches regex '.*Java.*': " + original.matches(".*Java.*")); // matches(): regex match
        System.out.println("StartsWith 'Hello': " + original.trim().startsWith("Hello")); // startsWith(): prefix check
        System.out.println("EndsWith 'Developers!': " + original.trim().endsWith("Developers!")); // endsWith(): suffix check

        String emptyStr = "";
        System.out.println("Is empty string empty? " + emptyStr.isEmpty()); // isEmpty(): check empty

        StringBuffer sb = new StringBuffer("Hello Java Developers!");
        System.out.println("ContentEquals StringBuffer: " + original.trim().contentEquals(sb)); // contentEquals(): compare with StringBuffer

        System.out.println("HashCode of original: " + original.hashCode()); // hashCode(): returns hash code

        CharSequence subSeq = original.subSequence(2, 7); // subSequence(): extract subsequence
        System.out.println("SubSequence (2, 7): " + subSeq);

        subSeq = original.subSequence(9, 15);
        System.out.println(subSeq);
    }
}
