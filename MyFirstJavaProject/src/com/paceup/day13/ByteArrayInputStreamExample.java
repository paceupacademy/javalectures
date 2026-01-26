package com.paceup.day13;

import java.io.ByteArrayInputStream;
import java.util.Iterator;

public class ByteArrayInputStreamExample {

	public static void main(String[] args) {
		byte[] buffer = {72 , 64 , 69 , 75, 83 , 76, 84, 90};

		ByteArrayInputStream bis = null;

		try {
			bis = new ByteArrayInputStream(buffer);

			System.out.println("Bytes are remaining? "+ bis.available());
			System.out.println("\nBytes are : \n");
			for(byte b: buffer) {
				if(bis.available()==4) {
					bis.mark(0);
				}
				System.out.print((char)bis.read()+"\t");
				boolean check = bis.markSupported();
				System.out.print(" "+check+"\n");
			}
			if(bis.markSupported()) {
				bis.reset(); //Reposition this stream to position at time when mark method
				for(int i=bis.available(); i<=buffer.length;i++) {
					//System.out.println(bis.available());
					System.out.print(" "+(char)bis.read());	
				}
			}

		} catch( Exception e) {
			e.printStackTrace();
		}

	}

}
