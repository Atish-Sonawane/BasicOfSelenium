package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Windows_Tabs_Handle {
   WebDriver driver;

   @BeforeTest
   public void setup() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("https://text-compare.com/");
      //driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   }

   @Test
   public void test() throws AWTException, InterruptedException {
	   Robot r = new Robot();
	   r.keyPress(KeyEvent.VK_CONTROL);
	   r.keyPress(KeyEvent.VK_T);
	   r.keyPress(KeyEvent.VK_CONTROL);
	   r.keyPress(KeyEvent.VK_T);
	   
	   Set<String> windowhandle = driver.getWindowHandles();
	   System.out.println("no. of open window " + windowhandle.size());
	   for(String handle : windowhandle) {
		   driver.switchTo().window(handle);
		  String url = driver.getCurrentUrl();
		  System.out.println(url);
		  
		  if(url.equals("https://text-compare.com/")) {
			  break;
		  }
	   }
	   
   }

   @AfterTest
   public void teardown() {
      //driver.close();
   }
}