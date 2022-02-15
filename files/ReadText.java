package in.sts.excelutility.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class ReadText {
	final Logger log = Logger.getLogger(ReadText.class);


	public void readText() {

		Scanner fileInput = null;
		Scanner scanner = null;

		try {
			fileInput= new Scanner(System.in);
			log.info("Enter the filename: ");
			String fileName=fileInput.nextLine();
			File filePath = new File("F:\\"+fileName+".txt");

			HashSet<Integer>uniqueValue = new HashSet<Integer>();
			
			scanner = new Scanner(filePath);
			while(scanner.hasNext()) {
				uniqueValue.add(scanner.nextInt());
			}
			log.info(uniqueValue);

		} catch (FileNotFoundException e) {
			log.error("Please enter a correct file name..!");
		}
		finally {
			if(fileInput != null)
				fileInput.close();

			if(scanner != null)
				scanner.close();

		}

	}


}


