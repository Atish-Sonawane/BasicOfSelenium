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

public class Checkbox_Adv_Many {
   WebDriver driver;

   @BeforeTest
   public void setup() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("https://cosmocode.io/automation-practice-webtable/");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   }

   public static boolean isArray(String[] countries, String searchString) {
      for(int i = 0; i < countries.length; ++i) {
         if (countries[i].equals(searchString)) {
            return true;
         }
      }

      return false;
   }

   @Test
   public void test() {
      String[] countries = new String[]{"Argentina", "Australia", "India"};
      List<WebElement> rows = driver.findElements(By.xpath("//table[@id='countries']//tr"));
      Iterator var4 = rows.iterator();

      while(var4.hasNext()) {
         WebElement row = (WebElement)var4.next();
         List<WebElement> cols = row.findElements(By.tagName("td"));
         String country = ((WebElement)cols.get(1)).getText();
         if (isArray(countries, country)) {
            WebElement cols1 = (WebElement)cols.get(0);
            cols1.findElement(By.className("hasVisited")).click();
            String capital = ((WebElement)cols.get(2)).getText();
            String currency = ((WebElement)cols.get(3)).getText();
            String languages = ((WebElement)cols.get(4)).getText();
            System.out.println(country + " " + capital + " " + currency + " " + languages);
         }
      }

   }

   @AfterTest
   public void teardown() {
      driver.close();
   }
}