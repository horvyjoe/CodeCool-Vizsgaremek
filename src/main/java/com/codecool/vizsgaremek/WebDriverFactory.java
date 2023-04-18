package com.codecool.vizsgaremek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    //mivel webDrivert minden tesztnél használok, így egyszerűbb ha itt hozom létre és nem tesztClassonenként

    private WebDriverFactory() {}

    public static WebDriver getWebDriver() {
        ChromeOptions options = new ChromeOptions();
        new ChromeOptions();
        options.addArguments("--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-extensions",
                "incognito",
                "window-size=1280,800",
                "--headless");
        /*options.addArguments("window-size=1280,800");
        options.addArguments("incognito");
        options.addArguments("disable-extensions");
        options.addArguments("remote-allow-origins=*");
        options.addArguments("disable-dev-shm-usage");
        options.addArguments("no-sandbox");
        options.addArguments("headless");*/
        //WebDriver driver = new ChromeDriver(options);
        //return driver;
        return new ChromeDriver(options);
    }
}

