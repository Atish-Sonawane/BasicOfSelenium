package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButton {
   WebDriver driver;

   @BeforeTest
   public void setup() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("https://cosmocode.io/automation-practice/");
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   }

   @Test
   public void test() throws InterruptedException {
      WebElement male = driver.findElement(By.xpath("//input[@name='gender' and @value='Male']"));
      WebElement female = driver.findElement(By.xpath("//input[@name='gender' and @value='Female']"));
      
      if(male.isEnabled()) {
    	  male.click();
    	  System.out.println("select male");
      }
      
      Thread.sleep(2000);
      
      if(female.isSelected()==false) {
    	  female.click();
    	  System.out.println("select female");
      }
      
   }
   
   @AfterTest
   public void teardown() {
       driver.close();
   }
}