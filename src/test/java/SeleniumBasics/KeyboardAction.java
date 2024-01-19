package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeyboardAction {
   WebDriver driver;

   @BeforeTest
   public void setup() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("https://the-internet.herokuapp.com/key_presses");
      //driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   }

   @Test
   public void test() throws InterruptedException {
	   Actions act = new Actions(driver);
	   
	   act.sendKeys(Keys.ENTER).perform();
	   Thread.sleep(3000);
	   
	   act.sendKeys(Keys.TAB).perform();
	   Thread.sleep(3000);
   }

   @AfterTest
   public void teardown() {
      driver.close();
   }
}