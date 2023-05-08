package testUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//Mivel webDrivert minden tesztnél használok, így egyszerűbb ha itt hozom létre és nem tesztClassonként
public class WebDriverFactory {


    private WebDriverFactory() {}

    public static WebDriver getWebDriver() {
        ChromeOptions options = new ChromeOptions();
        new ChromeOptions();

        options.addArguments("window-size=1280,800");
        options.addArguments("incognito");
        options.addArguments("disable-extensions");
        options.addArguments("remote-allow-origins=*");
        options.addArguments("disable-dev-shm-usage");
        options.addArguments("no-sandbox");
        options.addArguments("headless=new");

        return new ChromeDriver(options);
    }
}

