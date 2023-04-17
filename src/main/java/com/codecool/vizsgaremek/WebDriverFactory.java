package com.codecool.vizsgaremek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    //mivel webDrivert minden tesztnél használok, így egyszerűbb ha itt hozom létre és nem tesztClassonenként

    private WebDriverFactory() {}

    public static WebDriver getWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}

