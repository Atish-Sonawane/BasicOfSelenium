package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseAction {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://testingbot.com/");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {

		Actions ac = new Actions(driver);

		// Find the element we want to interact with
		WebElement freeTrialAction = driver.findElement(By.xpath("//a[@class='button button-trial']"));
		WebElement login = driver.findElement(By.xpath("//a[@class='navigation-link']"));

		// Hover over the element
		ac.moveToElement(login).perform();
		Thread.sleep(2000);

		// Double click on element
		ac.moveToElement(freeTrialAction).click().perform();

	}

	@AfterTest
	public void teardown() {
		// driver.close();
	}
}