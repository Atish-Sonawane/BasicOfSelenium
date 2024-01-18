package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assert_Equals {
   WebDriver driver;

   @BeforeTest
   public void setup() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("https://www.w3schools.com/");
      driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
   }

   @Test
   public void test() {
      String actualTitle = driver.getTitle();
      String expectedTitle = "W3Schools Online Web Tutorials";
      System.out.println(actualTitle);
      Assert.assertEquals(actualTitle, expectedTitle);
   }

   @AfterTest
   public void teardown() {
      driver.close();
   }
}