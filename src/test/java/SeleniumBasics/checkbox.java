package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class checkbox {
   WebDriver driver;

   @BeforeTest
   public void setup() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("https://cosmocode.io/automation-practice/");
      driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
   }

   @Test
   public void test() {
      boolean ba = driver.findElement(By.name("language_java")).isSelected();
      System.out.println(ba);
      driver.findElement(By.name("language_java")).click();
      boolean ba1 = driver.findElement(By.name("language_java")).isSelected();
      System.out.println(ba1);
   }

   @AfterTest
   public void teardown() {
      driver.close();
   }
}