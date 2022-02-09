package in.sts.excelutility.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadUniqueNumbers {
	
	private final Logger logger = LogManager.getLogger(ReadUniqueNumbers.class);
	Properties properties = new Properties();


	void readFile() {

		try {
			
			@SuppressWarnings("resource")
			Scanner selectcase = new Scanner(System.in);
			logger.info("select 1 to read the text file");
			logger.info("select 2 to read the excel file");

			int select = selectcase.nextInt();

			@SuppressWarnings("resource")
			Scanner fileInput= new Scanner(System.in);
			logger.info("Enter the filename: ");
			String fileName=fileInput.nextLine();
			
			HashSet<Integer> Uniqueset = new HashSet<Integer>();

			switch (select) {

			case 1:
				
				File filename = new File("F:\\"+fileName+".txt");
				Scanner scanner = new Scanner(filename);
				
				while(scanner.hasNext()) {
					Uniqueset.add(scanner.nextInt());
				}
				System.out.println(Uniqueset);

				break;   

			case 2:	

				FileInputStream inputStream = new FileInputStream("F:\\"+fileName+".xlsx");
				Workbook workBook = new XSSFWorkbook(inputStream);
				Sheet sheet =workBook.getSheetAt(0);
				int lastRowNumber=sheet.getLastRowNum();



				for(int i=0;i<=lastRowNumber;i++) {
					Row row=sheet.getRow(i);
					Cell firstcell=row.getCell(0);
					int number =(int) firstcell.getNumericCellValue();
					Uniqueset.add(number);
				}

				logger.info(Uniqueset);

				inputStream.close();
			}
		}catch(FileNotFoundException exception) {

			logger.info("please enter the correct file name..!");
			readFile();

		}  catch (IOException exception) {
			logger.info("Data Not Found");
		}

	}


	public static void main(String[] args) {
		ReadUniqueNumbers readUniqueNumbers=new ReadUniqueNumbers();
		readUniqueNumbers.readFile();
	}

}
