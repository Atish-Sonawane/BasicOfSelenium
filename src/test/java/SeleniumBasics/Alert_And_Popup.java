 package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alert_And_Popup {
   WebDriver driver;

   @BeforeTest
   public void setuup() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
   }

   @Test
   public void test() throws InterruptedException {
      driver.switchTo().frame("iframeResult");
      driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
      driver.findElement(By.xpath("//button[@onclick = \"myFunction()\"]")).click();
      driver.switchTo().alert().sendKeys("Testerme");
      Thread.sleep(3000);
      driver.switchTo().alert().accept();
      driver.switchTo().parentFrame();
      System.out.println(driver.getTitle());
   }

   @AfterTest
   public void teardown() {
      driver.close();
   }
}