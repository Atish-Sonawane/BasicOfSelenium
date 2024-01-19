 package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frame {
   WebDriver driver;

   @BeforeTest
   public void setuup() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
      //driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   }

   @Test
   public void test() throws InterruptedException {
	  
      driver.switchTo().frame("iframeResult");
      driver.findElement(By.xpath("// button[@onclick = 'myFunction()']")).click();
      String alertText = driver.switchTo().alert().getText();
      System.out.println(alertText);
      driver.switchTo().alert().accept();
      driver.switchTo().parentFrame();
      driver.getTitle();    
   }

   @AfterTest
   public void teardown() {
      driver.close();
   }
}