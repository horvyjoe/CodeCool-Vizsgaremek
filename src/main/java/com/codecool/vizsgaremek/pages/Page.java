package com.codecool.vizsgaremek.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

abstract class Page {
    private final WebDriver driver;
    private final String url;


    //CONSTRUCTOR - protected, mert csak a gyerekeket akarom hogy használják. Példányosítani az abstract class miatt sem lehet, ezért itt felesleges protecteden kívül más láthatóságot állítani

    protected Page(String url, WebDriver driver) {
        this.url = url;
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }


    // FUNCTIONS
    @Step("Navigate to URL")
    public final void navigateTo() {
        driver.navigate().to(url);
    }

    public final WebElement findElementOnPage(By locator) {
        return driver.findElement(locator);
    }
    public final List<WebElement> findElementsOnPage(By locator) {
        return driver.findElements(locator);
    }

    @Step("Click 'Accept' button in alert box")
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    @Step("Read 'Alert' text")
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    @Step("Click 'back' button in browser")
    public  void navigateBackBrowser() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.history.go(-1)");
    }

}
