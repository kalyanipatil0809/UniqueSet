package in.sts.excelutilty.reader;

import java.util.Scanner;
import org.apache.log4j.Logger;

import in.sts.excelutility.files.ReadExcelFile;
import in.sts.excelutility.files.ReadText;

public class ReadFiles {
	final Logger log = Logger.getLogger(ReadFiles.class);

	public void readUniqueData() {



		Scanner selectcase = new Scanner(System.in);
		System.out.println("Select 1 to read the Text file");
		System.out.println("Select 2 to read the Excel file");


		int select = selectcase.nextInt();


		switch(select) {
		case 1:

			ReadText readText= new ReadText();
			readText.readText();

			break;

		case 2:
			ReadExcelFile Readexcelfile = new ReadExcelFile();
			Readexcelfile.readExcel();

			break;


		}
		selectcase.close();

	}


}

