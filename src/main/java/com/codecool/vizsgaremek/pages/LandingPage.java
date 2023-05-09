package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    private static final By BUTTON_LOGOUT = By.xpath("//*[@onclick='logout()']");
    private static final By BUTTON_BLOG = By.xpath("//*[@class='nav-item']//*[text()='Blog']");

    @Step("Click 'Home' button")
    public void clickHomeButton() {
        findElementOnPage(BUTTON_HOME).click();
    }

    public boolean verifyHomeButtonNavigation() {
        return findElementOnPage(TEXT_H1).getText().equals("404");
    }

    public boolean verifyHomeButtonIsDisplayed(){
        return findElementOnPage(BUTTON_HOME).isDisplayed();
    }

    @Step("Click 'About' button")
    public void clickAboutButton() {
        findElementOnPage(BUTTON_ABOUT_PAGE).click();
    }

    public boolean verifyAboutButtonIsDisplayed(){
        return findElementOnPage(BUTTON_ABOUT_PAGE).isDisplayed();
    }

    @Step("Click 'Get in touch' button")
    public void clickGetInTouchButton() {
        findElementOnPage(BUTTON_GET_IN_TOUCH).click();
    }
    public boolean verifyGetInTouchButtonIsDisplayed(){
        return findElementOnPage(BUTTON_GET_IN_TOUCH).isDisplayed();
    }


    @Step("Click 'Logout' button")
    public void clickLogoutButton(){
        findElementOnPage(BUTTON_LOGOUT).click();
    }

    public boolean verifyLogoutButtonIsDisplayed() {
        return findElementOnPage(BUTTON_LOGOUT).isDisplayed();
    }


    @Step("Click 'Profile' button")
    public void clickProfileButton() {
        findElementOnPage(BUTTON_PROFILE).click();
    }

    @Step("Click 'Blog' button")
    public void clickBlogButton() {
        findElementOnPage(BUTTON_BLOG).click();
    }
    }
