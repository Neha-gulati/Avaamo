package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {

	int TC_no=1;
	File file = new File("./Output/Output.xlsx");

	public void createExcelSheet() throws IOException
	{
		writeToExcel();

	}

	public void writeTestcases(String Scenarios, String Act_Result, String Status ) throws IOException
	{

		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Test");
		int r = sheet.getLastRowNum()+1;
		XSSFRow row = sheet.createRow(r);

		row.createCell(0).setCellValue(TC_no++);
		row.createCell(1).setCellValue(Scenarios);
		row.createCell(2).setCellValue(Act_Result);
		row.createCell(3).setCellValue(Status);
		FileOutputStream outputStream = new FileOutputStream(file);
		wb.write(outputStream);
		wb.close();
	}

	public void writeToExcel() throws IOException
	{

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Test");
		int r = sheet.getLastRowNum()+1;
		XSSFRow row = sheet.createRow(r); 

		row.createCell(0).setCellValue("TC_No");
		row.createCell(1).setCellValue("Scenarios");
		row.createCell(2).setCellValue("Actual Result");
		row.createCell(3).setCellValue("Status");
		FileOutputStream outputStream = new FileOutputStream(file);
		wb.write(outputStream);
	}

}
