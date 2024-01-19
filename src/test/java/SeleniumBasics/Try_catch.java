package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Try_catch {
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
	public void test() throws IOException {
		driver.getTitle();
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
		File destination = new File(".\\Screenshot\\image1.png");
		FileHandler.copy(scr, destination);
		} catch(IOException e) {
			System.out.println("Exception message "+e.getMessage());
		}

	}

	@AfterTest
	public void teardown() { 
		driver.close();
	}
}