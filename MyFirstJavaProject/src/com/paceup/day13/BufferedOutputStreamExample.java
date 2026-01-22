package com.paceup.day13;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
public class BufferedOutputStreamExample {

	public static void main(String[] args) {
		String data = "Buffered Output Stream Java Example !!";
		try(FileOutputStream fos = new FileOutputStream("abc.txt");
				BufferedOutputStream bos = new BufferedOutputStream(fos);){			
			
			byte[] bytes = data.getBytes();
			System.out.println(bytes.length);
			bos.write(bytes, 5, bytes.length-5);
			bos.close();
			System.out.println("Data is written to file");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
