package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Parameterise_using_Excel {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws IOException, InterruptedException {
		String filepath = ".\\datafile\\IDVI.xlsx";
		FileInputStream fs = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sh = wb.getSheet("Sheet1");
		int rows = sh.getLastRowNum();
		int cols = sh.getRow(1).getLastCellNum();

		System.out.println(rows);
		System.out.println(cols);

		for (int r = 1; r <= rows; r++) {

			String user = sh.getRow(r).getCell(0).getStringCellValue();
			String pass = sh.getRow(r).getCell(1).getStringCellValue();

			WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
			WebElement password = driver.findElement(By.xpath("//input[@id='password']"));

			username.clear();
			Thread.sleep(2000);
			username.sendKeys(user);

			password.clear();
			Thread.sleep(2000);
			password.sendKeys(pass);

			driver.findElement(By.xpath("//input[@id='login-button']")).click();
			Thread.sleep(2000);

			driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.findElement(By.id("logout_sidebar_link")).click();

		}
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}