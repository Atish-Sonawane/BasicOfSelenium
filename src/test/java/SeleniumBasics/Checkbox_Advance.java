package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Checkbox_Advance {
   WebDriver driver;

   @BeforeTest
   public void setup() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("https://cosmocode.io/automation-practice-webtable/");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
   }

   @Test
   public void test() {
      List<WebElement> rows = driver.findElements(By.xpath("//table[@id='countries']//tr"));
      Iterator var3 = rows.iterator();

      while(true) {
         List cols;
         String country;
         do {
            if (!var3.hasNext()) {
               return;
            }

            WebElement row = (WebElement)var3.next();
            cols = row.findElements(By.tagName("td"));
            country = ((WebElement)cols.get(1)).getText();
         } while(!country.equals("Argentina") && !country.equals("Australia"));

         WebElement cols1 = (WebElement)cols.get(0);
         cols1.findElement(By.className("hasVisited")).click();
         String capital = ((WebElement)cols.get(2)).getText();
         String currency = ((WebElement)cols.get(3)).getText();
         String languages = ((WebElement)cols.get(4)).getText();
         System.out.println(country + " " + capital + " " + currency + " " + languages);
      }
   }

   @AfterTest
   public void teardown() {
      driver.close();
   }
}