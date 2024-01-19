package SeleniumBasics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Excel_data {

	@Test
	public void test() throws IOException {
		String filepath = ".\\datafile\\IDVI.xlsx";
		FileInputStream fs = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sh = wb.getSheet("Sheet1");
		int rows = sh.getLastRowNum();
		int cols = sh.getRow(1).getLastCellNum();
		
		System.out.println(rows);
		System.out.println(cols);

		for (int r = 0; r < rows; r++) {
			XSSFRow row = sh.getRow(r);
			
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = row.getCell(c);

				switch (cell.getCellType()) {
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				}
			}
			System.out.println();
		}

	}

}
