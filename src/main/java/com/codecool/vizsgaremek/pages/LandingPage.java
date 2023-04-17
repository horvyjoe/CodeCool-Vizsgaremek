package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends Page {

    public LandingPage(WebDriver driver) {
        super(PagesUrl.LANDING_PAGE.getUrl(), driver);
    }

    // LOCATORS
    private static final By BUTTON_HOME = By.linkText("//*[@href='https://lennertamas.github.io/roxo/landings']");
    private static final By BUTTON_PROFILE = By.id("profile-btn");

    public void clickHomeButton() {
        findElementOnPage(BUTTON_HOME).click();
    }

    public boolean verifyLogin(){
        return findElementOnPage(BUTTON_PROFILE).isDisplayed();
    }
}
