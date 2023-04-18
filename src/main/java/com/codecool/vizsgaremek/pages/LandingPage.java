package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends Page {
    public LandingPage(WebDriver driver) {
        super(PagesUrl.LANDING_PAGE.getUrl(), driver);
    }

    // LOCATORS
    private static final By BUTTON_HOME = By.xpath("//*[@href='https://lennertamas.github.io/roxo/landings']");
    private static final By BUTTON_PROFILE = By.id("profile-btn");
    private static final By TEXT_H1 = By.xpath("//h1");
    private static final By BUTTON_ABOUT_PAGE = By.xpath("//a[text()='About']");
    private static final By BUTTON_GET_IN_TOUCH = By.xpath("//*[@data-text='Get in touch']");

    public void clickHomeButton() {
        findElementOnPage(BUTTON_HOME).click();
    }

    public boolean verifyLogin(){
        return findElementOnPage(BUTTON_PROFILE).isDisplayed();
    }

    public boolean verifyHomeButtonNavigation() {
        return findElementOnPage(TEXT_H1).getText().equals("404");
    }

    public void clickAboutButton() {
        findElementOnPage(BUTTON_ABOUT_PAGE).click();
    }

    public void clickGetInTouchButton() {
        findElementOnPage(BUTTON_GET_IN_TOUCH).click();
    }
}
