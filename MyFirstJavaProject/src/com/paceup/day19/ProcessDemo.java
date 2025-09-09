package com.paceup.day19;

import java.io.IOException;

public class ProcessDemo {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("java","-cp","out","com.paceup.day19.Helloworld","com.paceup.day19.Springbootexample");
		try {
			Process pr = pb.start();
			System.out.println("ProcessDemo Ran!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
