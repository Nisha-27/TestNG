package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MyExcelReader {
	
	@DataProvider
	public String[][] getDataFromExcel() throws IOException
	{
		File f = new File(System.getProperty("user.dir") + 
				"\\src\\test\\resources\\myExcel\\LoginInfo.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheetName = wb.getSheet("Login");
		
		int rows = sheetName.getPhysicalNumberOfRows();
		
		System.out.println(" no of rows " + rows);
		
		int columns = sheetName.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println(" no of columns " + columns);
		
		DataFormatter format = new DataFormatter(); // to convert any form of data to string
		
		String testdata[][] = new String[rows-1][columns];
		
		for(int row = 1; row<rows; row++)
		{
			for(int column = 0; column <columns; column++)
			{
				System.out.println(sheetName.getRow(row).getCell(column));
				// login[1][0] // login[1][1]
				
				testdata[row-1][column] = format.formatCellValue(sheetName.getRow(row).getCell(column));
				
			}
		}
		return testdata;
	}

}
