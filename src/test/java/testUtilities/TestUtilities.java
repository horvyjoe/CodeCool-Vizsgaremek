package testUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUtilities {

   public void navigateToPreviousPage() {
       WebDriver driver = new ChromeDriver();

      // Visszanavigálás előző oldalra
       driver.navigate().back();

       // WebDriver leállítása
       driver.quit();
   }
}



