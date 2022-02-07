package in.sts.excelutility.utils;
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

public class ReadExcel {
	public void unique() {	
		
		try {
		Scanner fileInput= new Scanner(System.in);
		System.out.println("Enter the filename: ");
		String fileName=fileInput.nextLine();
		FileInputStream inputStream = new FileInputStream("F:\\"+fileName+".xlsx");
		Workbook workbook = new XSSFWorkbook(inputStream);

		Sheet sheet =workbook.getSheetAt(0);
		int lastRowNumber=sheet.getLastRowNum();

		HashSet<Integer> hashset = new HashSet();

		for(int i=0;i<=lastRowNumber;i++) {
			Row row=sheet.getRow(i);
			Cell firstcell=row.getCell(0);
			int number =(int) firstcell.getNumericCellValue();
			hashset.add(number);
		}
		System.out.println(hashset);

	}
		catch(FileNotFoundException exception) {
	    System.out.println("Please enter the correct filename..!");
	    unique();
	} 
		catch (IOException exception) {
		System.out.println("Data Not Found");
	}
	}

	public static void main(String[] args) {
		ReadExcel excel = new  ReadExcel();
		excel.unique();




	}
}
