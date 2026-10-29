package com.paceup.IOStreams;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageCopy {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		try(FileInputStream fis = new FileInputStream("C://Users/suraj/git/javalectures1/download.webp");
				FileOutputStream fos = new FileOutputStream("CopiedImage.webp")){
			byte[] buffer = new byte[1024];
			int bytesRead;
			
			while((bytesRead=fis.read(buffer))!=-1) {
				fos.write(buffer, 0, bytesRead);
			}
			System.out.println("Image copied successfully");
		}
	}

}
