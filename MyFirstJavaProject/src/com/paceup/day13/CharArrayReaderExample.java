/**
 * 
 */
package com.paceup.day13;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * 
 */
public class CharArrayReaderExample {

	public static void main(String[] args) {
		char[] input = "Hello Students!!! Welcome to Java ***".toCharArray();
		try(CharArrayReader cr = new CharArrayReader(input);
				CharArrayWriter cw = new CharArrayWriter()){
			int ch;
			while((ch = cr.read()) != -1) {
				cw.write(Character.toUpperCase((char)ch));
			}
			System.out.println("Original Charcter Array:"+ new String(input));
			System.out.println("Modified Character Array:"+cw.toString());
		} catch (IOException e) {
			System.out.println("Message: "+e.getMessage());
		}

	}
}