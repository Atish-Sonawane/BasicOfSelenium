package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Z_Setupall {
   WebDriver driver;

   @BeforeTest
   public void setup() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("");
      //driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   }

   @Test
   public void test() {
   }

   @AfterTest
   public void teardown() {
      //driver.close();
   }
}