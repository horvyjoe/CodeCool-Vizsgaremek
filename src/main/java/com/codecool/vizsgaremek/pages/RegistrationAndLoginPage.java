package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationAndLoginPage extends Page{

    public RegistrationAndLoginPage(WebDriver driver) {
        super(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver);
    }

    // LOCATORS
    // - Register new user
    private static final By FIELD_USERNAME_TO_REGISTER = By.id("register-username");
    private static final By FIELD_PASSWORD_TO_REGISTER = By.id("register-password");
    private static final By FIELD_EMAIL_TO_REGISTER = By.id("register-email");
    private static final By FIELD_DESCRIPTION_TO_REGISTER = By.id("register-description");
    private static final By TAB_REGISTER = By.id("register-form-button");
    private static final By BUTTON_REGISTER = By.xpath("//*[@id=\'register\']//*[@class=\'formGroup\']//*[@class=\'btn2\']");
    private static final By TEXT_USER_REGISTERED = By.id("register-alert");

    // - Login
    private static final String BUILT_IN_USERNAME = "lovasia";
    private static final String BUILT_IN_PASSWORD = "kispal123";
    // private static final By BUTTON_LOGIN_TAB = By.xpath("//*[@id='register']//*[@id='login-form-button']");
    private static final By FIELD_USERNAME = By.id("email");
    private static final By FIELD_PASSWORD = By.id("password");
    private static final By BUTTON_LOGIN = By.xpath("//*[@onclick='myFunction()']");


    // Register new user function

    public void clickRegisterTab() {
        findElementOnPage(TAB_REGISTER).click();
    }

    public boolean validateRegisterWindow () {
        return findElementOnPage(FIELD_EMAIL_TO_REGISTER).isDisplayed();
    }

    public void performRegistration(String username, String password, String email, String description) {
        findElementOnPage(FIELD_USERNAME_TO_REGISTER).sendKeys(username);
        findElementOnPage(FIELD_PASSWORD_TO_REGISTER).sendKeys(password);
        findElementOnPage(FIELD_EMAIL_TO_REGISTER).sendKeys(email);
        findElementOnPage(FIELD_DESCRIPTION_TO_REGISTER).sendKeys(description);
        findElementOnPage(BUTTON_REGISTER).click();
    }

    public boolean verifyRegistrationIsSuccessful(){
        return findElementOnPage(TEXT_USER_REGISTERED).isDisplayed();
    }

    public void clickRegisterButton() {
        findElementOnPage(BUTTON_REGISTER).click();
    }

    //Login functions

    public void login(String username, String password) {
        findElementOnPage(FIELD_USERNAME).sendKeys(username);
        findElementOnPage(FIELD_PASSWORD).sendKeys(password);
        findElementOnPage(BUTTON_LOGIN).click();
    }

    // OVERLOAD
    public void login(){
        login(BUILT_IN_USERNAME, BUILT_IN_PASSWORD);
    }
}
