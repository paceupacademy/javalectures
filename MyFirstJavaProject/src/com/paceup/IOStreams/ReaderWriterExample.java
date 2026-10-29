package com.paceup.IOStreams;

import java.io.File;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class ReaderWriterExample {
	static String source="C://Users/suraj/git/javalectures1/download.webp";
	static String destination="C://Users/suraj/git/javalectures1/CopiedImage1.webp";
	public static void main(String[] args) throws IOException{
		Path sourcePath = Path.of(source);
		Path base64Path = Path.of("C://Users/suraj/git/javalectures1/image.txt");
		Path destinationPath = Path.of(destination);
		byte[] imageBytes = Files.readAllBytes(sourcePath);

		String encodedString =Base64.getEncoder().encodeToString(imageBytes);

		/*
		 * Step1: Writing Base64 test using FileWriter
		 */
		try(FileWriter writer = new FileWriter(base64Path.toFile())){

			writer.write(encodedString);
			writer.flush();
		}

		/*
		 * Step2 : Read Base64 text using FileReader
		 */
		StringBuilder sb = new StringBuilder();
		try(Reader reader = new FileReader(base64Path.toFile())){
			char[] buffer = new char[1024];
			int charRead;

			while((charRead=reader.read(buffer))!=-1) {
				sb.append(buffer, 0, charRead);
			}

		}

		/*
		 * Step 3 : Decode text back to orignal image bytes
		 */

		byte[] copiedBytes = Base64.getDecoder().decode(sb.toString());

		/*
		 * Step 4 : Write decoded bytes to image file
		 */
		Files.write(destinationPath, copiedBytes);
		System.out.println("Image Copied!!!");

		File original = new File(source);
		File copied =  new File(destination);

		System.out.println("Original Size "+original.length());
		System.out.println("Copied Size "+copied.length());

		System.out.println("Difference "+(copied.length()-original.length()));

	}

}
