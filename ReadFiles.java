package in.sts.excelutility.utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class ReadFiles {

	void read() {

		try {
			Scanner selectcase = new Scanner(System.in);
			System.out.println("select 1 to read the text file");
			System.out.println("select 2 to read the excel file");

			int select= selectcase.nextInt();

			int value;
			switch (select) {

			case 1:

				Scanner fileInput= new Scanner(System.in);
				System.out.println("Enter the filename: ");
				String fileName=fileInput.nextLine();
				File file = new File("F:\\"+fileName+".txt");
				Scanner scanner = new Scanner(file);
				HashSet<Integer> Hashset = new HashSet();

				while(scanner.hasNext()) {
					Hashset.add(scanner.nextInt());
				}
				System.out.println(Hashset);

				break;

			case 2:
				Scanner fInput= new Scanner(System.in);
				System.out.println("Enter the filename: ");
				String fName=fInput.nextLine();
				FileInputStream inputStream = new FileInputStream("F:\\"+fName+".xlsx");
				Workbook workBook = new XSSFWorkbook(inputStream);
				Sheet sheet =workBook.getSheetAt(0);
				int lastRowNumber=sheet.getLastRowNum();

				HashSet<Integer> Uniqueset = new HashSet();

				for(int i=0;i<=lastRowNumber;i++) {
					Row row=sheet.getRow(i);
					Cell firstcell=row.getCell(0);
					int number =(int) firstcell.getNumericCellValue();
					Uniqueset.add(number);
				}
				System.out.println(Uniqueset);

			}
		}catch(FileNotFoundException exception) {
			System.out.println("please enter the correct file name..!");
			read();

		}  catch (IOException exception) {
			System.out.println("Data Not Found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadFiles d=new ReadFiles();
		d.read();
	}

}


