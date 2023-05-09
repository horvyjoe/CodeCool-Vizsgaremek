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


    //konstruktor - protected, mert csak a gyerekeket akarom hogy használják. Példányosítani az abstract class miatt sem lehet,
    // ezért itt felesleges protecteden kívül más láthatóságot állítani

    protected Page(String url, WebDriver driver) { //ezeket a paramétereket bekérem
        this.url = url;
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    @Step("Navigate to URL")
    public final void navigateTo() {
        driver.navigate().to(url);  //a navigate().to megőrzi a browser historyt, a driver.get pedig nem
    }

    public final WebElement findElementOnPage(By locator) {
        return driver.findElement(locator);
    }
    public final List<WebElement> findElementsOnPage(By locator) {
        return driver.findElements(locator);
    }

    @Step("Click 'Accept' button in alert box")
    public void AcceptAlert() {
        driver.switchTo().alert().accept();
    }

    @Step("Read 'Alert' text")
    public String GetAlertText() {
        return driver.switchTo().alert().getText();
    }

    @Step("Click 'back' button in browser")
    public  void navigateBackBrowser() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.history.go(-1)");
    }

}
