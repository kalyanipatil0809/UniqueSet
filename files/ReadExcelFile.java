package in.sts.excelutility.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	final Logger log = Logger.getLogger(ReadExcelFile.class);

	public void readExcel() {

		Scanner fileInput = null;


		try {
			fileInput= new Scanner(System.in);		
			log.info("Enter the filename: ");
			String fileName=fileInput.nextLine();

			FileInputStream inputStream = new FileInputStream("F:\\"+fileName+".xlsx");
			Workbook workBook = new XSSFWorkbook(inputStream);
			Sheet sheet =workBook.getSheetAt(0);
			int lastRowNumber=sheet.getLastRowNum();

			HashSet<Integer> uniqueValue = new HashSet<Integer>();

			for(int i=0;i<=lastRowNumber;i++) {
				Row row=sheet.getRow(i);
				Cell firstcell=row.getCell(0);
				int number =(int) firstcell.getNumericCellValue();

				uniqueValue.add(number);
			} 
			log.info(uniqueValue);

			workBook.close();
		}

		catch(FileNotFoundException exception) {
			System.out.println("Please enter the correct file name..!");


		}  catch (IOException exception) {
			System.out.println("Data Not Found");
		}
		finally {
			if(fileInput != null)
				fileInput.close();

		}

	}

}
