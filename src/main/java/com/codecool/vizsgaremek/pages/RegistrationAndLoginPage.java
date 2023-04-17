package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationAndLoginPage extends Page{

    public RegistrationAndLoginPage(WebDriver driver) {
        super(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver);
    }

    // LOCATORS
    // - Terms and conditions
    private static final By BUTTON_ACCEPT_TERMS_AND_CONDITIONS = By.id("terms-and-conditions-button");
    private static final By BUTTON_REGISTER = By.id("register-form-button");
    private static final By POPUP_TERMS_AND_CONDITIONS = By.className("popup");

    // - Register new user
    private static final By FIELD_EMAIL_TO_REGISTER = By.id("register-email");

    // - Login
    private final String username = "lovasia";
    private final String password = "kispal123";
    private static final By BUTTON_LOGIN_TAB = By.xpath("//*[@id='register']//*[@id='login-form-button']");
    private static final By FIELD_USERNAME = By.id("email");
    private static final By FIELD_PASSWORD = By.id("password");
    private static final By BUTTON_LOGIN = By.xpath("//*[@onclick='myFunction()']");

    // Terms and conditions function

    public void clickAcceptTermsAndConditionsButton() {
        findElementOnPage(BUTTON_ACCEPT_TERMS_AND_CONDITIONS).click();
    }

    public boolean validateTermsAndConditionsPopupIsDisplayed() {
        return findElementOnPage(POPUP_TERMS_AND_CONDITIONS).isDisplayed();
    }

    // Register new user function

    public void clickRegisterButton() {
        findElementOnPage(BUTTON_REGISTER).click();
    }

    public boolean validateRegisterWindow () {
        return findElementOnPage(FIELD_EMAIL_TO_REGISTER).isDisplayed();
    }

    public void login(String username, String password) {
        findElementOnPage(BUTTON_LOGIN_TAB).click();
        findElementOnPage(FIELD_USERNAME).sendKeys(username);
        findElementOnPage(FIELD_PASSWORD).sendKeys(password);
        findElementOnPage(BUTTON_LOGIN).click();
    }

    // OVERLOAD
    public void login(){
        login(username, password);
    }
}
