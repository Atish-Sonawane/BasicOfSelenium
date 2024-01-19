package SeleniumBasics;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicit_Wait_DynamicElement {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com.au/");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		//WebElement element = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/a"));
		//Actions action = new Actions(driver);
		//action.moveToElement(element).perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"s0-1-0-39-1-3-4-0[4]-10-@match-media-0-@ebay-carousel-list\"]/li[1]/a/h3")));
		driver.findElement(
				By.xpath("//*[@id=\"s0-1-0-39-1-3-4-0[4]-10-@match-media-0-@ebay-carousel-list\"]/li[1]/a/h3")).click();
	}

	@AfterTest
	public void teardown() {
		// driver.close();
	}

}
