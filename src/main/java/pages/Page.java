package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

abstract class Page {

    private final WebDriver driver;
    private final String url;


    private final Wait<WebDriver> wait; //fluentWaitet használunk,mert jobban alakítható az igényeinkhez. Wait



     //konstruktor - protected, mert csak a gyerekeket akarom hogy használják. Példányosítani az abstract class miatt sem lehet, ezért itt felesleges protecteden kívül más láthatóságot állítani

    protected Page(String url, WebDriver driver) { //ezeket a paramétereket bekérem, a waitet pedig megcsináljuk itt
        this.url = url;
        this.driver = driver;

        //Listába teszem bele a waitet, így könnyen cserélhető ha szükséges. Ebbe a wait-be nem csak a fluentwait, hanem bármilyen wait használható ami implemetnálja a waitet ha le akarjuk cserélni.
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))                   //builder patternt használok - úgy építek meg egy példányt valamiből, hogy nem kontstruktort hívok és paramétereket adok át, hanem függvényeken keresztül tulajdonságonként megépítem. Így olyan sorrendben adom meg a tulajdonságokat ahogy akarom. Konstruktoron keresztül fix bekérési sorrend van, pl. itt előbb url-t, majd drivert kell megadni.
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);  //a .class az osztálynak a class változóját jelnti
    }

    public final void navigateTo() {
        driver.navigate().to(url);  //a navigate().to megőrzi a browser historyt, a driver.get pedig nem
    }

    public final WebElement findElementOnPage(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }


}
