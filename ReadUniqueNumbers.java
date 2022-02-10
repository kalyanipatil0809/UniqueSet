package in.sts.excelutility.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadUniqueNumbers {

	final Logger logger = Logger.getLogger(ReadUniqueNumbers.class);

	void readFile() {

		try {
			Scanner selectcase = new Scanner(System.in);
			logger.info("select 1 to read the text file");
			logger.info("select 2 to read the excel file");

			int select = selectcase.nextInt();

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
				logger.info(Uniqueset);

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
				selectcase.close();
				fileInput.close();
			}

		} catch(FileNotFoundException exception) {
			logger.error("please enter the correct file name..!");
			readFile();

		}  catch (IOException exception) {
			logger.error("Data Not Found");
		}


	}
	public static void main(String[] args) {

		BasicConfigurator.configure();

		ReadUniqueNumbers readUniqueNumbers=new ReadUniqueNumbers();
		readUniqueNumbers.readFile();
	}

}
