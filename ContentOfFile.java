package Ass1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ContentOfFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("F:\\Demo.txt");
		
		
		try {
		Scanner sc = new Scanner(file);
		HashSet<Integer> set = new HashSet();
		
		while(sc.hasNext()) {
			set.add(sc.nextInt());
		}
		
		System.out.println(set);
		
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
