package SeleniumBasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excel_data_login {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws IOException {
		String filepath = ".\\datafile\\IDVI.xlsx";
		FileInputStream fi = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sh = wb.getSheet("Sheet1");
		int rows = sh.getLastRowNum()- sh.getFirstRowNum();

			String user = sh.getRow(1).getCell(0).getStringCellValue();
			String pass = sh.getRow(1).getCell(1).getStringCellValue();

			driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(user);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
			driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}

	@AfterTest
	public void teardown() {
		 driver.close();
	}

}
