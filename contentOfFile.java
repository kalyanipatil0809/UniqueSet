package com.uniquevalue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class contentOfFile {
	void read() {

		Scanner fileInput= new Scanner(System.in);
		System.out.println("Enter the filename: ");
		String fileName=fileInput.nextLine();
		File file = new File("F:\\"+fileName+".txt");


		try {
			Scanner sc = new Scanner(file);
			HashSet<Integer> set = new HashSet();

			while(sc.hasNext()) {
				set.add(sc.nextInt());
			}

			System.out.println(set);


		}catch(FileNotFoundException e) {
			System.out.println("please enter the correct file name..!");
			read();
		}

	}

	public static void main(String[] args) throws IOException {

		contentOfFile contentoffile = new contentOfFile();
		contentoffile.read();


	}
}
